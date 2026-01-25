package com.thetestingacademy.assignment.SelectorHubPractice;

import com.thetestingacademy.CommonToAll;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.thetestingacademy.ex07_WaitHelper.WaitHelpers.waitJVM;

public class ex_02_Shadow_DOM extends CommonToAll {

    WebDriver driver;
    Actions action;

    @BeforeTest
    public void setUp() {

        driver = new ChromeDriver();
        action = new Actions(driver);
        openBrowser(driver, "https://selectorshub.com/xpath-practice-page/");

    }

    @Test
    public void ShadowDomPractice() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement learningHubLink = (WebElement) js.executeScript("return document.querySelector('div#userName').shadowRoot.querySelector('a')");
        String parentWindow = driver.getWindowHandle();

        // Click Learning Hub
        action.moveToElement(learningHubLink).click().build().perform();
        waitJVM(3000);

        //Switch Back to practice page
        driver.switchTo().window(parentWindow);
        waitJVM(5000);

        //Fill username
        WebElement username = (WebElement) js.executeScript("return document.querySelector('div#userName').shadowRoot.querySelector('input#kils')");
        username.sendKeys("Meeti");

        //Fill pizza name
        WebElement pizzaname = (WebElement) js.executeScript("return document.querySelector('div#userName').shadowRoot.querySelector('div#app2').shadowRoot.querySelector('input#pizza')");
        pizzaname.sendKeys("farmhouse");

        //Navigate to password and enter value
        action.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("DummyPassword").build().perform();
    }

    @AfterTest
    public void close() {
        closeBrowser(driver);
    }
}
