package com.cybertek.tests.Project;

import com.cybertek.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class VyTrack_CreateVCost {

    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa2.vytrack.com/user/login");
        driver.findElement(By.name("_username")).sendKeys("user177");
        driver.findElement(By.name("_password")).sendKeys("UserUser123"+ Keys.ENTER);



    }
    @Test
    public void Create_V_Cost() throws InterruptedException {

        List<WebElement> fleetModule = driver.findElements(By.cssSelector(".title.title-level-1"));
        fleetModule.get(0).click();

        List<WebElement> fleetModuleDowndrop = driver.findElements(By.cssSelector(".title.title-level-2"));
        fleetModuleDowndrop.get(2).click(); // vehicle cost page

        Thread.sleep(1000);

        driver.findElement(By.linkText("Create Vehicle Costs")).click();

        Thread.sleep(1000);

       List<WebElement> chooseType = driver.findElements(By.linkText("Choose a value..."));
       chooseType.get(0).click();
       Thread.sleep(1000);
       List<WebElement> taxRoll = driver.findElements(By.cssSelector("div.select2-result-label"));
       taxRoll.get(2).click();
       Thread.sleep(1000);

       driver.findElement(By.name("custom_entity_type[TotalPrice]")).sendKeys("1200");
       Thread.sleep(1000);
        //Select the Date
        //-->CLick the Date--> Drop down the date
        WebElement date= driver.findElement(By.xpath("//input[@placeholder='Choose a date']"));
        date.click();
        //Select months
        driver.findElement(By.xpath("//div[@class='ui-datepicker-title']//select//option[9]")).click();// 1: Jan, 2:Feb, 3:Mar ....
        //Select year
        driver.findElement(By.xpath("//div[@class='ui-datepicker-title']//select[2]//option[81]")).click();// 1: 1940, 2:1941, 3:1942 ....
        //Select Day(this one will pick 2020/Sep/ {20})
        driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr[4]//td[1]")).click();// check the picker it will explan


        Thread.sleep(1000);
       driver.findElement(By.xpath("//textarea[@name='custom_entity_type[CostDescriptions]']")).sendKeys("Demo");


       driver.findElement(By.xpath("//button[@class='btn btn-success action-button']")).click();


    }
    @Test
    public void cancleCost() throws InterruptedException {
        List<WebElement> fleetModule = driver.findElements(By.cssSelector(".title.title-level-1"));
        fleetModule.get(0).click();

        List<WebElement> fleetModuleDowndrop = driver.findElements(By.cssSelector(".title.title-level-2"));
        fleetModuleDowndrop.get(2).click(); // vehicle cost page

        Thread.sleep(1000);

        driver.findElement(By.linkText("Create Vehicle Costs")).click();

        Thread.sleep(1000);


        driver.findElement(By.xpath("//a[@class='btn back icons-holder-text ']")).click();


    }

}
