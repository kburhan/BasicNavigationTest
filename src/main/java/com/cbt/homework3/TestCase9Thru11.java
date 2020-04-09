package com.cbt.homework3;

import com.cbt.utilities.Timer;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCase9Thru11 {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.manage().window().maximize();
    }
    @DataProvider
    public Object[][] clickStatus(){
        return new Object [][]{
                {"Status Codes", "200"},
                {"Status Codes", "301"},
                {"Status Codes", "404"},
                {"Status Codes", "500"}
        };
    }
    @Test(dataProvider = "clickStatus")
    public void test9_12(String link, String value){
        driver.findElement(By.linkText(link)).click();
        driver.findElement(By.linkText(value)).click();
        Assert.assertTrue(driver.findElement(By.xpath("//p")).getText().contains("This page returned a "+value+" status code."));


    }



    @AfterMethod
    public void teardown(){
        Timer.wait(2);
        driver.quit();
        }

    }

