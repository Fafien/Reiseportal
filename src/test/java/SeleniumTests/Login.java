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
 * @author Fabian Hupe
 */
public class Login {
    
    @Test
    public void test(WebDriver driver) throws InterruptedException {
        WebElement input1;
        WebElement input2;
        WebElement button;

        driver.findElement(By.linkText("Anmelden")).click();
        
        button = driver.findElement(By.id("login_submit"));
        input1 = driver.findElement(By.id("username"));
        input2 = driver.findElement(By.id("password"));
        
        input1.sendKeys("Test");
        input2.sendKeys("test");
        
        button.click();
        
        Thread.sleep(2000);
        if(!driver.findElement(By.className("error")).getText().equals("")){
            driver.quit();
        }
        
    }
}
