package com.cybertek.tests.day2_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P1_GoogleTitleVerification {
    public static void main(String[] args) {
        // TC:#1 google title verification
        //1. open Chrome browser
        // go to http:// www.google.com 3. werify titlel
        // expected: google

        // first set up the browser driver.
        WebDriverManager.chromedriver().setup();
        // if you are using browser drivers locally, you can use system. set properly everytime
        //we use WebDriverManager

        // open a chrome browser
        // we create on instance of the chromeDriver. which also opens oon empty browser for us.
        WebDriver driver = new ChromeDriver();

        // go to goole.com
        driver.get("https://google.com");

        //3. verify title
        //Expected: Google

        String expectedTitle = "Google";
        String actualTitle= driver.getTitle();



        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title verification Passed");
        }else {
            System.out.println("Title verification failed");
        }











    }
}
