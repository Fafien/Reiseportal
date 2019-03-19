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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Fabian Hupe
 */
public class UseraccountTest {
    public void SearchTest() {
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
        WebElement input1;
        WebElement input2;
        WebElement input3;
        WebElement input4;
        WebElement input5;
        WebElement input6;
        WebElement input7;
        WebElement button;
        
        System.setProperty("webdriver.chrome.driver",
                     "C:/DHBW/Software/chromedriver.exe"); 
        WebDriver driver  = new ChromeDriver();
        driver.get("http://localhost:8080/Reiseportal/");

        driver.findElement(By.linkText("Registrieren")).click();
        
        button = driver.findElement(By.id("registration_submit"));
        input1 = driver.findElement(By.id("firstname"));
        input2 = driver.findElement(By.id("lastname"));
        input3 = driver.findElement(By.id("email"));
        input4 = driver.findElement(By.id("emailb"));
        input5 = driver.findElement(By.id("username"));
        input6 = driver.findElement(By.id("password"));
        input7 = driver.findElement(By.id("passwordb"));
        
        input1.sendKeys("Test"+Keys.TAB);
        input2.sendKeys("Test"+Keys.TAB);
        input3.sendKeys("ihrreiseportal@googlemail.com"+Keys.TAB);
        input4.sendKeys("ihrreiseportal@googlemail.com"+Keys.TAB);
        input5.sendKeys("Test"+Keys.TAB);
        input6.sendKeys("test"+Keys.TAB);
        input7.sendKeys("test"+Keys.TAB);
        
        button.click();
        
        driver.findElement(By.linkText("Anmelden")).click();
        
        button = driver.findElement(By.id("login_submit"));
        input1 = driver.findElement(By.id("username"));
        input2 = driver.findElement(By.id("password"));
        
        input1.sendKeys("Test");
        input2.sendKeys("test");
        
        button.click();
        
        driver.findElement(By.linkText("Kontoeinstellungen")).click();
        
        button = driver.findElement(By.id("delete"));
        
        button.click();
        
        button = driver.findElement(By.id("delete_submit"));
        
        button.click();
        
        driver.quit();
    }
}
