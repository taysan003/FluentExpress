package com.express.pages;

import com.express.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePageObject<MainPage> {
    private static final String URL = "http://fluentexpress-staging.northeurope.cloudapp.azure.com/";

    private By emailField = By.xpath("/html/body/main/div/div/form/div[1]/input");
    private By passwordField = By.xpath("/html/body/main/div/div/form/div[2]/input");
    private By logInButton = By.xpath("//a[@class='f6 fw4 white-90 link dib ml2 pv2 ph3 ba pointer hover-bg-white-20 bg-animate']");
    private By signUpButton = By.xpath("//a[@class='f6 fw4 white-90 hover-white link ph3 pointer dib-ns dn'][contains(text(),'Sign up')]");
    private By logInButtonInLogInMenu = By.xpath("/html/body/main/div/div/form/div[4]/button");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public  void mainPage(){
        getPage(URL);
    }

    public void fillUpEmailAndPassword(String email, String password) {
        System.out.println("Filling up email and password");
        type(email, emailField);
        type(password, passwordField);
    }






    public SignUpWorkPage pushSignUpButton(){
        System.out.println("Clicking on Sign Up Button");
        click(signUpButton);
        return new SignUpWorkPage(driver);

    }

    public ProfilePage pushlogInButtonInLogInMenu(){
        System.out.println("Clicking on Log In Button In Menue");
        click(logInButtonInLogInMenu);
        return new ProfilePage(driver);

    }
    public ProfilePage pushLogInButton(){
        System.out.println("Clicking on Log In Button In Main Menue");
        click(logInButton);
        return new ProfilePage(driver);

    }
}
