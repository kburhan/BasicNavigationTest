package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TitleVerification2 {
    public static void main(String[] args) {
        List<String> urls = Arrays.asList(
                "http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown",
                "http://practice.cybertekschool.com/login");
        WebDriver driver = BrowserFactory.createDriver("chrome");

        for (String eachUrl: urls){

            driver.get(eachUrl);
            if(eachUrl.contains(driver.getTitle().replace(" ","").toLowerCase())){
                System.out.println("TEST PASSED");
                
            }else{
                System.out.println("TEST FAILED");
                System.out.println(eachUrl);
                System.out.println(driver.getTitle());
            }

        }


        driver.quit();



    }
}
