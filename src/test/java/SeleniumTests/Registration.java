/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SeleniumTests;

import java.util.List;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Fabian Hupe
 */
public class Registration {
    
    @Test
    public void test(WebDriver driver) throws InterruptedException {
        WebElement input1;
        WebElement input2;
        WebElement input3;
        WebElement input4;
        WebElement input5;
        WebElement input6;
        WebElement input7;
        WebElement button;

        driver.findElement(By.linkText("Registrieren")).click();
        
        button = driver.findElement(By.id("registration_submit"));
        input1 = driver.findElement(By.id("firstname"));
        input2 = driver.findElement(By.id("lastname"));
        input3 = driver.findElement(By.id("email"));
        input4 = driver.findElement(By.id("emailb"));
        input5 = driver.findElement(By.id("username"));
        input6 = driver.findElement(By.id("password"));
        input7 = driver.findElement(By.id("passwordb"));
        
        input1.clear();
        input1.sendKeys("TestVorname"+Keys.TAB);
        input2.sendKeys("TestNachname"+Keys.TAB);
        input3.sendKeys("ihrreiseportal@googlemail.com"+Keys.TAB);
        input4.sendKeys("ihrreiseportal@googlemail.com"+Keys.TAB);
        input5.sendKeys("Test"+Keys.TAB);
        input6.sendKeys("test"+Keys.TAB);
        input7.sendKeys("test"+Keys.TAB);
        
        button.click();
        
        Thread.sleep(2000);
        
        if(!driver.findElement(By.className("error")).getText().equals("")){
            driver.quit();
        }
        
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
        
        driver.close();
        
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
    }
}
