package com.cybertek.tests.Project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VyTrack {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa2.vytrack.com/user/login");

        driver.manage().window().maximize();

        driver.findElement(By.name("_username")).sendKeys("user177"+ Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.name("_password")).sendKeys("UserUser123"+Keys.ENTER);
        Thread.sleep(1000);


        String actualTitle = "Dashboard";
        String expectedtitle = driver.getTitle();
        System.out.println(expectedtitle);

        if(actualTitle.equals(expectedtitle)){
            System.out.println("title verification Passed!");
        }else {
            System.out.println("title verification failed!");
        }




    }
}
