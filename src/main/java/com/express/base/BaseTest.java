package com.express.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    protected void methodSetUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        /*methodTearDown();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        methodTearDown();
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        methodTearDown();*/
    }

    @AfterMethod
    protected void methodTearDown(){
        driver.quit();
        System.out.println("Method Tear Down");
        /*driver.quit();
        driver.quit();*/

    }

}
