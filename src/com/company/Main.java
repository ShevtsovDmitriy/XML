package com.company;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
/*
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser;
        InputStream xmlData= null;
        ArrayList<Student> students = null;
        try {
            xmlData= new FileInputStream("2.xml");
            parser = factory.newSAXParser();
            MyParser myParser = new MyParser();
            parser.parse(xmlData, myParser);
            students = myParser.students;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        DocumentBilder.createDoc();




    }
}
