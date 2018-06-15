package com.express.base;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;



public class BaseTest {
    protected WebDriver driver;
    protected Logger log;

    @BeforeClass (alwaysRun = true)
    protected void setUpClass(ITestContext ctx) {
        String testName = ctx.getCurrentXmlTest().getName();
        log = Logger.getLogger(testName);

    }

    @Parameters({"browser"})
    @BeforeMethod
    protected void methodSetUp(String browser){
        log.info("Method set up");
        driver = BrowserFactory.getDriver(browser, log);
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

    @AfterMethod (alwaysRun = true)
    protected void methodTearDown(){
        log.info("Method Tear Down");
        driver.quit();

    }

}
