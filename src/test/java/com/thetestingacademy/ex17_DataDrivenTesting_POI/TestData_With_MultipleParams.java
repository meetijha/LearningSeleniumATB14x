package com.thetestingacademy.ex17_DataDrivenTesting_POI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestData_With_MultipleParams {
    @Test(dataProvider = "getData")
    public void test_vwo_login(String email, String password) {

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://app.vwo.com");
        System.out.println(driver.getTitle());

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(driver.getTitle(), "Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(), "https://app.vwo.com/#/login");


        // 1. Find the email inputbox and enter the email
        WebElement emailInputBox = driver.findElement(By.id("login-username"));
        emailInputBox.sendKeys(email);


        String[] s = password.split("_");
        String passwd = s[0];
        String testStatus=s[1];
        String message =s[2];

        WebElement passwordInputBox = driver.findElement(By.name("password"));
        passwordInputBox.sendKeys(passwd);

        System.out.println(testStatus+" | "+message);

        WebElement buttonSubmit = driver.findElement(By.id("js-login-btn"));
        buttonSubmit.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("notification-box-description")));

        WebElement error_message = driver.findElement(By.className("notification-box-description"));
        Assert.assertEquals(error_message.getText(), "Your email, password, IP address or location did not match");

    }

    @DataProvider
    public Object[][] getData(){
        // READ THE DATA FROM THE EXCEL FILE
        // GIVE THEM IN THE 2D ARRAY
        System.out.println("Accessing sheet 2");
        return UtilExcel.getTestDataFromExcel("Sheet2");

    }
}
