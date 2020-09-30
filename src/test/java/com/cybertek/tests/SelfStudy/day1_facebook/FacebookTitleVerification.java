package com.cybertek.tests.SelfStudy.day1_facebook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookTitleVerification {
    /*
    TC #1: Facebook title verification
1. Open Chrome browser
2. Go to https://www.facebook.com
3. Verify title:
Expected: “Facebook - Log In or Sign Up”

     */
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com");

        String ExpectedTitle = "Facebook - Log In or Sign Up";
        String actrualTitle = driver.getTitle();

        if(actrualTitle.equals(ExpectedTitle)){
            System.out.println("Title verification Passed");
        }else {
            System.out.println("Title verification failed");
        }



    }

}
