package com.thetestingacademy.ex02_Selenium_Basics;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.io.File;

public class TestSelenium16_Mini_Project_2_Add_Extension {


    @Description("Options Class")
    @Test
    public void test_Selenium01() throws Exception {

        EdgeOptions chromeOptions = new EdgeOptions();
//        chromeOptions.addArguments("--window-size=1920,1080");
//        chromeOptions.addArguments("--incognito");
        File path = new File("src/test/java/com/thetestingacademy/ex02_Selenium_Basics/AdBlockers.crx");
        chromeOptions.addExtensions(path);

        WebDriver driver = new EdgeDriver(chromeOptions);
        driver.get("https://www.youtube.com/watch?v=BwTSxsAqlEc");

        Thread.sleep(15000);
        driver.quit();

    }
}

