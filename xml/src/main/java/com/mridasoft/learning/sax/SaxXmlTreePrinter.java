package com.mridasoft.learning.sax;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import com.mridasoft.learning.dom.Xmls;

public class SaxXmlTreePrinter extends DefaultHandler {
	
	private int indent;
	private Map<Integer,String> indentMap = new HashMap<>();
	{
		indentMap.put(0,"");
		indentMap.put(1,"  ");
		indentMap.put(2,"   ");
		indentMap.put(3,"    ");
		indentMap.put(4,"     ");
		indentMap.put(5,"      ");
	}

	public static void main(String[] args) {

		SAXParserFactory factory = SAXParserFactory.newInstance();
		DefaultHandler handler = new SaxXmlTreePrinter();
		SAXParser saxParser;
		try {
			saxParser = factory.newSAXParser();
			saxParser.parse(new InputSource(new StringReader(Xmls.xmlString)), handler);
		} catch (ParserConfigurationException|SAXException | IOException e) {
			e.printStackTrace();
		}

	}

	public void startDocument() throws SAXException {
		
	}

	public void endDocument() throws SAXException {
		
	}

	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		
		indent++;
		
		// Output Event Type and Element Name

		System.out.print(indentMap.get(indent) + "<" + qName);
		if(attributes.getLength()>0){
			System.out.print("[");
			// Output Element Attributes
			for (int i = 0; i < attributes.getLength(); i++) {
				System.out.print(attributes.getQName(i)+"="+attributes.getValue(i));
			}
			System.out.print("]");
		}
		System.out.println(">");
	}

	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		
		// Output Event Type
		System.out.println(indentMap.get(indent) + "</" + qName+">");
		
		indent--;
	}

	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// Output Event Type and Text
		String str = (new String(ch, start, length));
		System.out.println(indentMap.get(indent)+str);
	}

	// Error Handling
	public void error(SAXParseException e) throws SAXException {
		System.out.println("Error: " + e.getMessage());
	}

	public void fatalError(SAXParseException e) throws SAXException {
		System.out.println("Fatal Error: " + e.getMessage());
	}

	public void warning(SAXParseException e) throws SAXException {
		System.out.println("Warning: " + e.getMessage());
	}
}
