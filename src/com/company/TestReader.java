package com.company;


import org.w3c.dom.*;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by Дмитрий on 11.03.2015.
 */
public class TestReader {

    public static void read() {
        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        Document doc;
        Element root;
        try {
            builder = f.newDocumentBuilder();
            doc = builder.parse(new File("1.xml"));
            root = doc.getDocumentElement();

            printDomTree(doc);

            /*
            System.out.println(root.getNodeName());
            NodeList nl = root.getChildNodes();


            for (int i=0;i<nl.getLength();i++){

                Node n = nl.item(i);

                if( n instanceof Element) {

                    Element element = (Element)n;

                    System.out.println(element.getAttribute("name"));

                    NodeList nl_e = element.getElementsByTagName("comment");

                    for(int j=0;j<nl_e.getLength();j++){

                        if (nl_e.item(j) instanceof Element){

                            System.out.println(

                                    nl_e.item(j).getFirstChild().getNodeValue());

                        }

                    }

                }}


*/


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static void printDomTree(Node node) {

        int type = node.getNodeType();

        switch (type) {

            case Node.DOCUMENT_NODE: {

                System.out.println("<?xml version=\"1.0\" ? >");

                printDomTree(((Document) node).getDocumentElement());

                break;
            }

            case Node.ELEMENT_NODE: {

                System.out.print("<");

                System.out.print(node.getNodeName());

                NamedNodeMap attrs = node.getAttributes();

                for (int i = 0; i < attrs.getLength(); i++)

                    printDomTree(attrs.item(i));

                System.out.print(">");

                if (node.hasChildNodes()) {

                    NodeList children = node.getChildNodes();

                    for (int i = 0; i < children.getLength(); i++)

                        printDomTree(children.item(i));
                }

                System.out.print("</");

                System.out.print(node.getNodeName());

                System.out.print(">");
                break;
            }
            case Node.ATTRIBUTE_NODE:

            {

                if (!node.getNodeName().equals("name"))

                    System.out.print(" " + node.getNodeName() + "=\"" +

                            ((Attr)node).getValue() + "\"");

                break;

            }

            case Node.TEXT_NODE:

            {

                System.out.print(node.getNodeValue());

                break;

            }
        }

    }
}