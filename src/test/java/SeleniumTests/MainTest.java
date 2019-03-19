/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SeleniumTests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author jonas
 */
public class MainTest {
    
    @Test
    public void main() throws InterruptedException {
    
        System.setProperty("webdriver.chrome.driver",
                     "/Users/jonas/Downloads/chromedriver");
        WebDriver driver  = new ChromeDriver();
        
        //registrieren
        //anmelden
        //User-Settings ändern
        //logout
        
        new LoginAdmin().test(driver);
        new EditHotel().test(driver);
        
        new SearchTest().test(driver);
        
        //buchen
        //bewerten
        
        driver.quit();
    }
    
}
