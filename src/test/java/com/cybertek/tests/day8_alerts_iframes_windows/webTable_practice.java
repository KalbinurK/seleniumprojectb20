package com.cybertek.tests.day8_alerts_iframes_windows;

import com.cybertek.tests.utilities.SmartBearUtilities;
import com.cybertek.tests.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class webTable_practice {
    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        SmartBearUtilities.loginToSmartBear(driver);
    }
    // Using the verify order method from SmartBearUtilities class
    @Test
    public void task4_verify_order(){

        SmartBearUtilities.verifyOrder(driver,"Mark Smith");

    }

    @Test
    public void tesr5_verifyName_City(){
        SmartBearUtilities.printNamesAndCities(driver);

        


    }

}


