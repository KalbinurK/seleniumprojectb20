package com.cybertek.tests.utilities;

    /*
    in this class we will store utility methods that can be applied to any browser content
    Anytime you feel like you have a good logic that you can use in the future, create a method of it
    and store it in this class.
     */

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {
    /**
     * Accepts a list of Web Element
     *
     * @param list
     * @return List<String>
     * method should be retruning a list of Stings
     */

    public static List<String> getElementsText(List<WebElement> list) {

        List<String> WebElementAsString = new ArrayList<String>();
        for (WebElement each : list) {
            WebElementAsString.add(each.getText());

        }
        return WebElementAsString;
    }

    /*
    create a utility method named: wait
    static method
    @param sec
    @return void
    the interger number that i pass as parameter should be accepted as SECONDS
    handle checked exception with try/catch

     */

    public static void wait(int second){
        try {
            Thread.sleep(1000*second);
        }catch (InterruptedException e){
             e.printStackTrace();
        }
    }




}


