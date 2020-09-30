package com.cybertek.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException{

        // 1. set up the web driver

        WebDriverManager.chromedriver().setup();

        //2. crete the instance od the chrome driver
        WebDriver driver = new ChromeDriver();
        // 3. test if driver is working

        driver.get("https://www.google.com");

        System.out.println("the title of the page is: " + driver.getTitle());
        String actualTitle = driver.getCurrentUrl() ;

        System.out.println("actualUrl "+actualTitle);

        Thread.sleep(2000);

        driver.navigate().back();

        Thread.sleep(3000);
        driver.navigate().forward();

        Thread.sleep(2000);
        driver.navigate().refresh();

        Thread.sleep(3000);
        driver.navigate().to("https://www.facebook.com");  // this method needs argument

       //  String pageSource = driver.getPageSource();  // return the page with string

       //  System.out.println("page source= "+pageSource);

        driver.manage().window().maximize();

        driver.close();





    }
}
