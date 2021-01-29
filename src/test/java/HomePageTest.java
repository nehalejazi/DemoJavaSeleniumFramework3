import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomePageTest extends TestBase{

    @Test
    public void hOmepageTitlevalidation()
    {
        driver.findElement(By.xpath("//a[@class=\"ico-login\"]")).click();
        driver.findElement(By.xpath("//input[@class='email']")).sendKeys("test323@testing.com");
        driver.findElement(By.xpath("//input[@class='password']")).sendKeys("India321");
        driver.findElement(By.xpath("//input[@type='submit'][@value='Log in']")).click();
        String homePagetitle = driver.getTitle();
        System.out.println("Homepage title after login is : "+homePagetitle );
        Assert.assertEquals(homePagetitle,"Demo Web Shop");
    }

    @Test
    public void validateLoggedUser()
    {
        driver.findElement(By.xpath("//a[@class=\"ico-login\"]")).click();
        String email = "test323@testing.com";
        driver.findElement(By.xpath("//input[@class='email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@class='password']")).sendKeys("India321");
        driver.findElement(By.xpath("//input[@type='submit'][@value='Log in']")).click();
        String loggedInuser = driver.findElement(By.xpath("//div[@class='header-links']//a[@class='account']")).getText();
        Assert.assertEquals(loggedInuser,email);

    }
    @Test
    public void validatetopMenu()
    {
        driver.findElement(By.xpath("//a[@class=\"ico-login\"]")).click();
        String email = "test323@testing.com";
        driver.findElement(By.xpath("//input[@class='email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@class='password']")).sendKeys("India321");
        driver.findElement(By.xpath("//input[@type='submit'][@value='Log in']")).click();
        List<WebElement> elements = driver.findElements(By.xpath("//ul[@class='top-menu']//div[@class='top-menu-triangle']//preceding-sibling::a"));
        elements.forEach(x-> System.out.println(x.getText()));

    }


}
