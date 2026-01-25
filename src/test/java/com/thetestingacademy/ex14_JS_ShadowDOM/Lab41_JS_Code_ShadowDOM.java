package com.thetestingacademy.ex14_JS_ShadowDOM;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.thetestingacademy.ex07_WaitHelper.WaitHelpers.waitJVM;

public class Lab41_JS_Code_ShadowDOM {

    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();
        driver.get("https://selectorshub.com/iframe-in-shadow-dom/");
        driver.manage().window().maximize();

        waitJVM(3000);

        //driver.findElement(By.id("pizza")).sendKeys("farmhouse");
        // The term pizza is actually within the shadow DOM.

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement pizza = (WebElement) js.executeScript("return document.querySelector('div#userName').shadowRoot.querySelector('div#app2').shadowRoot.querySelector('input#pizza')");
        pizza.sendKeys("farmhouse");

        //        driver.switchTo().frame("pact3");
//
//        WebElement input_glaf = driver.findElement(By.id("glaf"));
//        input_glaf.sendKeys("Hi");
    }
}