package com.thetestingacademy.ex03_Selenium_Locators;

import com.thetestingacademy.CommonToAll;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

public class TestSelenium17_Project_Locators_Selenium_ID_CLASSNAME_NAME extends CommonToAll {

    @Description("TC#1 - Verify that with invalid login, error message is displayed!")
    @Owner("Pramod Dutta")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void test_vwo_login_invalid_login() {
        // Step 1 - Find the EMAIL ID and enter the admin@admin.com.
        // Step 2 - Find the Password and enter the 1234.
        // Step 3 - Find the Submit and click on the button.
        // Step 4 - Wait some time.
        // Step 5 - Verify the message error message.

        WebDriver driver = new ChromeDriver();
        openBrowser(driver, "https://app.vwo.com");

        // Step 1 - Find the EMAIL ID and enter the admin@admin.com.
//        <input type="email"
//        class="text-input W(100%)"
//        name="username"
//        vwo-html-translate-attr="placeholder"
//        vwo-html-translate-placeholder="login:enterEmailID"
//        id="login-username"
//        data-qa="hocewoqisi"
//        placeholder="Enter email ID">

        WebElement email_input_box =driver.findElement(By.id("login-username"));
        email_input_box.sendKeys("admin@admin.com");

        // 2. Find the password inputbox and enter the password
       // <input type="password"
        // class="text-input W(100%)"
        // vwo-html-translate-attr="placeholder"
        // vwo-html-translate-placeholder="login:enterPassword"
        // name="password"
        // id="login-password"
        // data-qa="jobodapuxe"
        // placeholder="Enter password">

        WebElement password_input_box=driver.findElement(By.id("login-password"));
        password_input_box.sendKeys("wrongpassword@123");

        // Step 3 - Find the Submit and click on the button.
        //<button type="submit"
        // id="js-login-btn"
        // class="btn btn--primary btn--inverted W(100%) Mb(8px) Mb(0):lc"
        // onclick="login.login(event)"
        // data-qa="sibequkica">

        WebElement button_submit =driver.findElement(By.id("js-login-btn"));
        button_submit.click();

        //Wait some time
        customWait(5000);

        // Step 5 - Verify the message error message.
        // <div
        // class="notification-box-description"
        // data-qa="rixawilomi">
        // Your email, password, IP address or location did not match</div>

        WebElement error_message=driver.findElement(By.className("notification-box-description"));
        System.out.println(error_message.getText());

        Assert.assertEquals(error_message.getText(),"Your email, password, IP address or location did not match");

        closeBrowser(driver);
    }
}
