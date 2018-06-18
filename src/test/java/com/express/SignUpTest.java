package com.express;

import com.express.base.BaseTest;
import com.express.base.CsvDataProvider;
import com.express.pages.MainPage;
import com.express.pages.SignUpWorkPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {

    @Test (priority = 1, groups = { "positive"})
    public void positiveSignUp() {

        MainPage mainPage = new MainPage(driver, log);
        String expectedPageTitle = "Activate your account";
        mainPage.mainPage();
        SignUpWorkPage signUpWorkPage = mainPage.pushSignUpButton();

        log.info("Verifications");
        signUpWorkPage.fillUpEmailAndPassword("kostuchenko-and@mail.ru","Kostuchenko0");
        signUpWorkPage.waitForSignUpPageToLoad();
        signUpWorkPage.waitForSignUpFinalPageToLoad();
        signUpWorkPage.pushSignUpButtonInWorkPage();
        log.info("Verifications");
        String actualTitle = signUpWorkPage.getTitle();
        signUpWorkPage.waitForSignUpFinalPageToLoad();
        Assert.assertTrue(expectedPageTitle.equals(actualTitle),"Page title is not expected.\n Expected: " + expectedPageTitle + "\nActual: " + actualTitle);

    }

    @Test
    public void correctSignUpTitle() {
        MainPage mainPage = new MainPage(driver, log);
        String expectedPageTitle = "Sign up";
        mainPage.mainPage();
        SignUpWorkPage signUpWorkPage = mainPage.pushSignUpButton();
        signUpWorkPage.waitForSignUpPageToLoad();
        log.info("Verifications");
        String actualTitle = signUpWorkPage.getTitle();
        Assert.assertTrue(expectedPageTitle.equals(actualTitle),"Page title is not expected.\n Expected: "
                + expectedPageTitle + "\nActual: " + actualTitle);

    }

    @Test(dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class, priority = 2,
            groups = { "negative"})
    public void negativeSignUp() {
        String expectedErrorMessage = "Email and password fields can't be empty!";
        MainPage mainPage = new MainPage(driver, log);
        mainPage.mainPage();
        SignUpWorkPage signUpWorkPage = mainPage.pushSignUpButton();
        signUpWorkPage.fillUpEmailAndPassword("","");
        signUpWorkPage.pushSignUpButtonInWorkPage();
        String errorMessage = signUpWorkPage.getSignUpErrorMessage();
        Assert.assertTrue(errorMessage.contains(expectedErrorMessage),"Error message is not expected. Expected: " +
                expectedErrorMessage + "\n Actual: " + errorMessage +".");


    }

    /*@Test
    public void correctCloseWorkPage() {

        MainPage mainPage = new MainPage(driver);
        String expectedPageTitle = "fluent.express";
        mainPage.mainPage();
        SignUpWorkPage signUpWorkPage = mainPage.pushSignUpButton();
        signUpWorkPage.waitForSignUpPageToLoad();
        log.info("Verifications");
        signUpWorkPage.pushCloseSign();
        String actualTitle = signUpWorkPage.getTitle();
        Assert.assertTrue(expectedPageTitle.equals(actualTitle),"Page title is not expected.\n Expected: "
                + expectedPageTitle + "\nActual: " + actualTitle);

    }*/
}
