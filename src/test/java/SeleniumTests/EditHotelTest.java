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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author belizbalim
 */
public class EditHotelTest {
    public EditHotelTest() {
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
        //driver().close();
    }

    @Test
    public void test() throws InterruptedException {
        
        /* 
        //System.setProperty("webdriver.chrome.driver",
                     //"/Users/jonas/Downloads/chromedriver"); 
        
        WebDriver driver  = new ChromeDriver();
        driver.get("http://localhost:8181/Reiseportal/");
        
        WebElement bearbeiten = driver.findElement(By.id("bearbeiten"));
        WebElement input1 = driver.findElement(By.id("preisProNacht"));
        WebElement input2 = driver.findElement(By.id("anzahlZimmer"));
        WebElement speichern = driver.findElement(By.id("speichern"));
        
        bearbeiten.click();
        input1.sendKeys("15");
        input2.sendKeys("20");
        speichern.click();
        
        
        if (input1.getAttribute("value")equals("15") && input2.getAttribute("value")equals("20")){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
        
       
        driver.quit();*/
    }
}
