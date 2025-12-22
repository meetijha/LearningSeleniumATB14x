package com.thetestingacademy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonToAll{

    public void openBrowser(WebDriver driver,String url)
    {
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void closeBrowser(WebDriver driver) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

    public void customWait(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
