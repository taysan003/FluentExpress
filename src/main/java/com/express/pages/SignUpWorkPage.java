package com.express.pages;

import com.express.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpWorkPage extends BasePageObject<ProfilePage> {

    private By signUpTitleOfWorkPage = By.xpath("/html/body/div[1]/div/div[1]");
    private By bodyWorkPage = By.xpath("//*[@id=\"register-modal\"]");
    private By orSignUpWithEmailTitle = By.xpath("/html/body/div[1]/div/div[3]/span");
    private By closeSign = By.xpath("//span[@class='black-50 hover-black f3 b pa3']");
    private By emailField = By.xpath("/html/body/div[1]/div/form/div[1]/input");
    private By passwordField = By.xpath("/html/body/div[1]/div/form/div[2]/input");
    private By almostDoneTitle = By.xpath("//div[@class='mb4 f3 b']");
    private By signUpButton = By.xpath("//button[@id='home-submit']");


    public SignUpWorkPage(WebDriver driver) {
        super(driver);
    }

    public void waitForSignUpPageToLoad() {
        System.out.println("Waiting For Sign Up Page To Load");
        /*waitForVisibilityOf(signUpTitleOfWorkPage);*/
        waitForVisibilityOf(bodyWorkPage, 10);

    }
    public void waitForSignUpFinalPageToLoad() {
        System.out.println("Waiting For Sign Up Page To Load");
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
        System.out.println("Clicking on Close Sign");
        click(closeSign);
        return new SignUpWorkPage(driver);

    }

    public void fillUpEmailAndPassword(String email, String password) {
        System.out.println("Filling up email and password");
        type(email, emailField);
        type(password, passwordField);
    }

}
