package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public  class forgotPass{
    WebDriver driver = new ChromeDriver();
    public static String user = "sergio";
    
    public void inicio() throws InterruptedException {
    
    //WebDriver driver = new FirefoxDriver();
     //WebDriver driver = new EdgeDriver();
     driver.get("https://rahulshettyacademy.com/locatorspractice/");      
     System.out.println(driver.getTitle());
     System.out.println(driver.getCurrentUrl());
     driver.findElement(By.id("inputUsername")).sendKeys("seralfa"); 
     driver.findElement(By.name("inputPassword")).sendKeys("123");
     driver.findElement(By.className("signInBtn")).click();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
     var error = driver.findElement(By.cssSelector("p.error")).getText();
     System.out.println(error);
     var tes = driver.findElement(By.xpath("//p[@class='error']")).getText();//*[@id="container"]/div[2]/form/p
     Thread.sleep(1000);
     try {
     Assert.assertEquals(tes,"* Incorrect username or passwordd");
     }catch(Exception e) {
         System.out.println("El error es:"+e);
     }
     }
    
    public void recuperarPass() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.xpath("//div[@class='forgot-pwd-container']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("sergio");
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("ser@out.com");
        driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("51615686");
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        var texto = driver.findElement(By.cssSelector(".infoMsg")).getText();
        String[] texto1 = texto.split("'");
        var password = texto1[1].split("'")[0];
        System.out.println(password);
        driver.findElement(By.cssSelector(".go-to-login-btn")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("inputUsername")).sendKeys(user);
        driver.findElement(By.xpath("//input[@name='inputPassword']")).sendKeys(password);
        driver.findElement(By.cssSelector("#chkboxTwo")).click();
        driver.findElement(By.cssSelector("button[class*='submit']")).click();
        
        
    }
}
