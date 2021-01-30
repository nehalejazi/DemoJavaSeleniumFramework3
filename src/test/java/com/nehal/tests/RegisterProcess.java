package com.nehal.tests;

import com.nehal.drivers.DriverManager;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public final class RegisterProcess extends  TestBase{
    private RegisterProcess()
    {

    }

    @Test
    public void validateRegistePageTitle()
    {
        DriverManager.getDriver().findElement(By.xpath("//a[@class='ico-register']")).click();
        String registerPagetitle = DriverManager.getDriver().getTitle();
        System.out.println("Registration page title is found ad: "+registerPagetitle);
        Assert.assertEquals(registerPagetitle,"Demo Web Shop. Register");
    }
    @Test
    public void validateRegistrationProcess()
    {
        DriverManager.getDriver().findElement(By.xpath("//a[@class='ico-register']")).click();
        //List<WebElement> genderelements = DriverManager.getDriver().findElements(By.xpath("//div[@class='gender']//label"));
        String gender = "Female";

            if (gender.equals("Male")) {
                DriverManager.getDriver().findElement(By.xpath("//input[@id='gender-male']")).click();
            } else if (gender.equals("Female")) {
                DriverManager.getDriver().findElement(By.xpath("//input[@id='gender-female']")).click();
            }

        DriverManager.getDriver().findElement(By.xpath("//input[@name='FirstName']")).sendKeys("abcd");
        DriverManager.getDriver().findElement(By.xpath("//input[@id='LastName']")).sendKeys("lastone");
        String email = "test406@testing.com";
        DriverManager.getDriver().findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
        DriverManager.getDriver().findElement(By.xpath("//input[@id='Password']")).sendKeys("India321");
        DriverManager.getDriver().findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("India321");
        DriverManager.getDriver().findElement(By.xpath("//input[@id='register-button']")).click();
        String registrationConfirmation = DriverManager.getDriver().findElement(By.xpath("//div[@class='result']")).getText();
        System.out.println("Registration Confirmation message found as : "+registrationConfirmation);
        Assert.assertEquals(registrationConfirmation,"Your registration completed");
        String loggedInuser = DriverManager.getDriver().findElement(By.xpath("//div[@class='header-links']//a[@class='account']")).getText();
        Assert.assertEquals(loggedInuser,email);



    }
}
