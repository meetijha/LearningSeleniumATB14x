package com.thetestingacademy.ex04_Selenium_XPATH;

import com.thetestingacademy.CommonToAll;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium20_MiniProject extends CommonToAll {
    @Owner("Meeti")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify login is working")
    @Test
    public void test_OHRM_login() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        openBrowser(driver, "https://awesomeqa.com/hr/web/index.php/auth/login");

        WebElement input_username = driver.findElement(By.xpath("//input[@name=\"username\"]"));
        WebElement input_password = driver.findElement(By.xpath("//input[@placeholder=\"Password\"]"));
        WebElement button = driver.findElement(By.xpath("//button"));

        input_username.sendKeys("admin");
        input_password.sendKeys("Hacker@4321");
        button.click();

        customWait(3000);

        WebElement h6 = driver.findElement(By.xpath("//span[@class=\"oxd-topbar-header-breadcrumb\"]/h6"));

        Assert.assertEquals(h6.getText(), "PIM");

        closeBrowser(driver);
    }
}
