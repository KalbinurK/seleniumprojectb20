package com.cybertek.tests.day6_dropdown_review_javafaker;

import com.cybertek.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropdownTasks {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        // opne a new browther

        driver = WebDriverFactory.getDriver("chrome");
        // max the page
        driver.manage().window().maximize();
        // implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // get the page
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void tes2_verify_state_dropdown() throws InterruptedException {
        // we need to locate dropdown
        Select statedropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        Thread.sleep(1000);
        statedropdown.selectByVisibleText("Illinois");
        // select virginia
        Thread.sleep(1000);
        statedropdown.selectByValue("VA");
        Thread.sleep(1000);
        // select california
        statedropdown.selectByIndex(5);

        // verify final selected option is california

        String expectedR = "California";
        String actualR = statedropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualR, expectedR, "actual VS expected not match, test failed");

    }

    @Test
    public void test3_dropdown_verification() throws InterruptedException {
        Select yearDropdown = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select dayDropdown = new Select(driver.findElement(By.xpath("//select[@id='day']")));

        String expectedY = "1921";
        String expetedMonth = "December";
        String expectedDay = "1";

        yearDropdown.selectByVisibleText("1921");
        Thread.sleep(1000);
        monthDropdown.selectByValue("11");
        Thread.sleep(1000);
        dayDropdown.selectByIndex(0);

        String actualY = yearDropdown.getFirstSelectedOption().getText();
        String actualM = monthDropdown.getFirstSelectedOption().getText();
        String actualD = dayDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualY, expectedY, "Actual is not match, test failed");
        Assert.assertEquals(actualM, expetedMonth, "Actual is not match, test failed");
        Assert.assertEquals(actualD, expectedDay, "Actual is not match, test failed");
    }

    @Test
    public void Test4_multiple_value_select_dropdown() {

        //
        Select multipleSelctDropDown = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));

        // create a list of web ele to store all of the option inside of this dropdown
        List<WebElement> allOptions = multipleSelctDropDown.getOptions();

        // loop throufh the option to select all of the them
        // print out all select options
        for (WebElement eachOtion : allOptions) {
            eachOtion.click();

            System.out.println("Selected: " + eachOtion.getText());

            Assert.assertTrue(eachOtion.isSelected(), "the option: " + eachOtion.getText() + " is not selected");

            // deselect all value
            multipleSelctDropDown.deselectAll();

            for (WebElement eachOption : allOptions) {
                Assert.assertTrue(!eachOption.isSelected()); // it will be false boolean value, with ! we make it"true"
                //assertFalase method loos for "false" boolea value to pass the test
                // Assert.assertFalse(eachOption.isSelected());
            }

        }
    }


    @Test
      public void test5_html_dropdown_handling() {
          // selecting value from non-select dropdown
          // click to non slect dropdown
          //locate the html dropdown as a redular wen ele
          WebElement websidedropdwon = driver.findElement(By.xpath("//div[@class='dropdown']/a"));
          // click to non-select dropdown

          websidedropdwon.click();

          WebElement facebooklink = driver.findElement(By.xpath("//a[.='Facebook']"));
          facebooklink.click();

        String actualTitle = driver.getTitle();
        String expectedTitle = "Facebook - Log In or Sign Up";

        Assert.assertEquals(actualTitle,expectedTitle,"actual is not match, test failed");
      }


}
