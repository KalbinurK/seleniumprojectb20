package com.cybertek.tests.day5_testNG_dropdowns;

import com.cybertek.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC3Copy {
    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    // this test work
    @Test
    public void selectingDate(){

        driver.get("http://practice.cybertekschool.com/dropdown");
        Select select1 = new Select(driver.findElement(By.id("year")));
        select1.selectByValue("1921");
        String actualselected1= select1.getFirstSelectedOption().getText();
        String expectedselected1="1921";
        Assert.assertEquals(actualselected1,expectedselected1, "1921 Failed..");

        Select select2 = new Select(driver.findElement(By.id("month")));
        select2.selectByValue("11");
        String actualselected2= select2.getFirstSelectedOption().getText();
        String expectedselected2="December";
        Assert.assertEquals(actualselected2,expectedselected2,"11 Failed..");

        Select select3 = new Select(driver.findElement(By.id("day")));
        select3.selectByValue("1");
        String actualselected3= select3.getFirstSelectedOption().getText();
        String expectedselected3="1";
        Assert.assertEquals(actualselected3,expectedselected3,"Day Failed....");
    }
}

