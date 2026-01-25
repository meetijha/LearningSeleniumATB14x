package com.thetestingacademy.challenges_Level_1;

import com.thetestingacademy.CommonToAll;
import com.thetestingacademy.ex07_WaitHelper.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Challenge4_Parallel_Test extends CommonToAll {

    WebDriver driver;


    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }



    @Test
    public void runTestInParallel() {

        openBrowser(driver,"https://app.vwo.com/");


        // Login
        driver.findElement(By.id("login-username")).sendKeys("meeti@test.com");

        driver.findElement(By.id("login-password")).sendKeys("Wingify@123");

        driver.findElement(By.id("js-login-btn")).click();

        WaitHelpers.waitJVM(5000);

        // Login failure message
        WebElement message = driver.findElement(By.xpath("//div[@id='js-notification-box-msg']"));
        Assert.assertEquals(message.getText(), "Your email, password, IP address or location did not match");
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}

