package com.thetestingacademy.ex_02_Selenium_Basics;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestSelenium09_Assertion_TestNG {

    @Description("Open the url")
    @Test

    public void test_Selenium01(){
        WebDriver driver=new ChromeDriver() ;

        driver.get("Https://google.com");

        //TestNG Assert

        Assert.assertEquals(driver.getTitle(),"Google");

        //AssertJ validation
        assertThat(driver.getCurrentUrl()).isNotBlank().isNotNull().isEqualTo("https://www.google.com/");

   driver.quit();
    }
}
