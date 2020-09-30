package com.cybertek.tests.SelfStudy;

import com.cybertek.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TC2_FindEle_Apple {

    public static void main(String[] args) {

        //1.Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.apple.com");
        //Go to https://www.apple.com
        //Click to iPhone
        WebElement iPhone = driver.findElement(By.xpath("//div[@class='ac-gn-content']/ul[2]/li[4]/a"));
        iPhone.click();

        //Print out the texts of all links
        List<WebElement> ListOfiPhone = driver.findElements(By.xpath("//body//a"));

        int linkWithoutTx= 0;
        int linkWithTx=0;
        for(WebElement eachLink : ListOfiPhone) {
            System.out.println(eachLink.getText());
        }
        /*
        5.Print out how many link is missing text
        6.Print out how many link has text
        7.Print out how many total lin
         */

        for(WebElement eachLink: ListOfiPhone){  //find out each link
            if(eachLink.getText().isEmpty()){
               linkWithoutTx++;
            }else {
                linkWithTx++;
            }


        }

        System.out.println("Number of Link with text: "+linkWithTx);
        System.out.println("Number of link without text: "+linkWithoutTx);
        System.out.println("Number of the total link: "+ListOfiPhone.size());


    }
}
