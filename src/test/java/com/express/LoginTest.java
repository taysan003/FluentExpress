package com.express;

import com.express.base.BaseTest;
import com.express.base.CsvDataProvider;
import com.express.pages.MainPage;
import com.express.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class LoginTest extends BaseTest {

    @Test (priority = 1, groups = { "positive"})
    public void positiveLogInTest() {

        MainPage mainPage = new MainPage(driver, log);
        String expectedPageTitle = "Submit new text";
        String correctProfileName = "kostuchenko-and@mail.ru.";
        mainPage.mainPage();
        mainPage.pushLogInButton();
        mainPage.fillUpEmailAndPassword("kostuchenko-and@mail.ru","Kostuchenko0");
        ProfilePage profilePage = mainPage.pushlogInButtonInLogInMenu();

        profilePage.waitForProfilePageToLoad();
        log.info("Verifications");
        String actualTitle = profilePage.getTitle();
        Assert.assertTrue(expectedPageTitle.equals(actualTitle),"Page title is not expected.\n Expected: "
               + expectedPageTitle + "\nActual: " + actualTitle);
        /*Assert.assertTrue(profilePage.isCorrectProfileLoaded(correctProfileName), "Profile name is not expected");*/
    }

    @Test(dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class, priority = 2,
            groups = { "negative", "broken"})
    public void negativeLogInTest(Map<String, String> testData) {
        String expectedErrorMessage = "A user with such email and password does not exist!";
        String testNumber = testData.get("no");
        String email = testData.get("email");
        String password = testData.get("password");
        String description = testData.get("description");
        log.info("Test No #" + testNumber + " for" + description + "Where\nEmail: " + email + "\nPassword:"
                + password);
        MainPage mainPage = new MainPage(driver, log);
        mainPage.mainPage();
        mainPage.pushLogInButton();
        mainPage.fillUpEmailAndPassword(email,password);
        mainPage.pushlogInButtonInLogInMenu();
        String errorMessage = mainPage.getLogInErrorMessage();
        Assert.assertTrue(errorMessage.contains(expectedErrorMessage),"Error message is not expected. Expected: " +
        expectedErrorMessage + "\n Actual: " + errorMessage +".");


    }


}
