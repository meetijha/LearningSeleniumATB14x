package com.thetestingacademy.ex16_Selenium_Exceptions;

import com.thetestingacademy.CommonToAll;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Lab46_Selenium_Exceptions_Stale extends CommonToAll {
    @Test
    public void test_selenium_exceptions() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        System.out.println("Start of program");

        WebElement search_input_box = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));


        driver.navigate().refresh();

        try {
            search_input_box.sendKeys("the testing academy" + Keys.ENTER);
        } catch (StaleElementReferenceException e) {
            System.out.println("StaleElementReferenceException");
        }
    }
}
