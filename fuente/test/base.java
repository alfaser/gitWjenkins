package test;

import java.util.Arrays;
import java.util.List;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class base {
    
    static WebDriver driver = new ChromeDriver();
    public static void pagina() throws InterruptedException {
        
     
        String[] elementos = {"Cucumber","Beans","Brocolli"};
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));  
        
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        Thread.sleep(2000);
        driver.manage().window().maximize();
        agregar(driver,elementos);
        
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//div[@class='action-block']/button")).click();    
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
        
        Thread.sleep(1500);
        driver.quit();
        
        }
    
    public static void agregar(WebDriver driver,String[] elementos){
        int j =0;
        List<WebElement> productos = driver.findElements(By.cssSelector("h4.product-name"));
        
        for(int i=0;i<productos.size();i++) {
            String[] name = productos.get(i).getText().split("-");
            String formatedName= name[0].trim();
            
            //System.out.println(i+". "+name);
            List elementosListados= Arrays.asList(elementos);
            
            if(elementosListados.contains(formatedName)) {
                j++;               
                ////button[text()='ADD TO CART'] no usar tanto el text por que puede cambiar, no es buena practica
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                if(j==3) break;
            }
        }
        
    }

}
