/**
 * This class contains some commonly used verification methods.
 * 
 * @author mswanton
 */

package com.camsys.selenium.common;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CommonVerifications {

    public static void checkValErrorList(String errorList, String[] valErrorMsgs) {
        for (int i = 0; i < valErrorMsgs.length; i++) {
            Assert.assertTrue(errorList.contains(valErrorMsgs[i]),
                    		  "Incorrect Validation Message " + i);
        }
    }

    public static void checkEqualsStrings(String[] actual, String[] expected) {
        for (int i = 0; i < actual.length; i++) {
        	Log.debug("Actual: " + actual[i] + " Expected: " + expected[i]);
            Assert.assertEquals(actual[i], expected[i], "Incorrect string " + i + " - Actual: " +
            											 actual[i] + " Expected: " + expected[i]);
        }
    }
    
    public static void checkEqualsStrings(ArrayList<String> actual, ArrayList<String> expected){
    	for (int i = 0; i < actual.size(); i++) {
        	Log.debug("Actual: " + actual.get(i) + " Expected: " + expected.get(i));
            Assert.assertEquals(actual.get(i), expected.get(i), "Incorrect string " + i + " - Actual: "
					 											+ actual.get(i) + " Expected: " 
					 											+ expected.get(i));
        }
    }
    
    public static void checkPageTitle(WebDriver driver, String title){
        Assert.assertTrue(driver.getTitle().contains(title), 
        				  "Expected: " + title + ", Actual: " + driver.getTitle());
    }
    
    
}
