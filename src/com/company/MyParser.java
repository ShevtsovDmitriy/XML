package com.company;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by Дмитрий on 11.03.2015.
 */
public class MyParser extends DefaultHandler {

    public enum elementType{Student, Fio, Year, Month, Day, Course }

    public Student[] students;
    private elementType currentElement;

    @Override
    public void startElement(String uri, String localName, String qName,Attributes attributes) throws SAXException {
        System.out.println("Тег: "+qName);
        if(qName.equals("class"))
            System.out.println("класс"+attributes.getValue("name"));
    }

    @Override
    public void characters(char[] c, int start, int length)
            throws SAXException{
        for(int i=start;i< start+length;++i)
            System.out.print(c[i]);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("Тег разобран: "+qName);
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Начало разбора документа!");
        super.startDocument();
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("Разбор документа окончен!");
    }




}
