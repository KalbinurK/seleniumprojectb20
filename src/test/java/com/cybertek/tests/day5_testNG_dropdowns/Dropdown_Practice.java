package com.cybertek.tests.day5_testNG_dropdowns;

import com.cybertek.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Dropdown_Practice {

    /*
        1.Open Chrome browser
        2.Go to http://practice.cybertekschool.com/dropdown
        3.Verify “Simple dropdown” default selected value is correctExpected: “Please select an option”
        4.Verify“State selection” default selected value is correctExpected: “Select a State”
     */

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void Dropdown_test_1() throws InterruptedException {

        Select simpleDropdown = new Select(driver.findElement(By.id("dropdown")));

       String actualSelectedOption =  simpleDropdown.getFirstSelectedOption().getText(); // return type web ele.
        String expectedSelectedOption = "Please select an option";
        Assert.assertEquals(actualSelectedOption,expectedSelectedOption);

        Thread.sleep(2000);
        simpleDropdown.selectByVisibleText("Option 2");


    }



}
