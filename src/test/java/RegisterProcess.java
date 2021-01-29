import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class RegisterProcess extends  TestBase{

    @Test
    public void validateRegistePageTitle()
    {
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        String registerPagetitle = driver.getTitle();
        System.out.println("Registration page title is found ad: "+registerPagetitle);
        Assert.assertEquals(registerPagetitle,"Demo Web Shop. Register");
    }
    @Test
    public void validateRegistrationProcess()
    {
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        //List<WebElement> genderelements = driver.findElements(By.xpath("//div[@class='gender']//label"));
        String gender = "Female";

            if (gender.equals("Male")) {
                driver.findElement(By.xpath("//input[@id='gender-male']")).click();
            } else if (gender.equals("Female")) {
                driver.findElement(By.xpath("//input[@id='gender-female']")).click();
            }

        driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("abcd");
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("lastone");
        String email = "test406@testing.com";
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("India321");
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("India321");
        driver.findElement(By.xpath("//input[@id='register-button']")).click();
        String registrationConfirmation = driver.findElement(By.xpath("//div[@class='result']")).getText();
        System.out.println("Registration Confirmation message found as : "+registrationConfirmation);
        Assert.assertEquals(registrationConfirmation,"Your registration completed");
        String loggedInuser = driver.findElement(By.xpath("//div[@class='header-links']//a[@class='account']")).getText();
        Assert.assertEquals(loggedInuser,email);



    }
}
