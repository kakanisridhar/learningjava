package com.mridasoft.learning.dom;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class MyDomXmlPrinter {

	public static void main(String[] args) {
		
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();

		DocumentBuilder documentBuilder;
		try {
			documentBuilder = factory.newDocumentBuilder();
			ErrorHandlerImpl errorHandler=new ErrorHandlerImpl();
			documentBuilder.setErrorHandler(errorHandler);
			

			Document document = documentBuilder.parse(new InputSource(new StringReader(Xmls.xmlString)));
			Element rootElement = document.getDocumentElement();
			
	        visitNode(rootElement,0);

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void visitNode(Element visitNode, int indent) {
	      
		 String ind="";
	      for(int i=0;i<indent;i++){
	    	  ind=ind+" ";
	      }
	      
	      System.out.print(ind+"<"+visitNode.getNodeName());
	     
	      // list attributes for an element node
	      if (visitNode.hasAttributes()) {
	          
	          NamedNodeMap attributes = visitNode.getAttributes();
	          System.out.print("[");
	          for (int j = 0; j < attributes.getLength(); j++) {
	             Attr attribute = (Attr) (attributes.item(j));
	             System.out.print(attribute.getName()  + "=" + attribute.getValue());
	          }
	          System.out.print("]");
	      }
	      
	      System.out.println(">");
	      // Obtain a NodeList of nodes in an Element node

	      NodeList nodeList = visitNode.getChildNodes();
	      for (int i = 0; i < nodeList.getLength(); i++) {
	         Node node = nodeList.item(i);
	         // Retrieve Element nodes
	         if (node.getNodeType() == Node.ELEMENT_NODE) {
	            Element element = (Element) node;
	            // Recursive call to visitNode method to process
	            // an Element node hierarchy
	            visitNode(element,indent+1);
	         } else if (node.getNodeType() == Node.TEXT_NODE) {
	             String str = node.getNodeValue().trim();
	             if (str.length() > 0) {
	                System.out.println(ind+str);
	             }
	         }
	      }
	      
	      System.out.println(ind+"</"+visitNode.getNodeName()+">");
	   }
	
}
