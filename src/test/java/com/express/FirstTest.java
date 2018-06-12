package com.express;

import com.express.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class FirstTest extends BaseTest {

    @Test
    public void firstTestMethodFirefox(){

        String driverPath = "";

        if (System.getProperty("os.name").contains("Mac")){
            driverPath = "./resources/webdrivers/mac/geckodriver.sh";
        } else if (System.getProperty("os.name").contains("Windows")){
            driverPath = "./resources/webdrivers/pc/geckodriver.exe";
        } else {
            throw new  IllegalArgumentException("Unknown OS");
        }
        //Open FluentExpress
        driver.get("http://fluentexpress-staging.northeurope.cloudapp.azure.com/");
        System.out.println("FluentExpress opened. Test passed!");


    }

    @Test
    public void secondTestMethodChrome(){

        ChromeOptions option = new ChromeOptions();
        option.addArguments("disable-infobars");
        option.addArguments("--disable-notifications");

        if (System.getProperty("os.name").contains("Mac")){
            option.addArguments("-start-fullscreen");
        } else if (System.getProperty("os.name").contains("Windows")) {
            option.addArguments("--start-maximized");
        }

       /* driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
*/
        //Open FluentExpress
        driver.get("http://fluentexpress-staging.northeurope.cloudapp.azure.com/");
        System.out.println("FluentExpress opened. Test passed!");

    }

    @Test
    public void thirdTestMethodEdge(){

        if (!System.getProperty("os.name").contains("Windows"))
            throw new IllegalArgumentException("MS Edge is avalible only on Windows");

        /*driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
*/
        //Open FluentExpress
        driver.get("http://fluentexpress-staging.northeurope.cloudapp.azure.com/");
        System.out.println("FluentExpress opened. Test passed!");


    }

/*    @Test
    public void fourthTestMethod(){

        if (!System.getProperty("os.name").contains("Mac")) {
            throw new IllegalArgumentException("Safari is available only on Mac");
        }

        WebDriver driver = new SafariDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //Open FluentExpress
        driver.get("http://fluentexpress-staging.northeurope.cloudapp.azure.com/");
        System.out.println("FluentExpress opened. Test passed!");


    }*/
}
