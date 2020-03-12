package com.cbt.utilities;

public class StringUtility {
    public static void theResult (String expected, String actual){

        if(expected.equals(actual)){
            System.out.println("Test Passed!");
        }else{
            System.out.println("Test Failed");
        }
    }
}
