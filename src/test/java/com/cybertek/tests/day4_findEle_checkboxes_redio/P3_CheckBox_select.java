package com.cybertek.tests.day4_findEle_checkboxes_redio;

import com.cybertek.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P3_CheckBox_select {
    /*
    1.Go	to	http://practice.cybertekschool.com/checkboxes
    2.Confirm	checkbox #1	is	NOT	selected	by	default
    3.Confirm	checkbox #2	is	SELECTED	by	default.
    4.Click	checkbox #1	to	select	it.
    5.Click	checkbox #2	to	deselect	it.
    6.Confirm	checkbox	#1	is	SELECTED.
    7.Confirm	checkbox	#2	is	NOT
     */
    public static void main (String[] args) throws InterruptedException {


        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/checkboxes");

        WebElement checkBox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));
        if(!checkBox1.isSelected()){
            System.out.println("check box is not selected, Verification Passed");
        }else {
            System.out.println("Check box is selected, verification failed");
        }

        if(checkBox2.isSelected()){
            System.out.println("Check box is selected, verification passed");
        }else {
            System.out.println("Check box not selected, verification failed");
        }
        Thread.sleep(2000);
        checkBox1.click();
        Thread.sleep(2000);

        checkBox2.click();

        WebElement homeLink = driver.findElement(By.xpath("//a.='Home'"));

        Thread.sleep(1000);

        driver.navigate().refresh();

        checkBox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        checkBox1.click();



    }
}