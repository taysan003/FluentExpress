package com.express.pages;

import com.express.base.BasePageObject;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class SignUpWorkPage extends BasePageObject<ProfilePage> {
    private static final String URL = "http://fluentexpress-staging.northeurope.cloudapp.azure.com/register";
    private By signUpTitleOfWorkPage = By.xpath("/html/body/div[1]/div/div[1]");
    private By bodyWorkPage = By.xpath("//div[@class='mt5-ns mt3 center bg-white relative pv4 ph5-ns ph3 measure z-999']");
    private By orSignUpWithEmailTitle = By.xpath("/html/body/div[1]/div/div[3]/span");
    private By closeSign = By.xpath("//span[@class='black-50 hover-black f3 b pa3']");
    private By emailField = By.xpath("//input[@class='mb1 pv2 lh-copy ph3 input-reset sans-serif black-80 ba bg-transparent w-100 b--black-20']");
    private By passwordField = By.xpath("//input[@class='pv2 lh-copy ph3 input-reset sans-serif ba bg-transparent w-100 b--black-20']");
    private By almostDoneTitle = By.xpath("//div[@class='mb4 f3 b']");
  /*  private By signUpButton_1 = By.xpath("/html/body/main/div/div/form/div[4]/button");*/
    private By signUpButton = By.xpath("//button[@id='home-submit']");
    private By errorMessage = By.xpath("//p[@class='dark-red']");


    public SignUpWorkPage(WebDriver driver, Logger log) {
        super(driver, log);
    }
    public void signUpWorkPage(){
        getPage(URL);
    }

    public void waitForSignUpPageToLoad() {
        log.info("Waiting For Sign Up Page To Load");
        /*waitForVisibilityOf(signUpTitleOfWorkPage);*/
        waitForVisibilityOf(bodyWorkPage, 10);

    }
    public void waitForSignUpFinalPageToLoad() {
        log.info("Waiting For Sign Up Page To Load");
        /*waitForVisibilityOf(signUpTitleOfWorkPage);*/
        waitForVisibilityOf(almostDoneTitle, 10);

    }


    public boolean isCorrectSignUpWorkPageLoaded(String correctProfileName) {
        if (getText(orSignUpWithEmailTitle).equals(correctProfileName)) {
            return true;
        }
        return false;
    }

    public SignUpWorkPage pushCloseSign() {
        log.info("Clicking on Close Sign");
        click(closeSign);
        return new SignUpWorkPage(driver, log);

    }
    public SignUpWorkPage pushSignUpButtonInWorkPage(){
        log.info("Clicking on Sign Up Button");
        click(signUpButton);
        /*click(signUpButton_1);*/
        return new SignUpWorkPage(driver, log);

    }


    public void fillUpEmailAndPassword(String email, String password) {
        log.info("Filling up email and password");
        type(email, emailField);
        type(password, passwordField);
    }

    public String getSignUpErrorMessage() {
        waitForVisibilityOf(errorMessage,10);
        return getText(errorMessage);
    }
}
