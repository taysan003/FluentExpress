package com.express.pages;

import com.express.base.BasePageObject;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePageObject<ProfilePage> {

    private By submitNewTextTitle = By.xpath("//h1[@class='mt0 mb3 mb4-ns f4 b']");
    private By leaveNote = By.xpath("//p[@class='mb2 f6 gray']");
    private By profileContactNameText = By.xpath("//span[@class='nowrap']");

    public  ProfilePage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void waitForProfilePageToLoad(){
        log.info("Waiting For Profile Page To Load");
        waitForVisibilityOf(submitNewTextTitle);
        waitForVisibilityOf(leaveNote, 10);

    }

    public boolean isCorrectProfileLoaded(String correctProfileName) {
        if (getText(profileContactNameText).equals(correctProfileName)){
            return  true;
        }
        return false;
    }
}
