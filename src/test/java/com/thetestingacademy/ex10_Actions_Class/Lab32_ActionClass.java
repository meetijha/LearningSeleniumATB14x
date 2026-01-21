package com.thetestingacademy.ex10_Actions_Class;

import com.thetestingacademy.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Lab32_ActionClass {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        String URL = "https://awesomeqa.com/practice.html";
        driver.get(URL);
        driver.manage().window().maximize();

        // Keys - Action classes
        WebElement firstName = driver.findElement(By.name("firstname"));

        Actions action= new Actions(driver);
        action.keyDown(Keys.SHIFT).sendKeys(firstName,"The testing academy")
                .keyUp(Keys.SHIFT).build().perform();

        driver.close();
    }

}
