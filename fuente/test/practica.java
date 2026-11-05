package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class practica {
    public static WebDriver driver = new ChromeDriver();
    
    static void entrenamiento() {
        
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        var a = driver.findElement(By.id("checkBoxOption1"));
        var b = driver.findElement(By.id("checkBoxOption2"));
        var c = driver.findElement(By.id("checkBoxOption3"));
        
        a.click();
        System.out.println(a.isSelected());
        a.click();
        System.out.println(a.isSelected());
        
        System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
        
    }
    
    static void entrenamiento2() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.findElement(By.cssSelector("input[name='name']")).sendKeys("Sergio");
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("ser@alfam.com");
        driver.findElement(By.id("exampleCheck1")).click();
        driver.findElement(By.id("exampleFormControlSelect1"));
        WebElement select = driver.findElement(By.id("exampleFormControlSelect1"));
        Select dropdown=new Select(select);
        dropdown.selectByIndex(0);
        driver.findElement(By.id("inlineRadio1")).click();
        
        driver.findElement(By.cssSelector("input[name='bday']")).sendKeys("04/05/1994");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[class*='btn-success']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[class*='btn-success']")).click();
        System.out.println(driver.findElement(By.cssSelector("div[class*='alert-dismissible']")).getText());
        driver.quit();
    }
}
