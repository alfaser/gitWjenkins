package test;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPrueba {
    static ChromeOptions options = new ChromeOptions();

    static {
        Map<String, Object> prefs = new HashMap<>();

        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);

        options.setExperimentalOption("prefs", prefs);
    }
    
    static WebDriver driver = new ChromeDriver(options);
    static WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
    
    public static void logIn() throws InterruptedException {
        
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        
        var a = driver.findElement(By.xpath("//p[contains(@class,'text-center')]/b[1]")).getText();
        var b = driver.findElement(By.xpath("//p[contains(@class,'text-center')]/b[2]")).getText();
        //System.out.println(a + " "+b);
        driver.findElement(By.cssSelector("input#username")).sendKeys(a);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(b);
        driver.findElement((By.cssSelector("span.checkmark"))).click();
        WebElement staticDropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByIndex(2);
        
       driver.findElement(By.id("terms")).click();
       Thread.sleep(2000);
       driver.findElement(By.id("signInBtn")).click();
       
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.navbar-brand")));
       
       List<WebElement> productos = driver.findElements(By.xpath("//h4[@class='card-title'][a]"));
       List<WebElement> listas = driver.findElements(By.xpath("//button[contains(@class,'btn-info')]"));
       
       for(WebElement producto: productos)System.out.println(producto.getText());
       for(WebElement lista:listas) lista.click();
       driver.findElement(By.xpath("//a[contains(@class,'btn-primary')]")).click();
       Thread.sleep(2000);
       driver.quit();
       
       
       
    }
    

}
