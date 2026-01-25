package com.thetestingacademy.ex08_SVG_Elements;

import com.thetestingacademy.CommonToAll;
import com.thetestingacademy.ex07_WaitHelper.WaitHelpers;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Lab31_SVG_MAP extends CommonToAll {

    ChromeDriver driver;


    @BeforeTest
    public void openBrowser() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--guest");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @Description("Verify Tripura is present in the map and click to zoom it")
    @Test
    public void test_India_map_SVG() {

        String URL = "https://www.amcharts.com/svg-maps/?map=india";
        openBrowser(driver, URL);

        WaitHelpers.waitJVM(3000);

        //*[name()='svg']/*[name()='g'][7]/*[name()='g']/*[name()='g']/*[name()='path']
        List<WebElement> states = driver.findElements(By.xpath("//*[local-name()='path' and @role='menuitem']"));

        for (WebElement state : states) {
            String name = state.getDomAttribute("aria-label");

            if (name.contains("Tripura")) {
                state.click();
            }
        }
    }
}

