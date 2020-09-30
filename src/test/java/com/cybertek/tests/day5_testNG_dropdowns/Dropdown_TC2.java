package com.cybertek.tests.day5_testNG_dropdowns;

import com.cybertek.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Dropdown_TC2 {


    WebDriver driver;
    /*
    1.Open Chrome browser
    2.Go to http://practice.cybertekschool.com/dropdown
     */

    @BeforeMethod
    public void setUpMethod() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
        Thread.sleep(2000);

    }
    //3.Select Illinois
    @Test
    public void dropdown_t1() throws InterruptedException {
        Select stateSelection = new Select(driver.findElement(By.id("state")));
        stateSelection.selectByVisibleText("Illinois");
        String actualSelectedState =stateSelection.getFirstSelectedOption().getText();
        String expectedState ="Illinois";
        Assert.assertEquals(actualSelectedState,expectedState,"actual state is not match, test failed");
        Thread.sleep(2000);
        driver.close();

    }
    //4.Select Virginia
    @Test
    public void dropdown_t2() throws InterruptedException {
        Select stateSelection = new Select(driver.findElement(By.id("state")));
        stateSelection.selectByVisibleText("Virginia");
        String actualSelectedState =stateSelection.getFirstSelectedOption().getText();
        String expectedState ="Virginia";
        Assert.assertEquals(actualSelectedState,expectedState,"actual state is not match, test failed");
        Thread.sleep(2000);
        driver.close();

    }
    /*
     5.Select California
     6.Verify final selected option is California.Use all Select options.(visible text, value, index)
     */
    @Test
    public void dropdown_t3() throws InterruptedException {

        Select stateSelection = new Select(driver.findElement(By.id("state")));
        stateSelection.selectByVisibleText("California");
        String actualSelectedState =stateSelection.getFirstSelectedOption().getText();
        String expectedState ="California";
        Assert.assertEquals(actualSelectedState,expectedState,"actual state is not match, test failed");
        Thread.sleep(2000);
        driver.close();

    }



    }

