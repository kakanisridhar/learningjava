package com.mridasoft.learning.dom;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

class ErrorHandlerImpl implements org.xml.sax.ErrorHandler {
	
	public void error(SAXParseException exception) throws SAXException {
		System.out.println("error");
	}

	public void fatalError(SAXParseException exception) throws SAXException {
		System.out.println("fatalError");
	}

	public void warning(SAXParseException exception) throws SAXException {
		System.out.println("warning");
	}
}