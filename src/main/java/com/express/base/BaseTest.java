package com.express.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected WebDriver driver;

    @Parameters({"browser"})
    @BeforeMethod
    protected void methodSetUp(String browser){
        System.out.println("Method set up");
        driver = BrowserFactory.getDriver(browser);
        /*driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();*/
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
        System.out.println("Method Tear Down");
        driver.quit();

    }

}
