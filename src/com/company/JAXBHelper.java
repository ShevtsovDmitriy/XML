package com.company;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Дмитрий on 16.03.2015.
 */
public class JAXBHelper implements XMLHelper {


    private File file;

    public JAXBHelper() {
        this.file = new File("JAXB.xml");
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
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
        ArrayList<Student> students = getAllObjects();
        students.add(src);
        try {
            JAXBContext jc = JAXBContext.newInstance(Group.class);
            Marshaller m = jc.createMarshaller();


            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            Group gr = new Group(students);
            m.marshal(gr, file);


        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Student> getAllObjects() {
        ArrayList<Student> result = new ArrayList<Student>();
        try {
            JAXBContext jc = JAXBContext.newInstance(Group.class);
            Unmarshaller um = jc.createUnmarshaller();
            Group gr;
            if (file.length() != 0) {
                gr = (Group) um.unmarshal(file);
            }
             else gr = new Group(new ArrayList<Student>());
            result = gr.getStudents();

        } catch (JAXBException e) {
            e.printStackTrace();
        }


        return result;
    }
}
