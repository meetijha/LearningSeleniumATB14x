package com.thetestingacademy.ex05_Selenium_Waits;

import io.qameta.allure.Description;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestSelenium22_Waits {
    @Description("Verify Ebay Print the prices (iMac)")
    @Test
    public void test_verify_print_imac_price() {

        EdgeDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://app.vwo.com");
    }
}
