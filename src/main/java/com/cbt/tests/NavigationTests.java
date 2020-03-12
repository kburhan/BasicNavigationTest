package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import com.cbt.utilities.Timer;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class NavigationTests {
    public static void main(String[] args) {
        testChrome();
        Timer.wait(5);
        testSafari();
        Timer.wait(5);
        testFirefox();
    }
    public static  void testChrome(){
        WebDriver driver = BrowserFactory.createDriver("chrome");
        driver.get("https://google.com");
        String savedTitle = driver.getTitle();
        Timer.wait(1);
        driver.navigate().to("https://etsy.com");
        String savedTitle2 = driver.getTitle();
        Timer.wait(1);
        driver.navigate().back();
        String sT1A = driver.getTitle();
        StringUtility.theResult(savedTitle, sT1A);
        driver.navigate().forward();
        String sT2A = driver.getTitle();
        StringUtility.theResult(savedTitle2, sT2A);
        Timer.wait(3);
        driver.quit();
    }
    public static void testSafari(){
        WebDriver driver = BrowserFactory.createDriver("safari");
        driver.get("https://google.com");
        String t = driver.getTitle();
        Timer.wait(1);
        driver.navigate().to("https://etsy.com");
        String t2 = driver.getTitle();
        Timer.wait(1);
        driver.navigate().back();
        String t1 = driver.getTitle();
        StringUtility.theResult(t, t1);
        driver.navigate().forward();
        String t3 = driver.getTitle();
        StringUtility.theResult(t2, t3);
        Timer.wait(3);
        driver.quit();






    }
    public static void testFirefox(){

        WebDriver driver = BrowserFactory.createDriver("firefox");
        driver.get("https://google.com");
        String t = driver.getTitle();
        Timer.wait(1);
        driver.navigate().to("https://etsy.com");
        String t2 = driver.getTitle();
        Timer.wait(1);
        driver.navigate().back();
        String t1 = driver.getTitle();
        StringUtility.theResult(t, t1);
        driver.navigate().forward();
        String t3 = driver.getTitle();
        StringUtility.theResult(t2, t3);
        Timer.wait(3);
        driver.quit();

    }
}



