package com.thetestingacademy.challenges_Level_1;

import com.thetestingacademy.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static com.thetestingacademy.ex07_WaitHelper.WaitHelpers.waitJVM;

public class Challenge3_1_Modals extends CommonToAll {
    @Test
    public void editTable() {
        WebDriver driver = new ChromeDriver();
        openBrowser(driver, "https://demoqa.com/modal-dialogs");

        waitJVM(5000);
        Actions actions = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");

        WebElement smallModal = driver.findElement(By.xpath("//button[@id='showSmallModal']"));
        actions.moveToElement(smallModal).build().perform();
        smallModal.click();
        waitJVM(5000);
        WebElement closeSmallModalBtn = driver.findElement(By.xpath("//div[@id='example-modal-sizes-title-sm']/parent::div//span[1]"));
        closeSmallModalBtn.click();

        WebElement largeModal = driver.findElement(By.xpath("//button[@id='showLargeModal']"));
        actions.moveToElement(largeModal).build().perform();
        largeModal.click();
        waitJVM(5000);
        WebElement closeLargeModalBtn = driver.findElement(By.xpath("//div[@id='example-modal-sizes-title-lg']/parent::div//span[1]"));
        closeLargeModalBtn.click();

        closeBrowser(driver);
    }
}
