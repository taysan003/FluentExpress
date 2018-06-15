package com.express.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject<T> {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Logger log;

    protected BasePageObject(WebDriver driver, Logger log){
            this.driver = driver;
            this.log = log;
            wait = new WebDriverWait(driver, 40);

    }

    @SuppressWarnings("unchecked")
    protected T getPage(String url) {
        driver.get(url);
        return (T) this;
    }

    protected  void type(String text, By element) {
        find(element).sendKeys(text);
    }

    protected  void click(By element) {
        find(element).click();
    }

    private WebElement find(By element) {
        return driver.findElement(element);
    }

    protected void waitForVisibilityOf(By locator, Integer... timeOutInSeconds){
        int attemts = 0;
        while (attemts < 2){
            try {
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator), (timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
                break;
            } catch (StaleElementReferenceException e) {
                attemts++;
            }
        }
    }
     private void waitFor (ExpectedCondition<WebElement> condition, Integer timeOutInSecnds){

        timeOutInSecnds = timeOutInSecnds != null ? timeOutInSecnds : 30;
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(condition);
     }

     public  String getTitle(){
        return driver.getTitle();
     }

     protected String getText(By element) {
        return find(element).getText();
     }
}
