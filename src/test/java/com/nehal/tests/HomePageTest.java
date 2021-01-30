package com.nehal.tests;

import com.nehal.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public final class HomePageTest extends TestBase{
    private HomePageTest()
    { }

    @Test
    public void hOmepageTitlevalidation()
    {
        DriverManager.getDriver().findElement(By.xpath("//a[@class=\"ico-login\"]")).click();
        DriverManager.getDriver().findElement(By.xpath("//input[@class='email']")).sendKeys("test323@testing.com");
        DriverManager.getDriver().findElement(By.xpath("//input[@class='password']")).sendKeys("India321");
        DriverManager.getDriver().findElement(By.xpath("//input[@type='submit'][@value='Log in']")).click();
        String homePagetitle = DriverManager.getDriver().getTitle();
        System.out.println("Homepage title after login is : "+homePagetitle );
        Assert.assertEquals(homePagetitle,"Demo Web Shop");
    }

    @Test
    public void loggedUserValidation()
    {
        String email = "test323@testing.com";
        DriverManager.getDriver().findElement(By.xpath("//input[@class='email']")).sendKeys(email);
        DriverManager.getDriver().findElement(By.xpath("//input[@class='password']")).sendKeys("India321");
        DriverManager.getDriver().findElement(By.xpath("//input[@type='submit'][@value='Log in']")).click();
        String loggedInuser = DriverManager.getDriver().findElement(By.xpath("//div[@class='header-links']//a[@class='account']")).getText();
        Assert.assertEquals(loggedInuser,email);
    }


    @Test
    public void validatetopMenu()
    {
        DriverManager.getDriver().findElement(By.xpath("//a[@class=\"ico-login\"]")).click();
        String email = "test323@testing.com";
        DriverManager.getDriver().findElement(By.xpath("//input[@class='email']")).sendKeys(email);
        DriverManager.getDriver().findElement(By.xpath("//input[@class='password']")).sendKeys("India321");
        DriverManager.getDriver().findElement(By.xpath("//input[@type='submit'][@value='Log in']")).click();
        List<WebElement> elements = DriverManager.getDriver().findElements(By.xpath("//ul[@class='top-menu']//div[@class='top-menu-triangle']//preceding-sibling::a"));
        elements.forEach(x-> System.out.println(x.getText()));

    }


}
