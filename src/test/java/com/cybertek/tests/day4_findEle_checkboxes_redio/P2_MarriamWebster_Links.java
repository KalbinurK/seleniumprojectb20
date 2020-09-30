package com.cybertek.tests.day4_findEle_checkboxes_redio;

import com.cybertek.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P2_MarriamWebster_Links {
    /*
    1.Open Chrome browser
    2.Go to https://www.merriam-webster.com/
    3.Print out the texts of all links
    4.Print out how many link is missing text
    5.Print out how many link has text6.Print out how many total link
     */
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.merriam-webster.com/");



        List<WebElement> ListOfLinks = driver.findElements(By.xpath("//body//a"));

        int linkWithoughtText = 0;
        int linkWithText= 0;

        for(WebElement eachLink: ListOfLinks){
            String textOfEachLink= eachLink.getText();

            System.out.println(textOfEachLink);


            if (textOfEachLink.isEmpty()){
                linkWithoughtText+=1;
            }else {
                linkWithText+=1;
            }
        }
        System.out.println(linkWithoughtText);
        System.out.println(linkWithText);
        System.out.println(ListOfLinks.size());








    }
}
