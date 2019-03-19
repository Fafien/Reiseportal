/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SeleniumTests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author belizbalim
 */
public class LoginAdminTest {
    
    @Test
    public void test(WebDriver driver) throws InterruptedException {
        
        //System.setProperty("webdriver.chrome.driver",
                    // "/Users/jonas/Downloads/chromedriver"); 
        
        //WebDriver driver  = new ChromeDriver();
        driver.get("http://localhost:8080/Reiseportal/login");
        
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement signin = driver.findElement(By.id("signin"));
        
        username.sendKeys("Jo15");
        password.sendKeys("testtest");
        signin.click();
        
    }
}
