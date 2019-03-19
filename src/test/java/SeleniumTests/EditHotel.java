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

/**
 *
 * @author belizbalim
 */
public class EditHotel {
    public EditHotel() {
    }
    
    @BeforeClass
    public static void setUpClass() throws InterruptedException {
       
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
    public void test(WebDriver driver) throws InterruptedException {
        
        driver.get("http://localhost:8080/Reiseportal/hoteladministration");
        
        WebElement shotelname = driver.findElement(By.id("shotelname"));
        WebElement adminhotelsuche = driver.findElement(By.id("adminhotelsuche"));
        
        shotelname.sendKeys("Smart Stay Hotel Berlin");
        adminhotelsuche.click();
        
        WebElement bearbeiten = driver.findElement(By.id("bearbeiten"));
        bearbeiten.click();
        
        WebElement input1 = driver.findElement(By.id("preisProNacht"));
        WebElement input2 = driver.findElement(By.id("anzahlZimmer"));
        WebElement speichern = driver.findElement(By.id("speichern"));
      
        input1.clear();
        input1.sendKeys("15");
        input2.clear();
        input2.sendKeys("20");
        speichern.click();
        
//        if (input1.getAttribute("value").equals("15") && input2.getAttribute("value").equals("20")){
//            System.out.println("Test Passed!");
//        } else {
//            System.out.println("Test Failed");
//        }
    }
}
