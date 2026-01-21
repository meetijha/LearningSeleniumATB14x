package com.thetestingacademy.assignment.SelectorHubPractice;

import com.thetestingacademy.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ex_04_PaymentPage extends CommonToAll {
    WebDriver driver;
    Actions action;

    @BeforeTest
    public void setUp(){

        driver=new ChromeDriver();
        action=new Actions(driver);
        openBrowser(driver, "https://selectorshub.com/xpath-practice-page/");

    }

    @Test
    public void fillPaymentPage(){

        WebElement cardName= driver.findElement(By.xpath("//input[@id='cardName']"));
        WebElement cardNumber= driver.findElement(By.xpath("//input[@id='cardNumber']"));
        WebElement expiryDate=driver.findElement(By.xpath("//input[@id='expiry']"));
        WebElement cvv=driver.findElement(By.xpath("//input[@id='cvv']"));
        WebElement payBtn=driver.findElement(By.xpath("//button[contains(text(),'Pay')]"));

        cardName.sendKeys("Meeti");
        cardNumber.sendKeys("1111222233334444");
        expiryDate.sendKeys("10/26");
        cvv.sendKeys("123");

        action.moveToElement(payBtn).build().perform();
        payBtn.click();
    }
    @AfterTest
    public void close() {
        closeBrowser(driver);
    }
}
