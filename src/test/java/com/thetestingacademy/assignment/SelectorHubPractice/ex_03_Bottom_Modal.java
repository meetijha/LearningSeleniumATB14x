package com.thetestingacademy.assignment.SelectorHubPractice;

import com.thetestingacademy.CommonToAll;
import com.thetestingacademy.ex07_WaitHelper.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ex_03_Bottom_Modal extends CommonToAll {

    WebDriver driver;
    Actions action;

    @BeforeTest
    public void setUp(){

        driver=new ChromeDriver();
        action=new Actions(driver);
        openBrowser(driver, "https://selectorshub.com/xpath-practice-page/");

    }

    @Test
    public void bottomModalPractice(){

        //Click button to open modal
        WebElement openModalBtn=driver.findElement(By.xpath("//button[@id='myBtn']"));
        action.moveToElement(openModalBtn).build().perform();
        openModalBtn.click();

        //check if modal is visible
        WaitHelpers.checkVisibility(driver, By.xpath("//div[@class='modal-content']"));

        //Check modal header content
        WebElement modalText=driver.findElement(By.xpath("//div[@class='modal-content']//a"));
        //System.out.println(modalText.getText());
        Assert.assertEquals(modalText.getText(),"Testing Daily - Free App To Get The Latest Testing Feed.");

        //close modal
        WebElement closeBtn= driver.findElement(By.xpath("//div[@class='modal-header']/span"));
        closeBtn.click();
    }

    @AfterTest
    public void close() {
        closeBrowser(driver);
    }
}
