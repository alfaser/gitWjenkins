import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class seIntro {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        WebDriver driver = new ChromeDriver();
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
         var tes = driver.findElement(By.xpath("//p[@class='error'"));
         Assert.assertEquals(tes, "* Incorrect username or password");

    }

}
