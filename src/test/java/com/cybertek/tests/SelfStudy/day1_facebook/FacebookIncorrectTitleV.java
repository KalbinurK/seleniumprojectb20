package com.cybertek.tests.SelfStudy.day1_facebook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookIncorrectTitleV {
    public static void main(String[] args) {
        /*
        TC #2: Facebook incorrect login title verification
1. Open Chrome browser
2. Go to https://www.facebook.com
3. Enter incorrect username
4. Enter incorrect password
5. Verify title changed to:
Expected: “Log into Facebook | Facebook”

         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");



        driver.findElement(By.name("email")).sendKeys("wst3214@gmail.com"+ Keys.ENTER);

        driver.findElement(By.name("pass")).sendKeys("1234560"+Keys.ENTER);




        String ActualTitle = "Log into Facebook | Facebook";
        String ExpectedTitle = driver.getTitle();


        if(ActualTitle.equals(ExpectedTitle)){
            System.out.println("title verification Passed");
        }else {
            System.out.println("title verification failed");

        }

        driver.close();


    }
}
