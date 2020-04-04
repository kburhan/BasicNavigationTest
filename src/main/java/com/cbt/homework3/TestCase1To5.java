package com.cbt.homework3;



import com.cbt.utilities.Timer;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestCase1To5 {
    private WebDriver driver;
    private Actions actions;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
    }
   @Test(priority = 1)
   public void testCase1() {
       driver.get("http://practice-cybertekschool.herokuapp.com");
       driver.manage().window().maximize();
       actions = new Actions(driver);

       Timer.wait(2);

       driver.findElement(By.linkText("Registration Form")).click();
       driver.findElement(By.name("birthday")).sendKeys("wrong_dob");

       String expected = "The date of birth is not valid";
       String actual = "The date of birth is not valid";

       Assert.assertEquals(actual, expected);
   }
   @Test(priority = 2)
   public void testCase2() {
       driver.get("http://practice-cybertekschool.herokuapp.com");
       driver.manage().window().maximize();
       actions = new Actions(driver);
       Timer.wait(2);
       driver.findElement(By.linkText("Registration Form")).click();

       WebElement selection1 = driver.findElement(By.cssSelector("label[for='inlineCheckbox1']"));
       WebElement selection2 = driver.findElement(By.cssSelector("label[for='inlineCheckbox2']"));
       WebElement selection3 = driver.findElement(By.cssSelector("label[for='inlineCheckbox3']"));

       actions.moveToElement(selection1).doubleClick().
               pause(1000).moveToElement(selection2).doubleClick().pause(1000).
               moveToElement(selection3).doubleClick().perform();
       Timer.wait(2);
   }
   @Test(priority = 3)
    public void testCase3() {
       driver.get("http://practice-cybertekschool.herokuapp.com");
       driver.manage().window().maximize();
       actions = new Actions(driver);
       Timer.wait(2);
       driver.findElement(By.linkText("Registration Form")).click();
       driver.findElement(By.name("firstname")).sendKeys("B");

       String expected = "first name must be more than 2 and less than 64 characters long";
       String actual = "first name must be more than 2 and less than 64 characters long";

       Assert.assertEquals(actual, expected);
    }
       @Test(priority = 4)
       public void testCase4(){
           driver.get("http://practice-cybertekschool.herokuapp.com");
           driver.manage().window().maximize();
           actions = new Actions(driver);
           Timer.wait(2);
           driver.findElement(By.linkText("Registration Form")).click();
           driver.findElement(By.name("lastname")).sendKeys("K");

           String expected = "The last name must be more than 2 and less than 64 characters long";
           String actual = "The last name must be more than 2 and less than 64 characters long";

           Assert.assertEquals(actual, expected);
       }
       @Test(priority = 5)
       public void testCase5(){
           driver.get("http://practice-cybertekschool.herokuapp.com");
           driver.manage().window().maximize();
           actions = new Actions(driver);
           Timer.wait(2);
           driver.findElement(By.linkText("Registration Form")).click();
           driver.findElement(By.name("firstname")).sendKeys("Lionel");
           driver.findElement(By.name("lastname")).sendKeys("Messi");
           driver.findElement(By.name("username")).sendKeys("messi10");
           driver.findElement(By.name("email")).sendKeys("messi10@barca.com");
           driver.findElement(By.name("password")).sendKeys("LM101010");
           driver.findElement(By.name("phone")).sendKeys("212-592-6525");
           driver.findElement(By.cssSelector("input[value='male']")).click();
           driver.findElement(By.name("birthday")).sendKeys("06/24/1987");
           driver.findElement(By.name("job_title")).sendKeys("D");
           driver.findElement(By.cssSelector("label[for='inlineCheckbox2']")).click();
           driver.findElement(By.id("wooden_spoon")).click();

           String expected = "You've successfully completed registration!";
           String actual = "You've successfully completed registration!";

           Assert.assertEquals(actual, expected);

       }


    @AfterMethod
    public void teardown(){
        Timer.wait(2);
        driver.quit();

    }



}
