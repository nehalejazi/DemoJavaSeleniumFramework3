import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class OrderCustomerInfo extends TestBase{

    @Test
    public void OrderCustomerInfo()
    {
        driver.findElement(By.xpath("//a[@class=\"ico-login\"]")).click();
        driver.findElement(By.xpath("//input[@class='email']")).sendKeys("test323@testing.com");
        driver.findElement(By.xpath("//input[@class='password']")).sendKeys("India321");
        driver.findElement(By.xpath("//input[@type='submit'][@value='Log in']")).click();
        driver.findElement(By.xpath("//a[@class='account']")).click();
        String customerinforpagetitle = driver.getTitle();
        System.out.println("Page title of customer infor page is: "+customerinforpagetitle);
        driver.findElement(By.xpath("//ul[@class='list']//a[contains(text(),'Orders')]")).click();
        String customerorderinforpagetitle = driver.getTitle();
        System.out.println("Page title of customer infor page is: "+customerorderinforpagetitle);
        String orderno= "856269";
        List<WebElement> listoforders = driver.findElements(By.xpath("//div[@class='order-list']//div[@class='title']/strong"));
        for (WebElement a:listoforders) {
            if(a.getText().substring(14).equals(orderno))
            {
                System.out.println("Order verfied successfully");
            }

        }
    }


}
