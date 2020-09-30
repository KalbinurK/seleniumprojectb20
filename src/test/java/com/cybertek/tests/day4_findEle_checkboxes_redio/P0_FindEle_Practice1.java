package com.cybertek.tests.day4_findEle_checkboxes_redio;

import com.cybertek.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P0_FindEle_Practice1 {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/forgot_password");

        List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));

        // looping through the list of webele we just created above
        for(WebElement eachLink: listOfLinks){
            System.out.println(eachLink.getText());
        }



        int numberOfLink = listOfLinks.size();
        System.out.println(numberOfLink);
















    }
}
