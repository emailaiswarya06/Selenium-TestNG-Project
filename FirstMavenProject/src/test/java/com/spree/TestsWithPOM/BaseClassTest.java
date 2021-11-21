package com.spree.TestsWithPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseClassTest {

    WebDriver driver;
    @BeforeMethod
    public void setDriver(){

        System.setProperty("webdriver.chrome.driver","./Driver/chromedriver");
         driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url ="https://spree-vapasi-prod.herokuapp.com/login";
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
    @AfterMethod
    public void tearDown(){

        driver.findElement(By.cssSelector("input[value='Empty Cart']")).click(); //empty cart for next test
        driver.close();
        driver.quit();
    }

}
