package com.nehal.drivers;

import com.nehal.utils.ReadPropertyFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public final class FrameworkDriver {
    private FrameworkDriver()
    {

    }

    public static void initDriver() throws Exception {
        if(Objects.isNull(DriverManager.getDriver())) {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            DriverManager.setDriver(driver);
            DriverManager.getDriver().manage().window().maximize();
            DriverManager.getDriver().manage().deleteAllCookies();
            DriverManager.getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            DriverManager.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            DriverManager.getDriver().get(ReadPropertyFile.getValue("url"));
        }
    }

    public static void quitDriver()
    {
        if(Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
