package com.cybertek.tests.day4_findEle_checkboxes_redio;

import com.cybertek.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P1_CybertekForgetPassword {

    public static void main(String[] args) {


        //TC #1: PracticeCybertek.com_ForgotPassword WebElement verification1. Open Chrome browser

   /* 2. Go to http://practice.cybertekschool.com/forgot_password
      3. Locate all the WebElements on the page using XPATH and/or CSS locator only (total of 6)
     a. “Home” link
     b. “Forgot password” header
     c. “E-mail” textd. E-mail input box
     e. “Retrieve password” button
     f. “Powered by Cybertek School” text
     4. Verify all WebElements are displayed. Better if you do with both XPATH and CSS selector for practice purposes
     */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement homeLink = driver.findElement(By.xpath("//a[.='Home']"));
        WebElement forgotpassword= driver.findElement(By.xpath("//h2[.='Forgot Password']"));

        WebElement emailLabel = driver.findElement(By.xpath("//label[@for='email']"));

        WebElement emailInput = driver.findElement(By.xpath("//input[@name='email']"));

        WebElement retrivePassword = driver.findElement(By.cssSelector("button.radius"));

        WebElement linkText = driver.findElement(By.xpath("//a[.='Cybertek School']"));

        System.out.println(linkText.getText());

        WebElement powerBydir = driver.findElement(By.xpath("//div[@style='text-align: center;']"));
        System.out.println(powerBydir.getText());


      if (homeLink.isDisplayed() & emailLabel.isDisplayed() & emailInput.isDisplayed() & retrivePassword.isDisplayed()
                    & powerBydir.isDisplayed()&homeLink.isDisplayed()) { // isdisplayed-> boolean true is for web ele display

          System.out.println("All web ele are displayed, verification passed");
      } else {
          System.out.println("One or more of the web else are not displayed, verification failed!");
      }




    }

}
