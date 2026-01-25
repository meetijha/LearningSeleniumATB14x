package com.thetestingacademy.ex16_Selenium_Exceptions;

import com.thetestingacademy.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

public class Lab47_Selenium_Exceptions_Stale extends CommonToAll {

    @Test
    public void test_selenium_exceptions() throws TimeoutException {

        WebDriver driver = new ChromeDriver();
        System.out.println("Start of program");
        driver.get("https://google.com");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='APjFqb']")));

        driver.navigate().refresh();

        WebElement search_inputbox = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        search_inputbox.sendKeys("the testing academy");

    }
}
