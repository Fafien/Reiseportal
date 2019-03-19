/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SeleniumTests;

import java.util.List;
import javax.ejb.EJB;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import reiseportal.ejb.UserBean;
import reiseportal.jpa.Useraccount;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reiseportal.web.RegistrationServlet;

/**
 *
 * @author Fabian Hupe
 */
public class RegistrationTest {
    
    @EJB
    UserBean userbean;
    
    @Test
    public void test() throws InterruptedException {
        WebElement input1;
        WebElement input2;
        WebElement input3;
        WebElement input4;
        WebElement input5;
        WebElement input6;
        WebElement input7;
        WebElement button;
        Useraccount usr;
        
        System.setProperty("webdriver.chrome.driver",
                     "C:/DHBW/Software/chromedriver.exe"); 
        WebDriver driver  = new ChromeDriver();

        driver.findElement(By.linkText("Registrieren")).click();
        
        button = driver.findElement(By.id("registration_submit"));
        input1 = driver.findElement(By.id("firstname"));
        input2 = driver.findElement(By.id("lastname"));
        input3 = driver.findElement(By.id("email"));
        input4 = driver.findElement(By.id("emailb"));
        input5 = driver.findElement(By.id("username"));
        input6 = driver.findElement(By.id("password"));
        input7 = driver.findElement(By.id("passwordb"));
        
        input1.sendKeys("TestVorname"+Keys.TAB);
        input2.sendKeys("TestNachname"+Keys.TAB);
        input3.sendKeys("ihrreiseportal@googlemail.com"+Keys.TAB);
        input4.sendKeys("ihrreiseportal@googlemail.com"+Keys.TAB);
        input5.sendKeys("Test"+Keys.TAB);
        input6.sendKeys("test"+Keys.TAB);
        input7.sendKeys("test"+Keys.TAB);
        
        button.click();
        
        driver.get("https://accounts.google.com/ServiceLogin?hl=de&service=mail");
        input1 = driver.findElement(By.id("identifierId"));
        input1.sendKeys("ihrreiseportal@googlemail.com"+Keys.ENTER);
        
        Thread.sleep(5000);
        input2 = driver.findElement(By.name("password"));
        input2.sendKeys("AbC1234!"+Keys.ENTER);
        
        Thread.sleep(8000);
        
        List<WebElement> emailThreads = driver.findElements(By.xpath("//span[@class='bog']"));
        
        for (int i = 0; i < emailThreads.size(); i++) {
            if (emailThreads.get(i).getText().contains("Registrierung Reiseportal")) {
                emailThreads.get(i).click();
            }
        }
        
        driver.findElement(By.linkText("Link")).click();
        
    }
}
