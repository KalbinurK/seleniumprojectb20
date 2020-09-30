package com.cybertek.tests.day2_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P2_CybertekVerification {
    public static void main(String[] args) {

        //TC #2: Cybertek Verification
        //1. open Chrome browser
        //2. go to http://practice.cybertekschool.com
        //expected: cybertekschool
        //4. verify title:
        // expected practice
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com");

        String expectedUrl = "cybertekschool";

        String actualUrl = driver.getCurrentUrl();  // verify Url

        if (actualUrl.contains(expectedUrl)) {
            System.out.println("URL Verification passed");
        }else {
            System.out.println("URL Verification failed");
        }

        if(driver.getTitle().equals("Practice")){
            System.out.println("Title verification passed");

        }else {
            System.out.println("Title verification failed");
        }














    }
}
