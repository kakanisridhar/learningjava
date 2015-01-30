package com.mridasoft.learning.stax;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;


/*
 * Merge individual xmls into one big xml
 */
public class XmlMerger {

	private XMLEventFactory eventFactory = XMLEventFactory.newInstance();
	private XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
	private XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
	{
		xmlInputFactory.setProperty(XMLInputFactory.SUPPORT_DTD, false);
		xmlOutputFactory.setProperty(XMLOutputFactory.IS_REPAIRING_NAMESPACES, true);
	}
	
	private QName mergeRoot;
	
	public XmlMerger(QName mergeRoot) {
		this.mergeRoot = mergeRoot;
	}

	public String merge(List<String> xmls) throws XMLStreamException {

		StringWriter xmlWriter = new StringWriter();

		XMLEventWriter eventWriter = xmlOutputFactory.createXMLEventWriter(xmlWriter);

		XMLEvent newLine = eventFactory.createDTD("\n");
		// Create and write Start Tag
		StartDocument startDocument = eventFactory.createStartDocument();
		eventWriter.add(startDocument);
		eventWriter.add(newLine);
		StartElement configStartElement = eventFactory.createStartElement(
													mergeRoot.getPrefix(),
													mergeRoot.getNamespaceURI(),
													mergeRoot.getLocalPart());
		eventWriter.add(configStartElement);

		for (String xml : xmls) {

			StringReader xmlReader = new StringReader(xml);

			XMLEventReader xmlRepOper = xmlInputFactory.createXMLEventReader(xmlReader);

			while (xmlRepOper.hasNext()) {

				XMLEvent event = xmlRepOper.nextEvent();

				if (event.isStartDocument() || event.isEndDocument())
					continue;

				if(event.isStartElement()){
					StartElement elem = event.asStartElement();
					if(elem.getName().equals(mergeRoot)) continue;
				}

				if(event.isEndElement()){
					EndElement elem = event.asEndElement();
					if(elem.getName().equals(mergeRoot)) continue;
				}

				eventWriter.add(event);
			}

			xmlRepOper.close();
			xmlReader.close();
		}

		eventWriter.add( eventFactory.createEndElement(
								mergeRoot.getPrefix(),
								mergeRoot.getNamespaceURI(),
								mergeRoot.getLocalPart()) );
		eventWriter.add(eventFactory.createEndDocument());
		eventWriter.close();
		xmlWriter.flush();
		return xmlWriter.toString();
	}
}