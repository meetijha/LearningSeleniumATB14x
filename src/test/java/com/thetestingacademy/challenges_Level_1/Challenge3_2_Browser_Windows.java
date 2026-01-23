package com.thetestingacademy.challenges_Level_1;

import com.thetestingacademy.CommonToAll;
import com.thetestingacademy.ex07_WaitHelper.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

import static com.thetestingacademy.ex07_WaitHelper.WaitHelpers.waitJVM;

public class Challenge3_2_Browser_Windows extends CommonToAll {

    @Test
    public void handleBrowserWindows() {
        WebDriver driver = new ChromeDriver();
        openBrowser(driver, "https://demoqa.com/browser-windows");

        waitJVM(5000);
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0, 500);");

        WebElement newTabBtn=driver.findElement(By.xpath("//button[@id='tabButton']"));
        WebElement newWindowBtn=driver.findElement(By.xpath("//button[@id='windowButton']"));
        WebElement newWindowMessageBtn=driver.findElement(By.xpath("//button[@id='messageWindowButton']"));

        String parentWindow=driver.getWindowHandle();
        // Checking New Tab
        newTabBtn.click();
        Set<String> windows= driver.getWindowHandles();
        for (String window : windows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                String source= driver.getPageSource();
                Assert.assertTrue(source.contains("This is a sample page"));
                driver.close();
            }
        }

        //Checking new Window
        driver.switchTo().window(parentWindow);
        newWindowBtn.click();
        windows= driver.getWindowHandles();
        for (String window : windows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                String source= driver.getPageSource();
                Assert.assertTrue(source.contains("This is a sample page"));
                driver.close();
            }
        }

        WaitHelpers.waitJVM(3000);
        //Checking New Window Message
        driver.switchTo().window(parentWindow);
        newWindowMessageBtn.click();
        windows= driver.getWindowHandles();
        // CANNOT AUTOMATE
        /*for (String window : windows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                if (driver.getCurrentUrl().equals("about:blank")) {
                driver.close();}
            }
        }*/
        driver.quit();
    }
}
