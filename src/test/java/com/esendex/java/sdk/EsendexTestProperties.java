package com.esendex.java.sdk;

import java.io.*;
import java.util.Properties;

public class EsendexTestProperties {

    private static final EsendexTestProperties instance = new EsendexTestProperties();
    private static final String PROPERTY_FILE_NAME = "esendex_test.properties";

    private Properties properties;

    public EsendexTestProperties() {
        properties = new Properties();
        try {
            InputStream is = getClass().getResourceAsStream("/" + PROPERTY_FILE_NAME);
            if (is == null) throw new FileNotFoundException();
            properties.load(is);
            is.close();
        } catch (IOException e) {
            throw new RuntimeException("Could not load '" + PROPERTY_FILE_NAME + "' is it at the root of the classpath?");
        }
    }
    public static EsendexTestProperties instance() {
        return instance;
    }

    public String getDomain(){
        return properties.getProperty("tests.domain");
    }

    public String getDestinationNumber(){
        return properties.getProperty("tests.destination_number");
    }

    public String getAccount(){
        return properties.getProperty("tests.account");
    }

    public String getPassword(){
        return properties.getProperty("tests.password");
    }

    public String getUsername(){
        return properties.getProperty("tests.username");
    }
}
