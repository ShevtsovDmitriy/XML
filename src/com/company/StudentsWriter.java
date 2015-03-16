package com.company;

import java.util.ArrayList;

/**
 * Created by Дмитрий on 16.03.2015.
 */
public class StudentsWriter {

    @AutoInjectable
    public XMLHelper helper;

    public void start(){
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Введите действие");
        while (true){
            String answer = scanner.nextLine();
            if (answer.equals("new student")) {
                addNewStud();
            } else if (answer.equals("show all")) {
                showAll();
            } else if (answer.equals("end")) {
                break;
            }
            else {
                System.out.print("Неверная команда\n");
            }
        }
        System.out.print("Работа завершена\n");

    }

    public void showAll(){

        ArrayList<Student> st = helper.getAllObjects();
        for (Student stud: st){
            System.out.print(stud.getFio() + "\n");
            System.out.print(stud.getBirthDay() + "\n");
            System.out.print(stud.getCourse() + "\n\n");
        }
    }

    public void addNewStud(){
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

}
