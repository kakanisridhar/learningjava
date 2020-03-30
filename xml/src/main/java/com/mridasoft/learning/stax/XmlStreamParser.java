package com.mridasoft.learning.stax;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.xml.sax.InputSource;

import com.mridasoft.learning.dom.Xmls;

public class XmlStreamParser {

	public void parseXMLDocument() {
		try {
			// Create XMLInputFactory object
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			
			// Create XMLStreamReader
			XMLStreamReader xmlStreamReader = inputFactory.createXMLStreamReader(new StringReader(Xmls.xmlString));
			
			// Obtain StAX Parsing Events
			while (xmlStreamReader.hasNext()) {
				int event = xmlStreamReader.next();

				if (event == XMLStreamConstants.START_DOCUMENT) {
					System.out.println("Event Type:START_DOCUMENT");
				}
				if (event == XMLStreamConstants.START_ELEMENT) {
					System.out.println("Event Type: START_ELEMENT");
					// Output Element Local Name
					System.out.println("Element Local Name:"
							+ xmlStreamReader.getLocalName());
					// Output Element Attributes
					for (int i = 0; i < xmlStreamReader.getAttributeCount(); i++) {

						System.out.println("Attribute Local Name:"
								+ xmlStreamReader.getAttributeLocalName(i));
						System.out.println("Attribute Value:"
								+ xmlStreamReader.getAttributeValue(i));
					}

				}

				if (event == XMLStreamConstants.CHARACTERS) {
					System.out.println("Event Type: CHARACTERS");
					System.out.println("Text:" + xmlStreamReader.getText());
				}

				if (event == XMLStreamConstants.END_DOCUMENT) {
					System.out.println("Event Type:END_DOCUMENT");
				}
				if (event == XMLStreamConstants.END_ELEMENT) {
					System.out.println("Event Type: END_ELEMENT");
				}

			}
		} catch (FactoryConfigurationError e) {
			System.out.println("FactoryConfigurationError" + e.getMessage());
		} catch (XMLStreamException e) {
			System.out.println("XMLStreamException" + e.getMessage());
		}

	}

	public static void main(String[] argv) {

		XmlStreamParser staxParser = new XmlStreamParser();
		staxParser.parseXMLDocument();

	}
}