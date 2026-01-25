package com.thetestingacademy.Selenium_WebTables;

import com.thetestingacademy.CommonToAll;
import com.thetestingacademy.ex07_WaitHelper.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class SeleniumWebTables2 extends CommonToAll {

    @Test
    public void test_web_table_login() {
        WebDriver driver = new ChromeDriver();
        openBrowser(driver, "https://awesomeqa.com/webtable1.html");

        // Find the xPath for the WebTable
        // -> //table[@summary="Sample Table"]

        WaitHelpers.waitImplicitWait(driver, 3);

        WebElement table = driver.findElement(By.xpath("//table[@summary='Sample Table']/tbody"));

        // rows and columns
        List<WebElement> rows_tables = table.findElements(By.tagName("tr"));

        for (int i = 0; i < rows_tables.size(); i++) {
            List<WebElement> col = rows_tables.get(i).findElements(By.tagName("td"));

            for (WebElement c : col) {
                System.out.println(c.getText());
            }
        }

        closeBrowser(driver);

    }
}
