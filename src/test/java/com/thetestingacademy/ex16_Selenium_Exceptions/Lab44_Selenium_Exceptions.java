package com.thetestingacademy.ex16_Selenium_Exceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Lab44_Selenium_Exceptions {
    @Test
    public void test_selenium_exceptions() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com/");

        driver.findElement(By.id("meeti"));

        //org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {"method":"css selector","selector":"#meeti"}
    }
}
