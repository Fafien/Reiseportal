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
        
        //Jonas
        System.setProperty("webdriver.chrome.driver",
                     "/Users/jonas/Downloads/chromedriver");
        //Beliz
        //System.setProperty("webdriver.chrome.driver",
        //           "/Users/belizbalim/Downloads/chromedriver");
        //Fabian
//        System.setProperty("webdriver.chrome.driver",
//                     "C:/DHBW/Software/chromedriver.exe"); 
        
        WebDriver driver  = new ChromeDriver();
        
        driver.get("http://localhost:8080/Reiseportal/login");
        //driver.get("http://localhost:8181/Reiseportal/login");
        
//        Thread.sleep(2000);
//        new Registration().test(driver);
//        Thread.sleep(2000);
//        new Login().test(driver, "Test", "test");
//        Thread.sleep(2000);
//        new UseraccountSettings().test(driver);
        //User-Settings ändern
        //logout
        
        new Login().test(driver, "Jo15", "testtest");
        new EditHotel().test(driver);
        
        new Search().test(driver);
        
        //buchen
        new Booking().test(driver);
        new Confirm().test(driver);
        
        new Logout().test(driver);
        
        driver.quit();
    }
}
