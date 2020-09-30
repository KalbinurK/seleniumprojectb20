package com.cybertek.tests.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SmartBearUtilities {
    //Mini-Task:
    //#1- Create a new class called : SmartBearUtilities
    //#2- Create a static method called loginToSmartBear
    //#3- This method simply logs in to SmartBear when you call it.
    //#4- Accepts WebDriver type as parameter
    public static void loginToSmartBear(WebDriver driver){
        //3. Enter username: “Tester”

        WebElement usernameInput = driver.findElement(By.id("ctl00_MainContent_username"));
        usernameInput.sendKeys("Tester");

        //4. Enter password: “test”
        WebElement passwordInput = driver.findElement(By.id("ctl00_MainContent_password"));
        passwordInput.sendKeys("test");

        //5. Click to Login button
        WebElement loginButton = driver.findElement(By.id("ctl00_MainContent_login_button"));
        loginButton.click();
    }
    /*

• Method takes WebDriver object and String(name).
• Method should verify if given name exists in orders.
• This method should simply accepts a name(String), and assert whether
given name is in the list or not.
• Create a new TestNG test to test if the method is working as expected.
     */

    // create locator that only retruns the names of the costomer from all of the rows
    //create a list and stored the cells that has costumer name information into it.
    public static void verifyOrder(WebDriver driver, String name){
        List<WebElement> nameList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr//td[2]"));

        // if there is only one table on hte page, you don't have to locate the tabel->//tr/td[2]

        // type iter, press tab for each loop shortcut.
        for (WebElement element : nameList) {
          if( element.getText().equals(name)){
              Assert.assertTrue(true);
              return; // means executed whole for each loop. can not move to next statment
          }
        }
        // Assert fail method will fail the test when it is called no matter what.
        Assert.fail("Name does not exist the list.");


    }

    /*
 • Create a method named printNamesAndCities in SmartBearUtils class.
 • Method takes WebDriver object.
 • This method should simply print all the names in the List of All Orders.
 • Create a new TestNG test to test if the method is working as expected.
 • Output should be like:
 • Name1: name , City1: city
 • Name2: name , City2: city
  */
    public static void printNamesAndCities(WebDriver driver){
        // locating all the names from all the rows and storing in a list of we ele
        List<WebElement> nameList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr//td[2]"));

        // we need to locate all the cities from the rows
        List<WebElement> cityList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr//td[7]"));

        for (int i = 0; i < cityList.size(); i++) {
            System.out.println(  "Name: "+(i+1)+nameList.get(i).getText() +
                    ", City: "+(i+1)+cityList.get(i).getText());
        }
    }

}
