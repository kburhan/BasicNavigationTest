package com.cbt.homework4;

import com.cbt.utilities.BrowserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Assignment {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
    @Test
    public void days() {
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox ");
        List<WebElement> days = driver.findElements(By.cssSelector(".gwt-CheckBox>label"));
        List<WebElement> checkboxes = driver.findElements(By.cssSelector(".gwt-CheckBox>input"));
        Random file = new Random();

        int cnt = 0;
        while (cnt < 3) {
            int index = file.nextInt(days.size());
            if (checkboxes.get(index).isEnabled()) {
                days.get(index).click();
                if (days.get(index).getText().equals("Friday")) {
                    cnt++;

                }
                System.out.println(days.get(index).getText());
                days.get(index).click();
            }
        }

    }
    @Test
    public void todays_date(){
        driver.get("http:practice.cybertekschool.com/dropdown");
        WebElement year = driver.findElement(By.id("year"));
        WebElement month = driver.findElement(By.id("month"));
        WebElement day = driver.findElement(By.id("day"));
        Select y = new Select(year);
        Select m = new Select(month);
        Select d = new Select(day);
        String yearValue = y.getFirstSelectedOption().getText();
        String monthValue = m.getFirstSelectedOption().getText();
        String dayValue = d.getFirstSelectedOption().getText();
        SimpleDateFormat simple = new SimpleDateFormat("yyyyMMMMdd");
        Assert.assertEquals(yearValue+monthValue+dayValue,simple.format(new Date()));

    }
    @Test
    public void years_months_days(){
        driver.get("http:practice.cybertekschool.com/dropdown");
        WebElement year = driver.findElement(By.id("year"));
        WebElement month = driver.findElement(By.id("month"));
        WebElement day = driver.findElement(By.id("day"));
        Select y = new Select(year);
        Select m = new Select(month);
        Select d = new Select(day);

        Random r = new Random();
        int index = r.nextInt(y.getOptions().size());
        y.selectByIndex(index);
        List<String> months31 = new ArrayList<>(Arrays.asList(new String[]{"January", "March", "May", "July", "August", "October", "December"}));
        int febDays;
        int yearValue = Integer.parseInt(y.getFirstSelectedOption().getText());
        if(yearValue %400==0 || (yearValue%4 ==0 && yearValue %100!=0)){
            febDays=29;
        }else{
            febDays=28;
        }
        for(int i =0; i<12; i++){
            m.selectByIndex(i);
            if(months31.contains(m.getFirstSelectedOption().getText())){
                Assert.assertEquals(d.getOptions().size(), 31);
            }else if(m.getFirstSelectedOption().getText().equals("February")){
                Assert.assertEquals(d.getOptions().size(), febDays);
            }else{
                Assert.assertEquals(d.getOptions().size(), 30);
            }
        }
    }
    @Test
    public void department_sort(){
        driver.get("https://www.amazon.com");
        Assert.assertEquals(driver.findElement(By.className("nav-search-label")).getText(), "All");
        List<WebElement> l1 =new Select(driver.findElement(By.id("searchDropdownBox"))).getOptions();
        boolean notAlphOrder = false;
        for( int i =0; i<l1.size()-1; i++){
            if(l1.get(i).getText().compareTo(l1.get(i+1).getText())>0){
                notAlphOrder=true;
                break;
            }
        }
        Assert.assertTrue(notAlphOrder);
    }
    @Test
    public void main_departments(){
        driver.get("https://www.amazon.com/gp/site-directory");
        List<WebElement> mainDep = driver.findElements(By.tagName("h2"));
        List<WebElement> allDep = new Select(driver.findElement(By.id("searchDropdownBox"))).getOptions();
        Set<String> mainDepS = new HashSet<>();
        Set<String> allDepS = new HashSet<>();
        for( WebElement each : mainDep){
            mainDepS.add(each.getText());
        }
        for( WebElement each : allDep){
            allDepS.add(each.getText());
        }
        for(String each : mainDepS){
            if(!allDepS.contains(each)){
                System.out.println(each);
            }
        }
        Assert.assertTrue(allDep.containsAll(mainDepS));
    }
    @Test
    public void links(){
        driver.get("https://www.w3schools.com/");
        List<WebElement> l1 = driver.findElements(By.tagName("a"));
        for(WebElement each : l1){
            if(each.isDisplayed()){
                System.out.println(each.getText());
                System.out.println(each.getAttribute("href"));
            }
        }
    }
    @Test
    public void validLinks() {
        driver.get("https://www.selenium.dev/documentation/en/");
        List<WebElement> l2 = driver.findElements(By.tagName("a"));
        System.out.println(l2.size());

        for (WebElement each : l2) {
            if (each.isDisplayed()) {
                System.out.println(each.getText());


            }

        }
    }
    @Test
    public  void  cart() {
            driver.get("https://amazon.com");
            driver.manage().window().maximize();
            WebDriverWait wait = new WebDriverWait(driver, 10);


            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon");
            driver.findElement(By.xpath("//input[@value='Go']")).click();

            List<WebElement> prices = driver.findElements(By.xpath("//a[@class='a-link-normal a-text-normal']//span"));
            Random random = new Random();
            int x = random.nextInt(prices.size());
            x = x == 0 ? 1 : x;
            String randomFirstName = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[" + x + "]")).getText();
            String randomPrice = "$" + driver.findElement(By.xpath("//span[@class='a-price']//span[2]//span[2][\"+x+\"]")).getText() + "." +
                    driver.findElement(By.xpath("//span[@class='a-price']//span[2]//span[3][\"+x+\"]")).getText();

            driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[" + x + "]")).click();

            Assert.assertEquals(driver.findElement(By.xpath("//span[@class='a-dropdown-prompt'][1]")).getText(), "1");

            Assert.assertEquals(driver.findElement(By.id("productTitle")).getText(), randomFirstName);
            Assert.assertEquals(driver.findElement(By.id("priceblock_ourprice")).getText(), randomPrice);

            WebElement addToCart = driver.findElement(By.id("add-to-cart-button"));
            Assert.assertTrue(addToCart.isDisplayed());
        }

    @Test
    public void moreSpoons(){
        driver.get("https://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon", Keys.ENTER);
        List<WebElement> brandList  = driver.findElements(By.id("brandsRefinements"));
        List<String> brandNames = BrowserFactory.getTextFromWebElements(brandList );
        System.out.println("brandNames = " + brandNames );
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.findElement(By.id("p_85/2470955011")).click();











    }
    @Test
    public void cheapSpoons(){
        driver.get("https://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon", Keys.ENTER);
        driver.findElement(By.linkText("Under $25")).click();

        List<WebElement> prices = driver.findElements(By.className("a-price-whole"));
        List<String> pricesText = BrowserFactory.getTextFromWebElements(prices);
        System.out.println(pricesText);
        for (String price : pricesText) {

            int priceConverted = Integer.parseInt(price);
            Assert.assertTrue(priceConverted < 25);
        }

    }
    @AfterMethod
            public void teardown () {
                driver.quit();

            }
        }
