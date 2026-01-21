package com.thetestingacademy.assignment.SelectorHubPractice;

import com.thetestingacademy.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.thetestingacademy.ex07_WaitHelper.WaitHelpers.waitJVM;

public class ex01_DummyForm extends CommonToAll {

    WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void openBrowser(){

        openBrowser(driver, "https://selectorshub.com/xpath-practice-page/");
    }

    @Test
    public void enterDummyForm() {

        //Form Elements
        WebElement email = driver.findElement(By.xpath("//input[@title='Email']"));
        WebElement password = driver.findElement(By.id("pass"));
        WebElement company = driver.findElement(By.name("company"));
        WebElement mobileNum = driver.findElement(By.name("mobile number"));
        WebElement country = driver.findElement(By.xpath("//label[text()='Country']/input"));
        WebElement submit = driver.findElement(By.xpath("//button[text()='Submit']"));

        //Fill form
        email.sendKeys("abcd@gmail.com");
        password.sendKeys("dummy@4321");
        company.sendKeys("TTA");
        mobileNum.sendKeys("987654321");
        country.sendKeys("India");

        // pratice scroll down, can use actions also to move to an element
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500);");
        waitJVM(5000);

        submit.click();
    }

    @AfterTest
    public void close() {
        closeBrowser(driver);
    }
}
