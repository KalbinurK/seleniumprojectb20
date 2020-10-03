package com.cybertek.tests.Project;

import com.cybertek.tests.utilities.BrowserUtils;
import com.cybertek.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Bitrix {
    WebDriver driver;
    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login2.nextbasecrm.com/");
        BrowserUtils.wait(2);
        driver.findElement(By.name("USER_LOGIN")).sendKeys("marketing27@cybertekschool.com");
        BrowserUtils.wait(2);
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser" + Keys.ENTER);

    }
    @Test
    public void Create_quoteByCommaIcon(){
        // locate the manu button
        WebElement sidemap_manu = driver.findElement(By.id("sitemap-menu"));
        sidemap_manu.click();
        BrowserUtils.wait(2);
        // locate active stream in side of manu, active stream opened
        WebElement activeStream = driver.findElement(By.xpath("//a[.='Activity Stream']"));
        activeStream.click();
        BrowserUtils.wait(2);
        // locate message field, the message window opened
        WebElement Message = driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-message']"));
        Message.click();
        BrowserUtils.wait(2);
        String actualMessage =Message.getText();
        String expectedMessage="MESSAGE";
        Assert.assertEquals(actualMessage,expectedMessage,"actual not match with expected, TEST FAILED ");
        // locate comma icon and click it
        WebElement comma = driver.findElement(By.xpath("//span[@title='Quote text']"));
        comma.click();

        WebElement quotetxt = driver.findElement(By.className("bx-editor-iframe")); // locate the iframe first
        driver.switchTo().frame(quotetxt);
        driver.findElement(By.xpath("//blockquote[@class='bxhtmled-quote']")).sendKeys("Test3"); // then find quoteblock type"Test321123"
        driver.switchTo().parentFrame(); // after done with child frame back to parent frame


       BrowserUtils.wait(1);
       WebElement sendButton = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
       sendButton.click();
        Assert.assertTrue(sendButton.isEnabled(),"Send button is not click, test failed!");


        



    }


    }
