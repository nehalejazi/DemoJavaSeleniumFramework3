package com.nehal.tests;

import com.nehal.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public final class OrderCustomerInfo extends TestBase{
    private OrderCustomerInfo()
    {

    }

    @Test
    public void OrderCustomerInfo()
    {
        DriverManager.getDriver().findElement(By.xpath("//a[@class=\"ico-login\"]")).click();
        DriverManager.getDriver().findElement(By.xpath("//input[@class='email']")).sendKeys("test323@testing.com");
        DriverManager.getDriver().findElement(By.xpath("//input[@class='password']")).sendKeys("India321");
        DriverManager.getDriver().findElement(By.xpath("//input[@type='submit'][@value='Log in']")).click();
        DriverManager.getDriver().findElement(By.xpath("//a[@class='account']")).click();
        String customerinforpagetitle = DriverManager.getDriver().getTitle();
        System.out.println("Page title of customer infor page is: "+customerinforpagetitle);
        DriverManager.getDriver().findElement(By.xpath("//ul[@class='list']//a[contains(text(),'Orders')]")).click();
        String customerorderinforpagetitle = DriverManager.getDriver().getTitle();
        System.out.println("Page title of customer infor page is: "+customerorderinforpagetitle);
        String orderno= "856269";
        List<WebElement> listoforders = DriverManager.getDriver().findElements(By.xpath("//div[@class='order-list']//div[@class='title']/strong"));
        for (WebElement a:listoforders) {
            if(a.getText().substring(14).equals(orderno))
            {
                System.out.println("Order verfied successfully");
            }

        }
    }


}
