import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LandingpageTest extends TestBase {


    @Test
    public void landingPageTitleValidation()
    {
    String title = driver.getTitle();
    System.out.println("Landing Page title is: "+title);
    Assert.assertEquals(title,"Demo Web Shop");
    }

    @Test
    public void loginLinkvalidation()
    {
        String loginLink = driver.findElement(By.xpath("//a[@class='ico-login']")).getText();
        System.out.println("Landing Page login link is found as: "+loginLink);
        Assert.assertEquals(loginLink,"Log in");

    }
    @Test
    public void registerLinkvalidation()
    {
        String registerLink = driver.findElement(By.xpath("//a[@class='ico-register']")).getText();
        System.out.println("Landing Page register link is found as: "+registerLink);
        Assert.assertEquals(registerLink,"Register");
    }
}
