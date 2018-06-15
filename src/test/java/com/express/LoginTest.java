package com.express;

import com.express.base.BaseTest;
import com.express.base.CsvDataProvider;
import com.express.pages.MainPage;
import com.express.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class LoginTest extends BaseTest {

    @Test
    public void positiveLogInTest() {

        MainPage mainPage = new MainPage(driver);
        String expectedPageTitle = "Activate your account";
        String correctProfileName = "kostuchenko-and@mail.ru.";
        mainPage.mainPage();
        mainPage.pushLogInButton();
        mainPage.fillUpEmailAndPassword("kostuchenko-and@mail.ru","Kostuchenko0");
        ProfilePage profilePage = mainPage.pushlogInButtonInLogInMenu();

        profilePage.waitForProfilePageToLoad();
        System.out.println("Verifications");
        String actualTitle = profilePage.getTitle();
        Assert.assertTrue(expectedPageTitle.equals(actualTitle),"Page title is not expected.\n Expected: "
                + expectedPageTitle + "\nActual: " + actualTitle);
        Assert.assertTrue(profilePage.isCorrectProfileLoaded(correctProfileName), "Profile name is not expected");
    }

    @Test(dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class)
    public void negativeLogInTest(Map<String, String> testData) {
        String expectedErrorMessage = "A user with such email and password does not exist!";
        String testNumber = testData.get("no");
        String email = testData.get("email");
        String password = testData.get("password");
        String description = testData.get("description");
        System.out.println("Test No #" + testNumber + " for" + description + "Where\nEmail: " + email + "\nPassword:"
                + password);
        MainPage mainPage = new MainPage(driver);
        mainPage.mainPage();
        mainPage.pushLogInButton();
        mainPage.fillUpEmailAndPassword(email,password);
        mainPage.pushlogInButtonInLogInMenu();
        String errorMessage = mainPage.getLogInErrorMessage();
        Assert.assertTrue(errorMessage.contains(expectedErrorMessage),"Error message is not expected. Expected: " +
        expectedErrorMessage + "\n Actual: " + errorMessage +".");


    }


}
