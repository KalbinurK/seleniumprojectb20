package com.cybertek.tests.day8_alerts_iframes_windows;

import com.cybertek.tests.utilities.BrowserUtils;
import com.cybertek.tests.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Alert_Practices {

    /*
    TC #1: Information alert practice1.Open browser
    2.Go to website: http://practice.cybertekschool.com/javascript_alerts
    3.Click to “Click for JS Alert”button
    4.Click to OK button from the alert
    5.Verify “You successfulyclicked an alert”text is displayed.
     */

    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void p1_infromationAlert_practice(){

        // locate the waring/infprmation alert button to click it
        WebElement warningAlertButton =driver.findElement(By.xpath("//button[.='Click for JS Alert']"));

        // click to the button
        warningAlertButton.click();

        // first step create Alert instance and switch to alert
        Alert alert =driver.switchTo().alert();

        BrowserUtils.wait(2);

        // second way is use "alert' instance to accept the javascript alert(popup)
        alert.accept();

        //locating the result text we ele
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));

        //assert "resulttext" isdiplayed
        Assert.assertTrue(resultText.isDisplayed(),"result text is not displayed, verification failed1");


    }
      @Test
    public void p2_confirmation_alert_practice(){
          WebElement warningAlertButton =driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));

          warningAlertButton.click();
          // create alert instance
          Alert alert = driver.switchTo().alert();
          // alert.dismiss();
          alert.accept();

          WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));

          //assert "resulttext" isdiplayed
          Assert.assertTrue(resultText.isDisplayed(),"result text is not displayed, verification failed1");

    }

    @Test
    public void p3_information_alert_practice(){
        WebElement informationAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        informationAlertButton.click();
        Alert alert = driver.switchTo().alert();
        BrowserUtils.wait(2);
        alert.sendKeys("Hello");

        alert.accept();
        BrowserUtils.wait(2);
        WebElement resultText = driver.findElement(By.xpath("//p[.='You entered: Hello']"));
        Assert.assertTrue(resultText.isDisplayed(),
                "Actual and Expected Result does not match. Verification Failed!");
    }




}
