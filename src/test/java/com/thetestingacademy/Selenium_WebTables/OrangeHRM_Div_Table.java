package com.thetestingacademy.Selenium_WebTables;

import com.thetestingacademy.CommonToAll;
import com.thetestingacademy.ex07_WaitHelper.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.List;

public class OrangeHRM_Div_Table extends CommonToAll {

    @Test
    public void print_Table_Data() throws Exception{
        WebDriver driver= new ChromeDriver();
        openBrowser(driver,"https://awesomeqa.com/hr/web/index.php/auth/login");

        //Login
        WaitHelpers.waitImplicitWait(driver,3);
        WebElement input_username = driver.findElement(By.xpath("//input[@name=\"username\"]"));
        WebElement input_password = driver.findElement(By.xpath("//input[@placeholder=\"Password\"]"));
        WebElement button = driver.findElement(By.xpath("//button"));

        input_username.sendKeys("admin");
        input_password.sendKeys("Hacker@4321");
        button.click();

        //Click PIM

        WaitHelpers.waitImplicitWait(driver,5);
        WebElement PIM = driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='PIM']"));
        PIM.click();
        Thread.sleep(7000);

      //Get Employee List
        //String row="//div[contains(@class,\"oxd-table-card\")]//div[@role='row']";
      List<WebElement> empList=driver.findElements(By.xpath("//div[contains(@class,\"oxd-table-card\")]//div[@role='row']"));
        System.out.println(empList.size());

//div[@role='rowgroup']//div[1]//div[1]//div[2]
/*  for(WebElement emp: empList)
    {
        String id = emp.findElement(
                By.xpath(".//div[contains(@class,'card-header-slot')]//div[contains(@class,'data')][1]")
        ).getText();
        System.out.println(id);
    }*/

//        int i=1;
//        for (WebElement emp : empList) {
//
//            String firstName = emp.findElement(
//                    By.xpath("//div[@role='rowgroup']//div["+i+"]//div[1]//div[3]//div[1]")
//            ).getText();
//
//            System.out.println(firstName );
//            i++;
//        }

//        for(WebElement e:empList)
//        {
//            String id=e.findElement(By.xpath(".//div[text()='Id']/following-sibling::div")).getText();
//            System.out.println("Id ="+id);
//            String firstName=e.findElement(By.xpath(".//div[contains(normalize-space(),'First')]/following-sibling::div")).getText();
//            String lastName=e.findElement(By.xpath(".//div[contains(normalize-space(),'Last')]/following-sibling::div")).getText();
//            System.out.print(firstName+" "+lastName);
//
//        }

        /*for(int j=1;j< empList.size();j++)
        {
            String idxpath="("+row+")["+j+"]"+"//div[text()='Id']/following-sibling::div";
            System.out.println(idxpath);
            String id=driver.findElement(By.xpath(idxpath)).getText();
            System.out.println("Id ="+id);
//            String firstName=driver.findElement(By.xpath("(//div[contains(normalize-space(),'First')])["+j+"]/div")).getText();
//            String lastName=driver.findElement(By.xpath("(//div[contains(normalize-space(),'Last')])["+j+"]/div")).getText();
//            System.out.print(firstName+" "+lastName);
        }*/

        Thread.sleep(3000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
//        WaitHelpers.checkVisibility(driver,By.xpath("(//div[contains(@class,'card-body-slot')])[1]"));
//        int i=1;
//        for(WebElement emp:empList){
//            String xpath="(//div[contains(@class,'card-body-slot')])["+i+"]//div[@class='header' and contains(text(),'First')]/parent::div/div[@class='data']";
//            System.out.println(xpath);
//
//            String firstname=driver.findElement(By.xpath(xpath)).getText();
//            System.out.println(firstname);
//        }

        List<WebElement> rows = driver.findElements(
                By.xpath("//div[contains(@class,'oxd-table-row')]")
        );

        for (WebElement row : rows) {

            String firstName = row.findElement(
                    By.xpath(".//div[@class='header' and contains(text(),'First')]/parent::div/div[@class='data']")
            ).getText();

            String lastName = row.findElement(
                    By.xpath("./div[@class='header' and contains(text(),'Last')]/parent::div/div[@class='data']")
            ).getText();

            System.out.println("First Name: " + firstName + ", Last Name: " + lastName);
        }
        closeBrowser(driver);
    }
}
