package com.thetestingacademy.challenges_Level_1;

import com.thetestingacademy.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.thetestingacademy.ex07_WaitHelper.WaitHelpers.waitJVM;

public class Challenge2_WebTable_Editor extends CommonToAll {

    @Test
    public void editTable() {
        WebDriver driver = new ChromeDriver();
        openBrowser(driver, "https://demoqa.com/webtables");

        int elementIndex = 3;
        //Getting 3rd button
        WebElement editBtns = driver.findElement(By.xpath("(//div[@class='action-buttons'])[" + elementIndex + "]/span"));

        editBtns.click();
        waitJVM(3000);

        //Edit Modal Element
        WebElement firstName = driver.findElement(By.xpath("//input[@id='firstName']"));
        WebElement submitBtn = driver.findElement(By.xpath("//button[@id='submit']"));

        firstName.clear();
        firstName.sendKeys("Pramod");
        submitBtn.click();

        //Verify the details
        WebElement name = driver.findElement(By.xpath("(//div[@role='row'])[" + (elementIndex + 1) + "]/div"));
        Assert.assertEquals("Pramod", name.getText());
    }
}


/*WebElement lastname= driver.findElement(By.xpath("//input[@id='lastName-wrapper']"));
        WebElement email=driver.findElement(By.xpath("//input[@id='userEmail']"));
        WebElement age= driver.findElement(By.xpath("//input[@id='age']"));
        WebElement salary=driver.findElement(By.xpath("//input[@id='salary']"));
        WebElement department= driver.findElement(By.xpath("//input[@id='department']"));

         lastname.sendKeys("D");
        email.sendKeys("abc@gmail.com");
        age.sendKeys("25");
        salary.sendKeys("90000");
        department.sendKeys("IT");
 */