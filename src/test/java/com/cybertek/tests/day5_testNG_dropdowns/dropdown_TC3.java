package com.cybertek.tests.day5_testNG_dropdowns;

import com.cybertek.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class dropdown_TC3 {
    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void selectYear(){

        // for year:
        driver.get("http://practice.cybertekschool.com/dropdown");
        Select selectYear = new Select(driver.findElement(By.id("year")));
        selectYear.selectByValue("1921");
        String actualYear =selectYear.getFirstSelectedOption().getText();
        String expectedYear= "1921";
        Assert.assertEquals(actualYear,expectedYear,"actual year is not match, test failed");

        // for month;
        Select selectMonth = new Select(driver.findElement(By.id("month")));
        selectMonth.selectByValue("11");
        String actualMonth = selectMonth.getFirstSelectedOption().getText();
        String expectedMonth ="December";
        Assert.assertEquals(actualMonth,expectedMonth,"actual month is not match, test failed");

        // for day
        Select selectDay =new Select(driver.findElement(By.id("day")));
        selectDay.selectByValue("1");
        String actualDay = selectDay.getFirstSelectedOption().getText();
        String expectedDate = "1";
        Assert.assertEquals(actualDay,expectedDate,"actual date is not match, test failed.");

    }

}

















