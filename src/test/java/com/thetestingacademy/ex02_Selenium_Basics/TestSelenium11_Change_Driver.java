package com.thetestingacademy.ex02_Selenium_Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSelenium11_Change_Driver {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver = new ChromeDriver();
    }
}
