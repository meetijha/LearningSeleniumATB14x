package com.thetestingacademy.ex_02_Selenium_Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium08_Maximize_Minimize {
    @Test
    public void test_1() throws InterruptedException{

        WebDriver driver=new FirefoxDriver();
        driver.get("https://google.com");

        driver.manage().window().maximize();
        //driver.manage().window().minimize();

        Thread.sleep(3000);

        Assert.assertEquals(driver.getTitle(),"Google");

        driver.quit();
    }
}
