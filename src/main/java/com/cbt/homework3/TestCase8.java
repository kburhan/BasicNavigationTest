package com.cbt.homework3;

import com.cbt.utilities.Timer;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase8 {
private WebDriver  driver;

@BeforeMethod
public void setup() {

    WebDriverManager.chromedriver().version("79").setup();
    driver = new ChromeDriver();
    driver.get("https://practice-cybertekschool.herokuapp.com");
    driver.manage().window().maximize();
}
@Test
public void verifyUS(){
    driver.findElement(By.linkText("Autocomplete")).click();
    driver.findElement(By.id("myCountry")).sendKeys("United States of America");
    driver.findElement(By.className("btn")).click();
    Assert.assertEquals(driver.findElement(By.id("result")).getText()
            ,"You selected: United States of America");

}
@AfterMethod
    public void teardown(){
    Timer.wait(2);
    driver.quit();
}

}
