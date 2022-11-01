package com.nehal.tests;

import com.nehal.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public final class DemoTricentis1 extends TestBase {
    private DemoTricentis1()
    {

    }


    @Test
    public void test1() throws InterruptedException {

        System.out.println("Landing page title is : "+DriverManager.getDriver().getTitle());
        DriverManager.getDriver().findElement(By.xpath("//a[@class=\"ico-login\"]")).click();
        System.out.println("Login page title is : "+DriverManager.getDriver().getTitle());
        //Login parocess
        DriverManager.getDriver().findElement(By.xpath("//input[@class='email']")).sendKeys("test323@testing.com");
        DriverManager.getDriver().findElement(By.xpath("//input[@class='password']")).sendKeys("India321");
        DriverManager.getDriver().findElement(By.xpath("//input[@type='submit'][@value='Log in']")).click();

        //Homepage
        System.out.println("Homepage title after login is : "+DriverManager.getDriver().getTitle());
        Actions action = new Actions(DriverManager.getDriver());
        action.moveToElement(DriverManager.getDriver().findElement(By.xpath("//ul[@class='top-menu']//a[normalize-space()='Computers']"))).build().perform();
        DriverManager.getDriver().findElement(By.xpath("//ul[@class='top-menu']//li[2]//a[normalize-space()='Desktops']")).click();
        System.out.println("Product page title after navigation is : "+DriverManager.getDriver().getTitle());
        //Selecting the product with name as 'Build your own expensive computer'
        //List approach to be reviewed later.
        List<WebElement> listofProducts = DriverManager.getDriver().findElements(By.xpath("//h2[@class='product-title']"));
        listofProducts.forEach(x-> System.out.println(x.getText()));
        for(WebElement a:listofProducts)
        {
            if(a.getText().equals("Build your own expensive computer"))
            {
                WebElement product = DriverManager.getDriver().findElement(By.xpath("//a[text()='"+a.getText()+"']//parent::h2[@class='product-title']//following-sibling::div[@class='add-info']//div[@class='buttons']"));
                product.click();
            }
        }


        //Xpath approach is working fine
        //a[text()='Build your own expensive computer']//parent::h2[@class='product-title']//following-sibling::div[@class='add-info']//div[@class='buttons']
       // String productname = "Build your own expensive computer";
       // WebElement product = DriverManager.getDriver().findElement(By.xpath("//a[text()='"+productname+"']//parent::h2[@class='product-title']//following-sibling::div[@class='add-info']//div[@class='buttons']"));
       // product.click();
       // DriverManager.getDriver().findElement(By.xpath("//a[text()='Build your own cheap computer']//parent::h2[@class='product-title']//following-sibling::div[@class='add-info']//div[@class='buttons']//input")).click();
        System.out.println("Product page title after product selection is  : "+DriverManager.getDriver().getTitle());

        //Edit product page

        DriverManager.getDriver().findElement(By.xpath("//input[@id='product_attribute_74_8_29_89']")).click();
        DriverManager.getDriver().findElement(By.xpath("//input[@id='addtocart_74_EnteredQuantity']")).clear();
        DriverManager.getDriver().findElement(By.xpath("//input[@id='addtocart_74_EnteredQuantity']")).sendKeys("5");
        DriverManager.getDriver().findElement(By.xpath("//input[@id='add-to-cart-button-74']")).click();
        DriverManager.getDriver().findElement(By.xpath("//span[normalize-space()='Shopping cart']")).click();
        Thread.sleep(10000);
        // Pre Checkout Screen
        System.out.println("Title of Pre checkout screens is found as "+DriverManager.getDriver().getTitle());
        DriverManager.getDriver().findElement(By.xpath("//input[@id='termsofservice']")).click();
        DriverManager.getDriver().findElement(By.xpath("//button[@id='checkout']")).click();

        //Checkout screen:
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
        //Need to add a code for screenshot
        DriverManager.getDriver().findElement(By.xpath("//input[@value='Confirm']")).click();

        System.out.println("Titel of Order completion page si : "+DriverManager.getDriver().getTitle());

        //rder Number confirmation

        String orderno=DriverManager.getDriver().findElement(By.xpath("//div[@class='section order-completed']//ul[@class='details']")).getText();
        System.out.println("Order number is : "+orderno);
        DriverManager.getDriver().findElement(By.xpath("//a[normalize-space()='Log out']")).click();


        }


    }

