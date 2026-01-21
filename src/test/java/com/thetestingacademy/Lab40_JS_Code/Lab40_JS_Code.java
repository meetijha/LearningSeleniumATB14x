package com.thetestingacademy.Lab40_JS_Code;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lab40_JS_Code {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://thetestingacademy.com");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // js.executeScript("alert(1)");

        js.executeScript("window.location='https://www.google.com'");

        driver.get("https://selectorshub.com/xpath-practice-page/");

        js.executeScript("window.scrollBy(0, 500);");
        js.executeScript("window.scrollBy(0, 500);");

        String url= js.executeScript("return document.URL").toString();
        String title= js.executeScript("return document.title").toString();

        System.out.println(url);
        System.out.println(title);

        driver.close();
    }
}
