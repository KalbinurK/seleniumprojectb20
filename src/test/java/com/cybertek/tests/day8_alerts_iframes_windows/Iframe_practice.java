package com.cybertek.tests.day8_alerts_iframes_windows;

import com.cybertek.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Iframe_practice {

    /*
    TC #4: Iframe practice
    1.Create a new class called: IframePractice
    2.Create new test and make set ups
    3.Go to: http://practice.cybertekschool.com/iframe
    4.Assert: “Your content goes here.” Text is displayed.
    5.Assert: “An iFrame containing the TinyMCEWYSIWYG Editor
     */

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/iframe");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void p4_iframe_practice(){

        //3 ways of lacating
        // 1 -by index
        //driver.switchTo().frame(0);
        // 2- by id or Name
        // 3- locate paragraph tag as a web ele
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);

       // WebElement assertText = driver.findElement(By.xpath("//p[.='Your content goes here.']"));

        WebElement yourcuntantgoeshereText = driver.findElement(By.xpath("//p"));

        Assert.assertTrue(yourcuntantgoeshereText.isDisplayed(),"verification failed!");

        driver.switchTo().defaultContent();
      //  driver.switchTo().parentFrame();
        WebElement headerText = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(headerText.isDisplayed(),"header text is not displayed, verification failed");

        



    }

}
