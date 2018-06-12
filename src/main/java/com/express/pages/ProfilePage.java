package com.express.pages;

import com.express.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePageObject<ProfilePage> {

    private By resendEmailButton = By.xpath("//form[@action='/activate']//div");
    private By almostDoneTitle = By.xpath("//div[@class='mb4 f3 b']");
    private By profileContactNameText = By.xpath("//span[@class='nowrap']");

    public  ProfilePage(WebDriver driver) {
        super(driver);
    }

    public void waitForProfilePageToLoad(){
        System.out.println("Waiting For Profile Page To Load");
        waitForVisibilityOf(resendEmailButton);
        waitForVisibilityOf(almostDoneTitle, 10);

    }

    public boolean isCorrectProfileLoaded(String correctProfileName) {
        if (getText(profileContactNameText).equals(correctProfileName)){
            return  true;
        }
        return false;
    }
}
