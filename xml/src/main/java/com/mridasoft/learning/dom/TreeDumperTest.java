package com.mridasoft.learning.dom;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class TreeDumperTest {

	

	static public void main(String[] arg) {
		boolean validate = false;

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setValidating(validate);
		dbf.setNamespaceAware(true);
		dbf.setIgnoringElementContentWhitespace(true);

		Document doc = null;
		try {
			DocumentBuilder builder = dbf.newDocumentBuilder();
			doc = builder.parse(new InputSource(new StringReader(Xmls.xmlString)));
		} catch (SAXException e) {
			System.exit(1);
		} catch (ParserConfigurationException e) {
			System.err.println(e);
			System.exit(1);
		} catch (IOException e) {
			System.err.println(e);
			System.exit(1);
		}

		TreeDumper td = new TreeDumper();
		td.dump(doc);
	}

}
