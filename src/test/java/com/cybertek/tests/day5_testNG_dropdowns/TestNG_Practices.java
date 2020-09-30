package com.cybertek.tests.day5_testNG_dropdowns;

import com.cybertek.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNG_Practices {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.google.com");
    }
    @Test
    public void google_title_verification(){


        String expectedTitle = "Google";
        String actrualTitle = driver.getTitle();

        Assert.assertEquals(actrualTitle,expectedTitle,"Title are not matching");
    }

    @Test
    public void google_search_title_verification(){

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("apple"+ Keys.ENTER);

        String expectedTitle = "apple";
        String actrualTitle =driver.getTitle();

        Assert.assertTrue(actrualTitle.contains(expectedTitle),"Title does not contain search value");

    }
    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

}
