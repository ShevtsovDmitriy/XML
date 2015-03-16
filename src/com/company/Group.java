package com.company;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created by Дмитрий on 16.03.2015.
 */

@XmlRootElement(name = "Group")
@XmlAccessorType(XmlAccessType.FIELD)
public class Group {

    @XmlElement(name = "student")
    private ArrayList<Student> students;

    public Group(){

    }
    public Group(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
}
