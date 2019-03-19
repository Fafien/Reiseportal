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
public class Main {
    
    @Test
    public void main() throws InterruptedException {
        //Jonas
        //System.setProperty("webdriver.chrome.driver",
                     //"/Users/jonas/Downloads/chromedriver");
        //Beliz
        System.setProperty("webdriver.chrome.driver",
                     "/Users/belizbalim/Downloads");
        
        WebDriver driver  = new ChromeDriver();
        
        //registrieren
        //anmelden
        //User-Settings ändern
        //logout
        
        new LoginAdmin().test(driver);
        new EditHotel().test(driver);
        
        new Search().test(driver);
        
        //buchen
        //bewerten
        
        driver.quit();
    }
    
}
