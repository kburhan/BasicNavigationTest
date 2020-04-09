package com.cbt.homework3;

import com.cbt.utilities.Timer;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase7 {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.manage().window().maximize();

    }
    @Test
    public void test7(){
        driver.findElement(By.linkText("File Upload")).click();
        driver.findElement(By.id("file-upload")).sendKeys("/Users/BurhanKaya/Desktop/classnotes.txt");
        driver.findElement(By.id("file-submit")).click();
        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(),"File Uploaded!");
        Assert.assertEquals(driver.findElement(By.id("uploaded-files")).getText(),"classnotes.txt");
}
    @AfterMethod
    public void tearDown(){
        Timer.wait(3);
        driver.quit();
    }

}

