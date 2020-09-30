package com.cybertek.tests.SelfStudy.day1_facebook;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class facebookHhrefVerification {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");



        String actrualhref = driver.findElement(By.className("_8esh")).getAttribute("href");
        String expectedhref="registration_form";

        if(actrualhref.contains(expectedhref)){
            System.out.println("Href verification PASSED!");
        }else {
            System.out.println("Href verification FAILED!!!");
        }



    }


}

