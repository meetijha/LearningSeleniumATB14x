package com.thetestingacademy.ex_02_Selenium_Basics;

import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSelenium002_BasicSelenium {
    public static void main(String[] args) {
        FirefoxDriver driver =new FirefoxDriver();
        driver.get("https://google.com");
    }
}
