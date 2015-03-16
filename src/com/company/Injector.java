package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * Created by Дмитрий on 16.03.2015.
 */
public class Injector {
    public <T> T inject(T obj){
        Properties prop = new Properties();

        Field[] publicFields = obj.getClass().getFields();



        try {
            prop.load( new FileInputStream(new File("src/com/company/ini.properties")));
            for(Field field : publicFields){
                if (field.getAnnotation(AutoInjectable.class) != null){
                    field.set(obj, Class.forName(prop.getProperty(field.getType().getName())).newInstance());
                }
            }



        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return obj;
    }

}
