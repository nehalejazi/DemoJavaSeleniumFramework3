package com.nehal.tests;

import com.nehal.drivers.FrameworkDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class TestBase {

    protected TestBase()
    {

    }

    @BeforeMethod
    protected void setup() throws Exception {
        FrameworkDriver.initDriver();
    }

    @AfterMethod
    protected void tearDown()
    {
      FrameworkDriver.quitDriver();
    }
}
