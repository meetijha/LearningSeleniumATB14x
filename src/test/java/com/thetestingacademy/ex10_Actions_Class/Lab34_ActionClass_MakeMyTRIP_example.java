package com.thetestingacademy.ex10_Actions_Class;

import com.thetestingacademy.CommonToAll;
import com.thetestingacademy.ex07_WaitHelper.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Lab34_ActionClass_MakeMyTRIP_example extends CommonToAll {

    @Test
    public void test_actions_p4() {
        WebDriver driver = new ChromeDriver();
        openBrowser(driver, "https://www.makemytrip.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-cy=\"closeModal\"]")));

        // This will close the modal
        WebElement signup_model = driver.findElement(By.xpath("//span[@data-cy='closeModal']"));
        signup_model.click();


        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='minimize']")));

        // This will close the modal
        WebElement ai_model = driver.findElement(By.xpath("//img[@alt='minimize']"));
        ai_model.click();

        WebElement background_element = driver.findElement(By.tagName("body"));
        background_element.click(); // just to remove the transparent layer.

        WaitHelpers.waitJVM(3000);

        WebElement fromCity = driver.findElement(By.xpath("//input[@data-cy='fromCity']"));
//        WebElement fromCity = driver.findElement(By.xpath("//input[@placeholder=\"From\"]"));
//        WebElement toCity = driver.findElement(By.xpath("//input[@data-cy='toCity']"));


        Actions actions = new Actions(driver);

        actions.moveToElement(fromCity).click().build().perform();

        new WaitHelpers().waitJVM(2000);

        actions.moveToElement(fromCity).click().sendKeys("IXC").build().perform();
        new WaitHelpers().waitJVM(1000);

        try {
            List<WebElement> list_auto_complete = driver.findElements(By.xpath("//ul[@class=\"react-autosuggest__suggestions-list\"]/li"));

            for (WebElement e : list_auto_complete) {
                if (e.getText().contains("Chandigarh")) {
                    e.click();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        WebElement toCity = driver.findElement(By.xpath("//input[@id='toCity']"));
        actions.moveToElement(toCity).click().build().perform();
        toCity.sendKeys("DEL");

        try {
            List<WebElement> list_auto_complete = driver.findElements(By.xpath("//ul[@class=\"react-autosuggest__suggestions-list\"]/li"));

            for (WebElement e : list_auto_complete) {
                if (e.getText().contains("Del")) {
                    e.click();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        closeBrowser(driver);

    }

}
