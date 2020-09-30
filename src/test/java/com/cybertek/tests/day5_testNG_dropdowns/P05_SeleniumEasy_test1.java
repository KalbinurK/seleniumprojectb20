package com.cybertek.tests.day5_testNG_dropdowns;

import com.cybertek.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class P05_SeleniumEasy_test1 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebElement successCheckBox = driver.findElement(By.xpath("//input[@id='isAgeSelected']"));

        WebElement successMessage= driver.findElement(By.xpath("//div[@id='txtAge']"));

        if(!successMessage.isDisplayed()){
            System.out.println("success message is not display, verification is passed");
        }else {
            System.out.println("success message is display, verification failed");
        }
        successCheckBox.click();

        if(successMessage.isDisplayed()){
            System.out.println("success message is display, verification passed");
        }else {
            System.out.println("success message is not display, verification failed");
        }
        Thread.sleep(2000);
        driver.close();




    }
}
