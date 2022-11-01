package com.nehal.pages;

import com.nehal.drivers.DriverManager;
import org.openqa.selenium.By;

public final class LandingPage {

    private final By landingpage_loginlink = By.xpath("//a[@class='ico-login']");

    private final By landingpage_registerlink = By.xpath("//a[@class='ico-register']");

    public String getlandingpagetitle(){
        return DriverManager.getDriver().getTitle();
    }

    public String getLoginlinktext()
    {
       return DriverManager.getDriver().findElement(landingpage_loginlink).getText();
    }

    public String getRegisterlinktext()
    {
        return DriverManager.getDriver().findElement(landingpage_registerlink).getText();
    }
    public LoginPage navigateToLoginPage()
    {
        DriverManager.getDriver().findElement(landingpage_loginlink).click();
        return new LoginPage();
    }
    public RegisterPage navigateToRegisterPage()
    {
        DriverManager.getDriver().findElement(landingpage_registerlink).click();
        return new RegisterPage();
    }

}
