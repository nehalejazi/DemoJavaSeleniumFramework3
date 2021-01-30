package com.nehal.constants;

public final class FrameworkConstants {
    private FrameworkConstants()
    {

    }


    private static final String CONFIGFILEPATH = System.getProperty("user.dir")+"/src/test/resources/config/config.properties";

    public static String getCONFIGFILEPATH() {
        return CONFIGFILEPATH;
    }

}
