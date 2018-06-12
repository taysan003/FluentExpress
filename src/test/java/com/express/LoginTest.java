package com.express;

import com.express.base.BaseTest;
import com.express.pages.MainPage;
import com.express.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

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
        Assert.assertTrue(expectedPageTitle.equals(actualTitle),"Page title is not expected.\n Expected: " + expectedPageTitle + "\nActual: " + actualTitle);
        Assert.assertTrue(profilePage.isCorrectProfileLoaded(correctProfileName), "Profile name is not expected");
    }


}
