package com.nehal.tests;

import com.nehal.drivers.DriverManager;
import com.nehal.pages.LandingPage;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public final class LandingpageTest extends TestBase {
 private LandingpageTest() {

 }

    LandingPage lp = new LandingPage();


    @Test
    public void landingPageTitleValidation()
    {
    String title = lp.getlandingpagetitle();
    System.out.println("Landing Page title is: "+title);
    Assert.assertEquals(title,"Demo Web Shop");
    }

    @Test
    public void loginLinkvalidation()
    {
        String loginLink = lp.getLoginlinktext();
        System.out.println("Landing Page login link is found as: "+loginLink);
        //Assert.assertEquals(loginLink,"Log in");
        Assertions.assertThat(loginLink)
                .isNotNull()
                .isNotEmpty()
                .isNotBlank()
                .contains("Log")
                .as("Look like Link may nt be availbe").isEqualTo("Log in");

    }
    @Test
    public void registerLinkvalidation()
    {
        String registerLink = lp.getRegisterlinktext();
        System.out.println("Landing Page register link is found as: "+registerLink);
        Assert.assertEquals(registerLink,"Register");
    }
}
