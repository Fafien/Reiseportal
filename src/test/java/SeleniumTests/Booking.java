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
 * @Marwa Alqataa
 */
public class Booking {
    
    @Test
    public static void test(WebDriver driver) throws InterruptedException {

        driver.findElement(By.id("book")).click();
        
    }
}