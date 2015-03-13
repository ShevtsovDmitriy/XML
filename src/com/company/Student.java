package com.company;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Дмитрий on 11.03.2015.
 */
public class Student {

    private String fio;
    private Date birthDay;
    private int course;

    public Student(String fio, Date birthDay, int course) {
        this.fio = fio;
        this.birthDay = birthDay;
        this.course = course;
    }

    public Student(String fio, String birthDay, int course) {
        this.fio = fio;
        this.course = course;
        SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");
        try {
            this.birthDay = format.parse(birthDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public Student(String fio) {
        this.fio = fio;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }
}
