package com.cybertek.tests.day9_windows_tabs;

import com.cybertek.tests.utilities.BrowserUtils;
import com.cybertek.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandlingPractices {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/windows");

    }

    /*
    TC5 # : Window Handle practice
    1. Create a new class called: WindowHandlePractice
    2. Create new test and make set ups
    3. Go to : http://practice.cybertekschool.com/windows
    4. Assert: Title is “Practice”
    5. Click to: “Click Here” text
    6. Switch to new Window.
    7. Assert: Title is “New Window”
     */

    @Test
    public void p5_handling_windows(){
        String actualTitle = driver.getTitle();
        System.out.println("actual title: "+actualTitle);

        Assert.assertTrue(actualTitle.equals("Practice"),"actual not match, test failed");

        WebElement clickHereLink = driver.findElement(By.linkText("Click Here"));
        clickHereLink.click();
        String titleAfterClick = driver.getTitle();
        System.out.println("title after click" + titleAfterClick);
        String mainHandle = driver.getWindowHandle();
        System.out.println("title after click: "+mainHandle);

        // set allow only unique value
        //alt+enter to window
        Set<String> windowHandles = driver.getWindowHandles();

        // we loop through the set of window handles that we can get the window handle of the windows
        // then using swtich().window() method get switch to the other windows
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            System.out.println("current title= "+driver.getTitle());
        }
        // getting the current title and comparing with expected title
        Assert.assertTrue(driver.getTitle().equals("New Window"));

        BrowserUtils.wait(2);


        // if I want to switch back to main page, to continue with some other actions
        driver.switchTo().window(mainHandle);

        driver.quit();

    }

    @Test
    public void p6_handling_more_than_two_windows() {

        driver.get("https://amazon.com");

        // this line is basically: we are dwoncasting our driver type to JavaScriptExecutor
        // the only thing this line is doing is using JS executor-> opening
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

        Set<String> windowHadles = driver.getWindowHandles();
        // Amazon
        //Facebook
        //Etsy
        //Google

        for (String windowHandle : windowHadles) {
            BrowserUtils.wait(1);
            driver.switchTo().window(windowHandle);
            System.out.println("current page title: "+driver.getTitle());

            if (driver.getCurrentUrl().contains("etsy")){
                Assert.assertTrue(driver.getTitle().contains("Etsy"));
                break;
            }

        }
    }

    }

