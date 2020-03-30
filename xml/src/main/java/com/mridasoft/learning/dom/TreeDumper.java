package com.mridasoft.learning.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

class TreeDumper {
    public void dump(Document doc) {
        dumpLoop((Node)doc,"");
    }
    private void dumpLoop(Node node,String indent) {
        switch(node.getNodeType()) {
        case Node.CDATA_SECTION_NODE:
            System.out.println(indent + "CDATA_SECTION_NODE");
            break;
        case Node.COMMENT_NODE:
            System.out.println(indent + "COMMENT_NODE");
            break;
        case Node.DOCUMENT_FRAGMENT_NODE:
            System.out.println(indent + "DOCUMENT_FRAGMENT_NODE");
            break;
        case Node.DOCUMENT_NODE:
            System.out.println(indent + "DOCUMENT_NODE");
            break;
        case Node.DOCUMENT_TYPE_NODE:
            System.out.println(indent + "DOCUMENT_TYPE_NODE");
            break;
        case Node.ELEMENT_NODE:
            System.out.println(indent + "ELEMENT_NODE");
            break;
        case Node.ENTITY_NODE:
            System.out.println(indent + "ENTITY_NODE");
            break;
        case Node.ENTITY_REFERENCE_NODE:
            System.out.println(indent + "ENTITY_REFERENCE_NODE");
            break;
        case Node.NOTATION_NODE:
            System.out.println(indent + "NOTATION_NODE");
            break;
        case Node.PROCESSING_INSTRUCTION_NODE:
            System.out.println(indent + "PROCESSING_INSTRUCTION_NODE");
            break;
        case Node.TEXT_NODE:
            System.out.println(indent + "TEXT_NODE");
            break;
        default:
            System.out.println(indent + "Unknown node");
            break;
        }
        NodeList list = node.getChildNodes();
        for(int i=0; i<list.getLength(); i++)
            dumpLoop(list.item(i),indent + "   ");
    }
}