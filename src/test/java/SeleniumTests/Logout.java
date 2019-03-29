/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SeleniumTests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Fabian Hupe
 */
public class Logout {
   
    @Test
    public void test(WebDriver driver) throws InterruptedException {
        
        Thread.sleep(1000);
        driver.findElement(By.linkText("Logout")).click();
    }
}
