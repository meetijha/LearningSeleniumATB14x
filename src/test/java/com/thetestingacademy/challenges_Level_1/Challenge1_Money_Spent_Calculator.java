package com.thetestingacademy.challenges_Level_1;

import com.thetestingacademy.CommonToAll;
import com.thetestingacademy.ex07_WaitHelper.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Challenge1_Money_Spent_Calculator extends CommonToAll {

    @Test
    public void calculate_money_spent() {
        WebDriver driver = new ChromeDriver();
        openBrowser(driver, "https://demo.applitools.com");

        //Login Webelements
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement signIn = driver.findElement(By.id("log-in"));

        // Fill form and sign in
        username.sendKeys("Admin");
        password.sendKeys("Password@123");

        signIn.click();
        WaitHelpers.waitJVM(5000);

        // Very app.html page
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("app.html"));

        //Get all finance data
        List<WebElement> additions = driver.findElements(By.xpath("//span[@class='text-success']"));
        List<WebElement> minus = driver.findElements(By.xpath("//span[@class='text-danger']"));

        Float moneySpent = 0.0f;
        for (WebElement m : additions) {
            String moneyUSD = m.getText();
            String[] money = moneyUSD.split(" ");
            moneySpent = moneySpent + Float.parseFloat(money[1].replace(",", ""));
        }

        for (WebElement m : minus) {
            String moneyUSD = m.getText();
            String[] money = moneyUSD.split(" ");
            moneySpent = moneySpent - Float.parseFloat(money[1].replace(",", ""));
        }

        System.out.println("Money Spent = " + moneySpent + " USD");
        Assert.assertEquals(moneySpent, 1996.22f);

        //close browser
        closeBrowser(driver);

    }


}
