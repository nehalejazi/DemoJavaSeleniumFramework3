package com.nehal.tests;

import com.nehal.drivers.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public final class ReorderTest extends TestBase{
    private ReorderTest()
    {

    }

    @Test
    public void reorderTest() throws InterruptedException, IOException {
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
        //Generic xpath based on Order No
        DriverManager.getDriver().findElement(By.xpath("//input[@onclick=\"setLocation('/orderdetails/"+orderno+"')\"]")).click();
        System.out.println(DriverManager.getDriver().getTitle());
        DriverManager.getDriver().findElement(By.xpath("//input[@value='Re-order']")).click();
        Thread.sleep(15000);
        //Below is the Xpath created to handle multiple scenarios
        String productnameforreorder = "Build your own expensive computer";
        ////tbody//tr[@class='cart-item-row']/td[3]/a[text()='Build your own expensive computer']//parent::td[@class='product']//following-sibling::td[@class='qty nobr']/input
        DriverManager.getDriver().findElement(By.xpath("//tbody//tr[@class='cart-item-row']/td[3]/a[text()='"+productnameforreorder+"']//parent::td[@class='product']//following-sibling::td[@class='qty nobr']/input")).clear();
        DriverManager.getDriver().findElement(By.xpath("//tbody//tr[@class='cart-item-row']/td[3]/a[text()='"+productnameforreorder+"']//parent::td[@class='product']//following-sibling::td[@class='qty nobr']/input")).sendKeys("2");
        DriverManager.getDriver().findElement(By.xpath("//input[@id='termsofservice']")).click();
        DriverManager.getDriver().findElement(By.xpath("//button[normalize-space()='Checkout']")).click();
        System.out.println("Title of checkout screens is found as "+DriverManager.getDriver().getTitle());
        DriverManager.getDriver().findElement(By.xpath("//input[@onclick='Billing.save()']")).click();
        DriverManager.getDriver().findElement(By.xpath("//input[@onclick='Shipping.save()']")).click();
        DriverManager.getDriver().findElement(By.xpath("//input[@id='shippingoption_1']")).click();
        DriverManager.getDriver().findElement(By.xpath("//input[@onclick='ShippingMethod.save()']")).click();
        DriverManager.getDriver().findElement(By.xpath("//input[@id='paymentmethod_2']")).click();
        DriverManager.getDriver().findElement(By.xpath("//input[@onclick='PaymentMethod.save()']")).click();
        Select select = new Select(DriverManager.getDriver().findElement(By.xpath("//select[@id='CreditCardType']")));
        select.selectByVisibleText("Master card");
        DriverManager.getDriver().findElement(By.xpath("//input[@id='CardholderName']")).sendKeys("Nehal Sir");
        DriverManager.getDriver().findElement(By.xpath("//input[@id='CardNumber']")).sendKeys("5500 0000 0000 0004");
        Select selectExpMonth = new Select(DriverManager.getDriver().findElement(By.xpath("//select[@id='ExpireMonth']")));
        Select selectYear = new Select(DriverManager.getDriver().findElement(By.xpath("//select[@id='ExpireYear']")));
        selectExpMonth.selectByVisibleText("06");
        selectYear.selectByIndex(4);
        DriverManager.getDriver().findElement(By.xpath("//input[@id='CardCode']")).sendKeys("033");
        DriverManager.getDriver().findElement(By.xpath("//input[@onclick='PaymentInfo.save()']")).click();
        Thread.sleep(10000);
        //Code need to be added for scrolling before screenshot
        JavascriptExecutor js = (JavascriptExecutor)DriverManager.getDriver();
        js.executeScript("window.scrollBy(0,500)");
        //Screenshot Code
        File src=  ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
        long time = System.currentTimeMillis();
        FileUtils.copyFile(src, new File("C:/Users/nehal/IdeaProjects/PDemo1/Screenshots/" + "OrderConfirmation_" + time + ".png"));
        DriverManager.getDriver().findElement(By.xpath("//input[@value='Confirm']")).click();
        System.out.println("Titel of Order completion page si : "+DriverManager.getDriver().getTitle());
        String neworderno = DriverManager.getDriver().findElement(By.xpath("//ul[@class='details']//li[contains(text(),'Order number')]")).getText().substring(14);
        System.out.println("Order Number is created: "+neworderno);

    }
}
