package com.thetestingacademy.ex05_Selenium_Waits;

import com.thetestingacademy.CommonToAll;
import com.thetestingacademy.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;
public class TestSelenium25_Fluent_Wait extends CommonToAll {


    @Test
    public void test_FW(){

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://app.vwo.com");
        System.out.println(driver.getTitle());

        Assert.assertEquals(driver.getTitle(), "Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(), "https://app.vwo.com/#/login");


        // 1. Find the email inputbox and enter the email
        WebElement emailInputBox = driver.findElement(By.id("login-username"));
        emailInputBox.sendKeys("admin@admin.com");


        WebElement passwordInputBox = driver.findElement(By.name("password"));
        passwordInputBox.sendKeys("password@321");


        WebElement buttonSubmit = driver.findElement(By.id("js-login-btn"));
        buttonSubmit.click();

        //        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        // Explicit Wait
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("notification-box-description")));


        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);


        WebElement error_message = wait.until(
                new Function<WebDriver, WebElement>() {
                    @Override
                    public WebElement apply(WebDriver webDriver) {
                        return driver.findElement((By.className("notification-box-description")));

                    }
                }
        );

        Assert.assertEquals(error_message.getText(), "Your email, password, IP address or location did not match");
        driver.quit();





    }
}
