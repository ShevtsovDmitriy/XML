package com.company;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Main {


    public static void main(String[] args) {

        StudentsWriter sw = new Injector().inject(new StudentsWriter());
        sw.start();


    }
/*
    public static void showAll(){

        ArrayList<Student> st = helper.getAllObjects();
        for (Student stud: st){
            System.out.print(stud.getFio() + "\n");
            System.out.print(stud.getBirthDay() + "\n");
            System.out.print(stud.getCourse() + "\n\n");
        }
    }

    public static void addNewStud(){
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Введите имя");
        String fio = scanner.nextLine();
        System.out.println("Введите дату рождения в формате 'dd MM yyyy'");
        String date = scanner.nextLine();
        System.out.println("Введите курс");
        String course = scanner.nextLine();
        helper.addNew(new Student(fio, date, Integer.parseInt(course)));
        System.out.print("Студент добавлен\n");
    }
    */
}
