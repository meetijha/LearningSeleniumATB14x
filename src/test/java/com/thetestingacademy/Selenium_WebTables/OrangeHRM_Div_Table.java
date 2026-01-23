package com.thetestingacademy.Selenium_WebTables;

import com.thetestingacademy.CommonToAll;
import com.thetestingacademy.ex07_WaitHelper.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class OrangeHRM_Div_Table extends CommonToAll {

    @Test
    public void print_Table_Data() throws Exception{
        WebDriver driver= new ChromeDriver();
        openBrowser(driver,"https://awesomeqa.com/hr/web/index.php/auth/login");

        //Login
        WaitHelpers.waitImplicitWait(driver,3);
        WebElement input_username = driver.findElement(By.xpath("//input[@name=\"username\"]"));
        WebElement input_password = driver.findElement(By.xpath("//input[@placeholder=\"Password\"]"));
        WebElement button = driver.findElement(By.xpath("//button"));

        input_username.sendKeys("admin");
        input_password.sendKeys("Hacker@4321");
        button.click();

        //Click PIM

        WaitHelpers.waitImplicitWait(driver,5);
        WebElement PIM = driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='PIM']"));
        PIM.click();
        Thread.sleep(7000);

      //Get Employee List

      List<WebElement> empList=driver.findElements(By.xpath("//div[contains(@class,\"oxd-table-card\")]//div[@role='row']"));
        System.out.println(empList.size());



        Thread.sleep(3000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");


        List<WebElement> firstNames = driver.findElements(
                By.xpath("//div[@role='row']//div[@role='cell'][2]")
        );

        List<WebElement> lastNames = driver.findElements(
                By.xpath("//div[@role='row']//div[@role='cell'][3]")
        );

        for (int i = 0; i < firstNames.size(); i++) {
            System.out.println(firstNames.get(i).getText() + " " + lastNames.get(i).getText());
        }


        closeBrowser(driver);
    }
}
