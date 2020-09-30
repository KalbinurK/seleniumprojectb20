package com.cybertek.tests.day7_webTables;

import com.cybertek.tests.utilities.SmartBearUtilities;
import com.cybertek.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class webTableTasks {

    /*
    TC#3: Smartbear software order verification
1. Open browser and login to Smartbear software
2. Click on View all orders
3. Verify Susan McLaren has order on date “01/05/2010”
     */
    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        SmartBearUtilities.loginToSmartBear(driver);
    }

    @Test
    public void p3_verify_susan_order_date() throws InterruptedException {
        WebElement SusanDate = driver.findElement(By.xpath("//td[.='Susan McLaren']/../td[5]"));
      //  System.out.println("susan date: "+SusanDate.getText());
        String expectedDate = "01/05/2010";
        String actualDate = SusanDate.getText();
        Assert.assertEquals(actualDate,expectedDate,"not matching failed");
        Thread.sleep(1000);
        driver.quit();

    }
}
