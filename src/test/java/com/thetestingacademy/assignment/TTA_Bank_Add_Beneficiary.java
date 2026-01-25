package com.thetestingacademy.assignment;

import com.thetestingacademy.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TTA_Bank_Add_Beneficiary extends CommonToAll {


    @Test
    public void check_Add_beneficiary() throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        String beneficiary_name = "Meeti Jha";
        String beneficairy_bank = "Citi Bank";
        String beneficiary_acc = "123456789000";

        //Step 1 : open browser
        openBrowser(driver, "https://tta-bank-digital-973242068062.us-west1.run.app/");

        //Step 2: Sign up a new user
        WebElement signUp = driver.findElement(By.xpath("//button[normalize-space()='Sign Up']"));
        signUp.click();

        WebElement name = driver.findElement(By.xpath(" //input[@type='text']"));
        name.sendKeys("John Doe");

        WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
        email.sendKeys("johndoe@gmail.com");

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("wrongpass123");

        WebElement create_Acc_btn = driver.findElement(By.xpath("//button[@type='submit']"));
        create_Acc_btn.click();

        customWait(5000);
/*    //Step 2 : Login(already a user is created using Sign up)
        //email: Johndoe@gmail.com
        //password: wrongpass@123
        WebElement email=driver.findElement(By.xpath("//input[@placeholder='you@example.com']"));
        email.sendKeys("johndoe@gmail.com");

        WebElement password= driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("wrongpass@123");

        WebElement submit_btn= driver.findElement(By.xpath("//button[@type='submit']"));
        submit_btn.click();*/

        //Step 3:   Click on Transfer Funds
        WebElement transfer_funds_link = driver.findElement(By.xpath("//button[normalize-space()='Transfer Funds']"));
        transfer_funds_link.click();
        customWait(3000);

        // Step 4: Click on + to add beneficiary
        WebElement add_beneficiary_btn = driver.findElement(By.xpath("//button[@title='Add New Beneficiary']"));
        add_beneficiary_btn.click();
        customWait(3000);

        // Step 5: Add Beneficiary Details
        WebElement beneficiary_Name = driver.findElement(By.xpath("//input[@placeholder='e.g. John Doe']"));
        beneficiary_Name.sendKeys(beneficiary_name);

        WebElement beneficiary_Bank = driver.findElement(By.xpath("//input[@placeholder=\"e.g. Citibank\"]"));
        beneficiary_Bank.sendKeys(beneficairy_bank);

        WebElement beneficiary_Acc_Num = driver.findElement(By.xpath("//input[@placeholder=\"8-12 digits\"]"));
        beneficiary_Acc_Num.sendKeys(beneficiary_acc);

        WebElement save_Beneficiary = driver.findElement(By.xpath("//button[text()=\"Save Beneficiary\"]"));
        save_Beneficiary.click();

        //Step 6: Go to Manage Beneficiary and verify if beneficiary got added
        WebElement manage_beneficiary_btn = driver.findElement(By.xpath("//button[text()=\"Manage Beneficiaries\"]"));
        manage_beneficiary_btn.click();
        customWait(3000);

        WebElement added_beneficiary_name = driver.findElement(By.xpath("//p[text()=\"" + beneficiary_name + "\"]"));
        // System.out.println(added_beneficiary_name.getText());
        Assert.assertEquals(added_beneficiary_name.getText(), beneficiary_name);

        //step 7: Close browser
        closeBrowser(driver);

    }
}
