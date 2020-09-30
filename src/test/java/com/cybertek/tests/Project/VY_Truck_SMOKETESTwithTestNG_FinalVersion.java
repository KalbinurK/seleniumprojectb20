package com.cybertek.tests.Project;

import com.cybertek.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VY_Truck_SMOKETESTwithTestNG_FinalVersion {

    WebDriver driver;
    boolean isPass=false;
    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//put the link
        driver.get("https://qa2.vytrack.com/user/login");
//put user name
        driver.findElement(By.name("_username")).sendKeys("user177");
//put password
        driver.findElement(By.name("_password")).sendKeys("UserUser123");
//click the button - SABMIT
        driver.findElement(By.name("_submit")).click();
    }
    @AfterMethod
    public void close(){
        driver.quit();
    }
    @Test
    public void AVy_Truck_Odometer_AEDIT() throws InterruptedException{
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//hover over to the FLEET
        driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]")).click();
        Thread.sleep(2000);
//click to the Vehicle Odometer
        driver.findElement(By.linkText("Vehicle Odometer")).click();
        Thread.sleep(2000);
        //driver.findElement(By.xpath("(//span[@class='title title-level-2'])[2]")).click(); //or[2] for odometers
//click to the first line on page Vehicle Odometers
        driver.findElement(By.xpath("//tbody[@class='grid-body']/tr[1]")).click();
        Thread.sleep(2000);
//click EDIT
        driver.findElement(By.xpath("//a[@title='Edit Vehicle Odometer']")).click();
        Thread.sleep(2000);
//clear odometer value field
        driver.findElement(By.xpath("//input[@name='custom_entity_type[OdometerValue]']")).clear();
        Thread.sleep(2000);
//enter random data in a odometer value field
        driver.findElement(By.xpath("//input[@name='custom_entity_type[OdometerValue]']")).sendKeys("99999999999");
        Thread.sleep(2000);
//click button Save and Close
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
        String confermationMessage = driver.findElement(By.xpath("//div[@class='message']")).getText();
        String exualMessage = "Entity saved";
        Assert.assertEquals(confermationMessage,exualMessage);
    }
    @Test
    public void BVy_Truck_Vehicle_ADD_Event() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//hover over to the FLEET
        driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]")).click();
        Thread.sleep(2000);
//click Vehicles
        // driver.findElement(By.linkText("Vehicle")).click();
        driver.findElement(By.xpath("(//span[@class='title title-level-2'])[1]")).click(); //or[2] for odometers
        Thread.sleep(2000);
//click first line on page CARS
        driver.findElement(By.xpath("//tbody[@class='grid-body']/tr[1]")).click();
        Thread.sleep(3000);
//click Activity
        driver.findElement(By.xpath("//a[.='Activity']" )).click();
        Thread.sleep(3000);
//click Add Event
        driver.findElement(By.xpath("//a[@title = 'Add an event to this record']")).click();
        //a[@title = 'Add an event to this record']
        //driver.findElement(By.xpath("//a[@data-id='1557']")).click();
        Thread.sleep(2000);
//click to the field Title and put value ONE WAY TICKET TO THE BLUES
        driver.findElement(By.xpath("//input[@name='oro_calendar_event_form[title]']")).sendKeys("ONE WAY TICKET TO THE BLUES");
        Thread.sleep(2000);
//click SAVE button
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        Thread.sleep(2000);
        // String confermationMessage = driver.findElement(By.xpath("//div[@class='message-item message']")).getText();
        // String exualMessage = "qwe";
        String confermationMessage = driver.findElement(By.xpath("//div[@class='message']")).getText();
        String exualMessage = "Calendar event saved";
        Assert.assertEquals(confermationMessage, exualMessage);
    }
    @Test
    public void CCreateOdometer() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //go to the Odometers page
        // --> with URL way
        driver.get("https://qa2.vytrack.com/entity/Extend_Entity_VehiclesOdometer");
        Thread.sleep(2000);
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
    @Test
    public void DVy_Truck_Odometer_BDelete() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//hover over to the FLEET
        driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]")).click();
        Thread.sleep (2000);
//click to the Vehicle Odometer
        driver.findElement(By.xpath("(//span[@class='title title-level-2'])[2]")).click();
        Thread.sleep (2000);
//click to the first line on page Vehicle Odometers
        driver.findElement(By.xpath("//tbody[@class='grid-body']/tr[1]")).click();
        Thread.sleep (2000);
//click button DELETE
        driver.findElement(By.xpath("//a[@title='Delete Vehicle Odometer']")).click();
        Thread.sleep (2000);
//CLICK Yes,DELETE
        driver.findElement(By.xpath("//a[@class='btn ok btn-danger']")).click();
        Thread.sleep (2000);
        String confermationMessage = driver.findElement(By.xpath("//div[@class='message']")).getText();
        String exualMessage = "Vehicle Odometer deleted";
        Assert.assertEquals(confermationMessage,exualMessage);
    }
}

