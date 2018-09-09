package com.sliit.ssd.csrfapp.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by dinukshakandasamanage on 9/5/18.
 */
public class PropertyLoader {

    private static volatile PropertyLoader propertyLoader;
    private static Properties properties;
    private static InputStream input = null;

    private PropertyLoader(){
        properties = new Properties();
    }

    public static PropertyLoader getPropertyLoaderInstance(){
        if (propertyLoader == null){
            synchronized (PropertyLoader.class){
                if (propertyLoader == null) {
                    propertyLoader = new PropertyLoader();
                }
            }

        }
        return propertyLoader;
    }

    public static String readProperty(String file, String property){
        try {
            input = new FileInputStream(file);
            properties.load(input);
            return properties.getProperty(property);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
