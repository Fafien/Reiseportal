/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SeleniumTests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author jonas
 */
public class SearchTest {
    
    public SearchTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void hello() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                     "/Users/jonas/Downloads/chromedriver"); 
        
        WebDriver driver  = new ChromeDriver();
        driver.get("http://localhost:8080/Reiseportal/");
        
        WebElement button = driver.findElement(By.id("search"));
        WebElement input1 = driver.findElement(By.id("location"));
        WebElement input2 = driver.findElement(By.id("datum1"));
        WebElement input3 = driver.findElement(By.id("datum2"));
        WebElement input4 = driver.findElement(By.id("persons"));
        
        input1.sendKeys("Berlin");
        input2.sendKeys("22.06.2019");
        input3.sendKeys("06.07.2019");
        input4.sendKeys("2");
        button.click();
        
        driver.quit();
    }
}

