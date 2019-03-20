/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SeleniumTests;

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
public class UseraccountSettings {
 
    @Test
    public void test(WebDriver driver) throws InterruptedException {
        WebElement input1;
        WebElement input2;
        WebElement input3;
        WebElement button;
    
        driver.findElement(By.linkText("Kontoeinstellungen")).click();
        
        button = driver.findElement(By.id("edit"));
        
        button.click();
        
        input1 = driver.findElement(By.id("firstname"));
        input2 = driver.findElement(By.id("lastname"));
        input3 = driver.findElement(By.id("email"));
        
        input1.sendKeys("TestVorname1"+Keys.TAB);
        input2.sendKeys("TestNachname1"+Keys.TAB);
        input3.sendKeys("ihrreiseportal1@googlemail.com"+Keys.TAB);
        
        button = driver.findElement(By.id("save_usersettings"));
        
        button.click();
        
        button = driver.findElement(By.id("edit_password"));
        
        button.click();
        
        input1 = driver.findElement(By.id("passworda"));
        input2 = driver.findElement(By.id("password"));
        input3 = driver.findElement(By.id("passwordb"));
        
        input1.sendKeys("test"+Keys.TAB);
        input2.sendKeys("test1"+Keys.TAB);
        input3.sendKeys("test1"+Keys.TAB);
        
        button = driver.findElement(By.id("save_password"));
        
        button.click();
        
        button = driver.findElement(By.id("delete"));
        
        button.click();
        
        button = driver.findElement(By.id("delete_submit"));
        
        button.click();
    }
    
}
