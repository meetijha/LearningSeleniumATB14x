package com.thetestingacademy.ex02_Selenium_Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSelenium13_NOHTTPP {

    public static void main(String[] args) {
        WebDriver driver=new FirefoxDriver();
        //driver.get("bing.com"); // cant write like this..HTTPs is important.
        driver.get("https://bing.com");
    }
}
