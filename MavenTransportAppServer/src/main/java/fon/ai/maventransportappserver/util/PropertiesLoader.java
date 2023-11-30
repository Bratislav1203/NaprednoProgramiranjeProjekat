/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.ai.maventransportappserver.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author student
 */
public class PropertiesLoader {
    private Properties properties;
    private static PropertiesLoader instance;
    
    private PropertiesLoader() {
        try {
            properties = new Properties();
            properties.load(new FileInputStream("db.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static PropertiesLoader getInstance() {
        if(instance == null) {
            instance = new PropertiesLoader();
        }
        return instance;
    }
    
    public String getProperty(String key) {
        return properties.getProperty(key, "N/A");
    }
    
    public void setProperty(String key, String value) {
        properties.setProperty(key, value);
    }
    
    public void saveProperties() throws IOException {
        properties.store(new FileOutputStream("db.properties"), "Property sacuvani");
    }
}
