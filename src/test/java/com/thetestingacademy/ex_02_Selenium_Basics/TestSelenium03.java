package com.thetestingacademy.ex_02_Selenium_Basics;

import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSelenium03 {
    public static void main(String[] args) {
        //System.getProperty("webdriver.gecko.driver","/path/geckdriver");
        // this statement is required while using selenium 3


        FirefoxDriver driver = new FirefoxDriver();
        // new FirefoxDriver(); - This START of the Selenium Session
        // Sesion - Fresh copy of browser is started!.
        // POST request to the Server - Firefox Driver.


        driver.get("https://sdet.live");
        // Commmand number 2 - POST request to give to the driver to navigate to a URL




    }
}
