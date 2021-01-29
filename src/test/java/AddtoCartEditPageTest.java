import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class AddtoCartEditPageTest extends TestBase{

    @Test
    public void editCartDetail() throws InterruptedException {
        driver.findElement(By.xpath("//a[@class=\"ico-login\"]")).click();
        driver.findElement(By.xpath("//input[@class='email']")).sendKeys("test323@testing.com");
        driver.findElement(By.xpath("//input[@class='password']")).sendKeys("India321");
        driver.findElement(By.xpath("//input[@type='submit'][@value='Log in']")).click();

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//ul[@class='top-menu']//a[normalize-space()='Computers']"))).build().perform();
        driver.findElement(By.xpath("//ul[@class='top-menu']//li[2]//a[normalize-space()='Desktops']")).click();
        List<WebElement> listofProducts = driver.findElements(By.xpath("//h2[@class='product-title']"));
        for(WebElement a:listofProducts)
        {
            if(a.getText().equals("Build your own expensive computer"))
            {
                WebElement product = driver.findElement(By.xpath("//a[text()='"+a.getText()+"']//parent::h2[@class='product-title']//following-sibling::div[@class='add-info']//div[@class='buttons']"));
                product.click();
            }
        }
        Thread.sleep(20000);
        //Processor Type all options considered
        String processorType = "Fast";
        if(processorType.equals("Slow"))
        {
            driver.findElement(By.xpath("//input[@id='product_attribute_74_5_26_80']")).click();
        }else if(processorType.equals("Medium"))
        {
            driver.findElement(By.xpath("//input[@id='product_attribute_74_5_26_81']")).click();
        }else if(processorType.equals("Fast"))
        {
            driver.findElement(By.xpath("//input[@id='product_attribute_74_5_26_82']")).click();
        }

        //RAM Type all options considerd

        String RAMType = "4GB";
        if(RAMType.equals("2GB"))
        {
            driver.findElement(By.xpath("//input[@id='product_attribute_74_6_27_83']")).click();
        }else if(RAMType.equals("4GB"))
        {
            driver.findElement(By.xpath("//input[@id='product_attribute_74_6_27_84']")).click();
        }else if(RAMType.equals("8GB"))
        {
            driver.findElement(By.xpath("//input[@id='product_attribute_74_6_27_85']")).click();
        }

        //HDD Type all options considerd

        String HDDType = "400GB";
        if(HDDType.equals("320GB"))
        {
            driver.findElement(By.xpath("//input[@id='product_attribute_74_3_28_86']")).click();
        }else if(HDDType.equals("400GB"))
        {
            driver.findElement(By.xpath("//input[@id='product_attribute_74_3_28_87']")).click();
        }

        //Software all options considerd

        String SoftwareType = "Office Suite";
        if(SoftwareType.equals("Image Viewer"))
        {
            driver.findElement(By.xpath("//input[@id='product_attribute_74_8_29_88']")).click();
        }else if(SoftwareType.equals("Office Suite"))
        {
            driver.findElement(By.xpath("//input[@id='product_attribute_74_8_29_89']")).click();
        }else if(SoftwareType.equals("Other Office Suite"))
        {
            driver.findElement(By.xpath("//input[@id='product_attribute_74_8_29_89']")).click();
        }

        //Enterd Quanituy
        driver.findElement(By.xpath("//input[@id='addtocart_74_EnteredQuantity']")).clear();
        driver.findElement(By.xpath("//input[@id='addtocart_74_EnteredQuantity']")).sendKeys("3");
        driver.findElement(By.xpath("//input[@id='add-to-cart-button-74']")).click();

        Thread.sleep(20000);
        //shoppingCartHoverTest()

        Actions shoppingcartaction = new Actions(driver);
        shoppingcartaction.moveToElement(driver.findElement(By.xpath("//span[normalize-space()='Shopping cart']"))).build().perform();
        //Printing details in console
        String productnameinCart=driver.findElement(By.xpath("//div[@class='product']//div[@class='name']/a")).getText();
        System.out.println("product name found in cart: "+productnameinCart);
        String itemsincart= driver.findElement(By.xpath("//div[@class='product']//div[@class='attributes']")).getText();
        System.out.println("item names found in cart: "+itemsincart);
        String unitpriceincart=driver.findElement(By.xpath("//div[@class='product']//div[@class='price']//span")).getText();
        System.out.println("unit price found in cart: "+unitpriceincart);
        String quantityincart = driver.findElement(By.xpath("//div[@class='product']//div[@class='quantity']//span")).getText();
        System.out.println("quantity found in cart: "+quantityincart);
        String totalincart = driver.findElement(By.xpath("//div[@class='mini-shopping-cart']//strong")).getText();
        System.out.println("Tpta; price found in cart: "+totalincart);
        driver.findElement(By.xpath("//input[@value='Go to cart']")).click();


    }


}
