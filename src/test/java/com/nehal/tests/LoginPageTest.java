package com.nehal.tests;


import com.nehal.pages.HomePage;
import com.nehal.pages.LandingPage;

import com.nehal.pages.LoginPage;
import com.nehal.utils.ReadPropertyFile;
import org.testng.Assert;
import org.testng.annotations.Test;

public final class LoginPageTest extends TestBase{

    private LoginPageTest()
    {

    }

    LandingPage landingPage = new LandingPage();
    LoginPage loginPage = new LoginPage();


    @Test
    public void loginPageTitleTest()
    {
        String loginPagetitle = landingPage.navigateToLoginPage().getLoginPageTitle();
        System.out.println("Login title after login is : "+loginPagetitle );
        Assert.assertEquals(loginPagetitle,"Demo Web Shop. Login");



    }
    @Test
    public void validLoginTest() throws Exception {
        String email = ReadPropertyFile.getValue("email");
        String pwd =ReadPropertyFile.getValue("password");
        landingPage.navigateToLoginPage().enterUserName(email).enterPassword(pwd).clickOnLoginButton();

    }

}
