package com.cybertek.tests.SelfStudy.day1_facebook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HeaderVerification {
    /*
    TC #3: Facebook header verification
    1.Open Chrome browser
    2.Go to https://www.facebook.com
    3.Verify header text is as expected:
    Expected: “Connect with friends and the world around you on Facebook.
     */

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");

        String actualHeader = driver.findElement(By.tagName("h2")).getText();
        String expectedHeader = "Connect with friends and the world around you on Facebook.";

        if (actualHeader.equals(expectedHeader)) {
            System.out.println("Header verification PASSED!");
        } else {
            System.out.println("Header verification FAILED!!!");
        }


    }
}
