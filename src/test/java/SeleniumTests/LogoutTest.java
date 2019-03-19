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
public class LogoutTest {
   
    @Test
    public static void test() throws InterruptedException {
        WebElement button;
        
        System.setProperty("webdriver.chrome.driver",
                     "C:/DHBW/Software/chromedriver.exe"); 
        WebDriver driver  = new ChromeDriver();
        
        driver.findElement(By.linkText("Ausloggen")).click();
    }
}
