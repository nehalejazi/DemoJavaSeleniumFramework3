package com.nehal.utils;

import com.nehal.constants.FrameworkConstants;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public final class ReadPropertyFile {

    private ReadPropertyFile()
    {

    }

    private static Properties property = new Properties();

    static {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(FrameworkConstants.getCONFIGFILEPATH());
            property.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String getValue(String key) throws Exception {

        if(Objects.isNull(property.getProperty(key))||Objects.isNull(key))
        {
            throw new Exception("Property name: "+key+" is not found, Please check config.properties file");
        }
        return property.getProperty(key).trim();
    }

}
