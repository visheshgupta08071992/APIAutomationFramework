package com.utils;

import com.constants.FrameworkConstants;
import com.enums.PropertiesType;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public final class PropertyUtils {

    private PropertyUtils()  {}
        //Read the content from property file and store it in HashMap
        //Read the content only once and store it in some Java collection

    private static Properties properties = new Properties();
    private static Map<String,String> MAP = new HashMap<>();

    //Written the code of reading properties file and storing in HashMap as Static block execute only once
    //before whole execution starts
         static{
             FileInputStream fileInputStream = null;
             try {
                 fileInputStream = new FileInputStream(FrameworkConstants.getPropertyFilePath());
             } catch (FileNotFoundException e) {
                 e.printStackTrace();
             }
             try {
                 properties.load(fileInputStream);
             } catch (IOException e) {
                 e.printStackTrace();
             }
             properties.entrySet()
                    .forEach(e -> MAP.put(String.valueOf(e.getKey()),String.valueOf(e.getValue())));
        }

        public static String getValue(PropertiesType key){
             return MAP.get(key.name().toLowerCase());
        }
    }

