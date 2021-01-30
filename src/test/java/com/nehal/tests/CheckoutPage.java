package com.nehal.tests;

import com.nehal.drivers.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public final class CheckoutPage extends TestBase{
    private CheckoutPage()
    {

    }

    @Test
    public void chekoutPage() throws InterruptedException, IOException {
        DriverManager.getDriver().findElement(By.xpath("//a[@class=\"ico-login\"]")).click();
        DriverManager.getDriver().findElement(By.xpath("//input[@class='email']")).sendKeys("test323@testing.com");
        DriverManager.getDriver().findElement(By.xpath("//input[@class='password']")).sendKeys("India321");
        DriverManager.getDriver().findElement(By.xpath("//input[@type='submit'][@value='Log in']")).click();

        Actions action = new Actions(DriverManager.getDriver());
        action.moveToElement(DriverManager.getDriver().findElement(By.xpath("//ul[@class='top-menu']//a[normalize-space()='Computers']"))).build().perform();
        DriverManager.getDriver().findElement(By.xpath("//ul[@class='top-menu']//li[2]//a[normalize-space()='Desktops']")).click();
        List<WebElement> listofProducts = DriverManager.getDriver().findElements(By.xpath("//h2[@class='product-title']"));
        for (WebElement a : listofProducts) {
            if (a.getText().equals("Build your own expensive computer")) {
                WebElement product = DriverManager.getDriver().findElement(By.xpath("//a[text()='" + a.getText() + "']//parent::h2[@class='product-title']//following-sibling::div[@class='add-info']//div[@class='buttons']"));
                product.click();
            }
        }
        Thread.sleep(30000);
        //Processor Type all options considered
        String processorType = "Fast";
        if (processorType.equals("Slow")) {
            DriverManager.getDriver().findElement(By.xpath("//input[@id='product_attribute_74_5_26_80']")).click();
        } else if (processorType.equals("Medium")) {
            DriverManager.getDriver().findElement(By.xpath("//input[@id='product_attribute_74_5_26_81']")).click();
        } else if (processorType.equals("Fast")) {
            DriverManager.getDriver().findElement(By.xpath("//input[@id='product_attribute_74_5_26_82']")).click();
        }

        //RAM Type all options considerd

        String RAMType = "4GB";
        if (RAMType.equals("2GB")) {
            DriverManager.getDriver().findElement(By.xpath("//input[@id='product_attribute_74_6_27_83']")).click();
        } else if (RAMType.equals("4GB")) {
            DriverManager.getDriver().findElement(By.xpath("//input[@id='product_attribute_74_6_27_84']")).click();
        } else if (RAMType.equals("8GB")) {
            DriverManager.getDriver().findElement(By.xpath("//input[@id='product_attribute_74_6_27_85']")).click();
        }

        //HDD Type all options considerd

        String HDDType = "400GB";
        if (HDDType.equals("320GB")) {
            DriverManager.getDriver().findElement(By.xpath("//input[@id='product_attribute_74_3_28_86']")).click();
        } else if (HDDType.equals("400GB")) {
            DriverManager.getDriver().findElement(By.xpath("//input[@id='product_attribute_74_3_28_87']")).click();
        }

        //Software all options considerd

        String SoftwareType = "Office Suite";
        if (SoftwareType.equals("Image Viewer")) {
            DriverManager.getDriver().findElement(By.xpath("//input[@id='product_attribute_74_8_29_88']")).click();
        } else if (SoftwareType.equals("Office Suite")) {
            DriverManager.getDriver().findElement(By.xpath("//input[@id='product_attribute_74_8_29_89']")).click();
        } else if (SoftwareType.equals("Other Office Suite")) {
            DriverManager.getDriver().findElement(By.xpath("//input[@id='product_attribute_74_8_29_89']")).click();
        }

        //Enterd Quanituy
        DriverManager.getDriver().findElement(By.xpath("//input[@id='addtocart_74_EnteredQuantity']")).clear();
        DriverManager.getDriver().findElement(By.xpath("//input[@id='addtocart_74_EnteredQuantity']")).sendKeys("3");
        DriverManager.getDriver().findElement(By.xpath("//input[@id='add-to-cart-button-74']")).click();

        Thread.sleep(30000);
        //shoppingCartHoverTest()

        Actions shoppingcartaction = new Actions(DriverManager.getDriver());
        shoppingcartaction.moveToElement(DriverManager.getDriver().findElement(By.xpath("//span[normalize-space()='Shopping cart']"))).build().perform();
        //Printing details in console
        String productnameinCart = DriverManager.getDriver().findElement(By.xpath("//div[@class='product']//div[@class='name']/a")).getText();
        System.out.println("product name found in cart: " + productnameinCart);
        String totalincart = DriverManager.getDriver().findElement(By.xpath("//div[@class='mini-shopping-cart']//strong")).getText();
        System.out.println("Tpta; price found in cart: " + totalincart);
        DriverManager.getDriver().findElement(By.xpath("//input[@value='Go to cart']")).click();
        Thread.sleep(15000);
        //Validation in Shopping in Cart
        System.out.println("Title of shopping cart page is found as: "+DriverManager.getDriver().getTitle());
        String productnameinshoppingcartpage= DriverManager.getDriver().findElement(By.xpath("//a[@class='product-name']")).getText();
        Assert.assertEquals(productnameinshoppingcartpage,productnameinCart);
        String totalinshoppingcartpage = DriverManager.getDriver().findElement(By.xpath("//span[@class='product-price order-total']//strong")).getText();
        Assert.assertEquals(totalinshoppingcartpage,totalincart);
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
        String orderno = DriverManager.getDriver().findElement(By.xpath("//ul[@class='details']//li[contains(text(),'Order number')]")).getText().substring(14);
        System.out.println("Order Number is created: "+orderno);



    }
}
