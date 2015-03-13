package com.company;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.lang.model.element.ElementVisitor;
import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;


public class DOMHelper implements XMLHelper {

    private File file;
    private Document doc;

    public DOMHelper() {
        this.file = new File("dom.xml");
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(file.length() != 0) {
            DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = null;

            try {
                builder = f.newDocumentBuilder();
                doc = builder.parse(file);
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
                DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder;

                try {
                    builder = f.newDocumentBuilder();
                    doc = builder.newDocument();
                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                }
        }
    }

    @Override
    public void clear() {
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNew(Student src) {
        if (file.length() == 0) {
            Element root = doc.createElement("university");
            doc.appendChild(root);
        }
        Element root = doc.getDocumentElement();
        Element st = doc.createElement("student");
        Element fio = doc.createElement("fio");
        Text fioText = doc.createTextNode(src.getFio());
        Element course = doc.createElement("course");
        Text courseText = doc.createTextNode(String.valueOf(src.getCourse()));

        Calendar cal = Calendar.getInstance();
        cal.setTime(src.getBirthDay());

        Element year = doc.createElement("year");
        Text yearText = doc.createTextNode(String.valueOf(cal.get(Calendar.YEAR)));
        Element month = doc.createElement("month");
        Text monthText = doc.createTextNode(String.valueOf(cal.get(Calendar.MONTH) + 1));
        Element day = doc.createElement("day");
        Text dayText = doc.createTextNode(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)));
        root.appendChild(st);
        st.appendChild(fio);
        st.appendChild(course);
        st.appendChild(year);
        st.appendChild(month);
        st.appendChild(day);
        fio.appendChild(fioText);
        course.appendChild(courseText);
        year.appendChild(yearText);
        month.appendChild(monthText);
        day.appendChild(dayText);

        Transformer t;
        try {
            t = TransformerFactory.newInstance().newTransformer();
            t.transform(new DOMSource(doc), new StreamResult(new FileOutputStream(file)));


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Student> getAllObjects(){
        ArrayList<Student> result = new ArrayList<Student>();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser;
        InputStream xmlData;
        try {
            xmlData= new FileInputStream("dom.xml");
            parser = factory.newSAXParser();
            MyParser myParser = new MyParser();
            parser.parse(xmlData, myParser);
            result = myParser.students;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
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
