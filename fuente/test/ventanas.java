package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ventanas {
    static WebDriver driver = new ChromeDriver();
    
    public static void modos() throws InterruptedException{
        
        var pasajeros = 5;
        var i = 1;
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        /*//driver.navigate().to("https://www.coinglass.com/es");
        //driver.findElement(By.xpath("//input[contains(@id,'originStation1')]")).click();
        //driver.findElement(By.xpath("//a[@value='AIP']")).click();
      
        //driver.findElement(By.xpath("(//a[@value='BHO'])[2]")).click();
        //driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BHO']")).click();
        driver.findElement(By.id("autosuggest")).sendKeys("Ind");
        Thread.sleep(2000);
        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        for(WebElement option: options) {
            if(option.getText().equalsIgnoreCase("India")) {
                option.click();
                break;
            }
                    
        }*/
        
        driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
        System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
        System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
        //driver.findElement(By.cssSelector("input[type='checkbox']")).getSize();
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        while(i<pasajeros) {
            driver.findElement(By.id("hrefIncAdt")).click();
                  i++;
        }
        
        System.out.println( driver.findElement(By.id("spanAudlt")).getText());
        Thread.sleep(1000);
        try {
        Assert.assertEquals(driver.findElement(By.id("spanAudlt")).getText(),"5");
        }catch(Exception e) {
            System.out.println("Los pasajeros no coinciden "+ e);
        }
        
        var cantidad = Integer.parseInt(driver.findElement(By.id("spanAudlt")).getText());
        if(cantidad == 5) {
            //cantidad =Integer.parseInt(driver.findElement(By.id("spanAudlt")).getText());
        System.out.println( "Los pasajeros son: " +driver.findElement(By.id("spanAudlt")).getText());
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        driver.findElement(By.id("btnclosepaxoption"));
    }
}
