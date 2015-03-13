package com.company;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


public class MyParser extends DefaultHandler {

    private HashMap<String, String> student = new HashMap<String, String>();
    private boolean isStudent = false;
    private String currentName;

    public ArrayList<Student> students = new ArrayList<Student>();



    @Override
    public void startElement(String uri, String localName, String qName,Attributes attributes) throws SAXException {
        //System.out.println("Тег: "+qName);
        //if(qName.equals("class"))
            //System.out.println("класс"+attributes.getValue("name"));

        if (isStudent)
            currentName = qName;
        if (qName.equals("student"))
            isStudent = true;



    }

    @Override
    public void characters(char[] c, int start, int length) throws SAXException{
        char[] buf = new char[length];
        int j = 0;
        for(int i=start;i< start+length;++i) {
            //System.out.print(c[i]);
            buf[j] = c[i];
            j++;
        }
        String val = new String(buf);
        //System.out.print("...val is " + val + currentName + "...");
        student.put(currentName, val);
        currentName = "added";



    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //System.out.println("Тег разобран: "+qName);
        if (qName.equals("student")) {
            isStudent = false;
            addStud();
        }
    }

    @Override
    public void startDocument() throws SAXException {
        //System.out.println("Начало разбора документа!");
        super.startDocument();
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        //System.out.println("Разбор документа окончен!");
    }

    private void addStud(){
        SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");
        String dateStr = student.get("day") + " " + student.get("month") + " " + student.get("year");
        try {
            Date date = format.parse(dateStr);
            int course = Integer.parseInt(student.get("course"));
            students.add(new Student(student.get("fio"), date, course));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        student.clear();


    }



}
