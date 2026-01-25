package com.thetestingacademy.Selenium_WebTables;

import com.thetestingacademy.CommonToAll;
import com.thetestingacademy.ex07_WaitHelper.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumWebTables1 extends CommonToAll {

    @Test
    public void Test_web_table_Login() throws Exception {

        WebDriver driver = new ChromeDriver();
        openBrowser(driver, "https://awesomeqa.com/webtable.html");

        // xpath ->  //table[@id="customers"]/tbody/tr[5]/td[2]
        //xpath - //table[@id="customers"]/tbody/tr[
        // i
        // ]/td[
        // j
        // ]

        String first_part = "//table[@id=\"customers\"]/tbody/tr[";
        String second_part = "]/td[";
        String third_part = "]";

        WaitHelpers.waitImplicitWait(driver, 3);

        int row = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr")).size();
        int col = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr[2]/td")).size();

        for (int i = 2; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                String dynamic_path = first_part + i + second_part + j + third_part;
                // System.out.println(dynamic_path);

                String data = driver.findElement(By.xpath(dynamic_path)).getText();
                //  System.out.println(data);

                if (data.contains("Helen Bennett")) {
                    String country_Path = dynamic_path + "/following-sibling::td";
                    String country_text = driver.findElement(By.xpath(country_Path)).getText();

                    System.out.println("Helen Bennett is In - " + country_text);
                }
            }
        }
        closeBrowser(driver);
    }
}
