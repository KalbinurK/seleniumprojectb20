package com.cybertek.tests.day8_alerts_iframes_windows;

import com.cybertek.tests.utilities.BrowserUtils;
import com.cybertek.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class dropdownPractices {
    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void p7_month_dropdown_default_value_test(){
        // locating the month dropdown
        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));

        // expected

        String expectedValue ="September";

        String actualValue = monthDropdown.getFirstSelectedOption().getText();

        System.out.println("actualValue = "+actualValue);

        //Assert.assertEquals(acctualValue,expectedValue);
        Assert.assertTrue(actualValue.equalsIgnoreCase(expectedValue));

        List<WebElement> actualMonthOptions = monthDropdown.getOptions();

        List<String> expectedMonthOptions = Arrays.asList("January","February","March","April","May","June","July," +
                "August","September","October","November","December");

        // creste a new list of string called:actualMonthtext and store the text fo web ele
       /* List<String> actualMonthtexts= new ArrayList<String>();

        for(WebElement each: actualMonthOptions){

            actualMonthtexts.add(each.getText());
        }


        */
        Assert.assertEquals(BrowserUtils.getElementsText(actualMonthOptions),expectedMonthOptions);






    }

}
