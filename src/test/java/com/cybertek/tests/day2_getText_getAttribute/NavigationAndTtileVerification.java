package com.cybertek.tests.day2_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationAndTtileVerification {
    /*
    TC #3: Back and forth navigation1-Open a chrome browser2-Go to: https://google.com3-Click
    to Gmail from top right.4-Verify title contains:Expected: Gmail5-Go back to Google by using the .
    back();6-Verify title equals:Expected: Google
     */

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver =new ChromeDriver();

        driver.get("https://google.com");

        driver.findElement(By.linkText("Gmail")).click();

        String expectedT = "Gmail";
        String actualT= driver.getTitle();

        if (actualT.contains(expectedT)) {
            System.out.println("title verification Passed");
        }else {
            System.out.println("tile verification failed");
        }
        driver.navigate().back();

        String expecteGoogleT ="Google";
        String actualgooglet = driver.getTitle();
        if (actualgooglet.equals(expecteGoogleT)) {
            System.out.println("title verification Passed");
        }else {
            System.out.println("title verification failed");
        }



    }
}
