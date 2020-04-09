package com.cbt.homework3;

import com.cbt.utilities.Timer;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase6 {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
    }

    @Test
    public void testCase(){
        driver.navigate().to("http://www.tempmailaddress.com/");
        driver.manage().window().maximize();
        WebElement element1 = driver.findElement(By.id("email"));
        String text = element1.getText();

        driver.get("http://practice-cybertekschool.herokuapp.com/");

        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        driver.findElement(By.name("full_name")).sendKeys(" Fake Name");
        driver.findElement(By.name("email")).sendKeys(text);
        Timer.wait(2);
        driver.findElement(By.name("wooden_spoon")).click();

        String expected =  "Thank you for signing up. Click the button below to return to the home page.";
        String actual =  "Thank you for signing up. Click the button below to return to the home page.";
        Assert.assertEquals(actual, expected);

        Timer.wait(2);
        driver.navigate().back();
        Timer.wait(2);
        driver.navigate().back();
        driver.navigate().back();

        driver.findElement(By.cssSelector("td[class='from']")).click();


        String expected1 ="Thank you for subscribing to practice.cybertekschool.com!";
        String actual1 =  "Thank you for subscribing to practice.cybertekschool.com!";
        Assert.assertEquals(actual, expected);






    }

















    @AfterMethod
    public void tearDown(){
        Timer.wait(3);
        driver.quit();
    }

}
