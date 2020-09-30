package com.cybertek.tests.Project;

import com.cybertek.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SmokeTest {
    WebDriver driver;
    boolean isPass=false;
    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa2.vytrack.com/user/login");
        driver.findElement(By.name("_username")).sendKeys("user177");
        driver.findElement(By.name("_password")).sendKeys("UserUser123" + Keys.ENTER);

    }

    @Test
    public void CreateOdometer() throws InterruptedException {

        //go to the Odometers page
        // --> with URL way
        driver.get("https://qa2.vytrack.com/entity/Extend_Entity_VehiclesOdometer");
        Thread.sleep(1000);
        //Create new vehicle odometer
        driver.findElement(By.cssSelector("a[title='Create Vehicle Odometer']")).click();
        Thread.sleep(2000);
        //Enter the Odometer Value ps: number Only
        driver.findElement(By.xpath("//div[@class='section-content']/div[1]/fieldset/div/div/div[2]/input")).sendKeys("123456");
        //Click the Date and Click "Today" for todays date
        driver.findElement(By.cssSelector("input[class='datepicker-input hasDatepicker']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[data-handler='today']")).click();
        Thread.sleep(2000);
        //Enter the Driver
        driver.findElement(By.cssSelector("input[name='custom_entity_type[Driver]']")).sendKeys("driverName");
        // Click the green Save button
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(2000);
        //Create "successful" message will display for 5sce
        WebElement savedMessage = driver.findElement(By.cssSelector("div.message"));
        if (savedMessage.isDisplayed()) {
            isPass=true;
        } else {
            isPass=false;
        }
        if (isPass){
            System.out.println("test is Pass");
            isPass=false;
        }else {
            System.out.println("test is Fail");
            driver.close();
        }
    }
}


