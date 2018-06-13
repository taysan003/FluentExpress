package com.express;

import com.express.base.BaseTest;
import com.express.pages.MainPage;
import com.express.pages.ProfilePage;
import com.express.pages.SignUpWorkPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {
    @Test
    public void positiveSignUp() {

        MainPage mainPage = new MainPage(driver);
        String expectedPageTitle = "Activate your account";
        mainPage.mainPage();
        SignUpWorkPage signUpWorkPage = mainPage.pushSignUpButton();

        System.out.println("Verifications");
        signUpWorkPage.fillUpEmailAndPassword("kostuchenko-and@mail.ru","Kostuchenko0");
        signUpWorkPage.waitForSignUpPageToLoad();
        signUpWorkPage.waitForSignUpFinalPageToLoad();
        signUpWorkPage.pushSignUpButtonInWorkPage();
        System.out.println("Verifications");
        String actualTitle = signUpWorkPage.getTitle();
       signUpWorkPage.waitForSignUpFinalPageToLoad();
        Assert.assertTrue(expectedPageTitle.equals(actualTitle),"Page title is not expected.\n Expected: " + expectedPageTitle + "\nActual: " + actualTitle);

}

    @Test
    public void correctSignUpTitle() {

        MainPage mainPage = new MainPage(driver);
        String expectedPageTitle = "Sign up";
        mainPage.mainPage();
        SignUpWorkPage signUpWorkPage = mainPage.pushSignUpButton();
        signUpWorkPage.waitForSignUpPageToLoad();
        System.out.println("Verifications");
        String actualTitle = signUpWorkPage.getTitle();
        Assert.assertTrue(expectedPageTitle.equals(actualTitle),"Page title is not expected.\n Expected: "
                + expectedPageTitle + "\nActual: " + actualTitle);

    }

    /*@Test
    public void correctCloseWorkPage() {

        MainPage mainPage = new MainPage(driver);
        String expectedPageTitle = "fluent.express";
        mainPage.mainPage();
        SignUpWorkPage signUpWorkPage = mainPage.pushSignUpButton();
        signUpWorkPage.waitForSignUpPageToLoad();
        System.out.println("Verifications");
        signUpWorkPage.pushCloseSign();
        String actualTitle = signUpWorkPage.getTitle();
        Assert.assertTrue(expectedPageTitle.equals(actualTitle),"Page title is not expected.\n Expected: "
                + expectedPageTitle + "\nActual: " + actualTitle);

    }*/
}
