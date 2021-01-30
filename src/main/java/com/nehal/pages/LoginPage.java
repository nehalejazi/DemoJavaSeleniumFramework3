package com.nehal.pages;

import com.nehal.drivers.DriverManager;
import org.openqa.selenium.By;

public class LoginPage {

    private final By lp_email_element = By.xpath("//input[@class='email']");
    private final By lp_password_element = By.xpath("//input[@class='password']");
    private final By lp_loginbutton_element = By.xpath("//input[@type='submit'][@value='Log in']");

    public String getLoginPageTitle()
    {
       return DriverManager.getDriver().getTitle();
    }

    public LoginPage enterUserName(String uname)
    {
        DriverManager.getDriver().findElement(lp_email_element).sendKeys(uname);
        return this;
    }
    public LoginPage enterPassword(String pwd)
    {
        DriverManager.getDriver().findElement(lp_password_element).sendKeys(pwd);
        return this;
    }
    public HomePage clickOnLoginButton()
    {
        DriverManager.getDriver().findElement(lp_loginbutton_element).click();
        return new HomePage();

    }




}
