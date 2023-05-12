package day11_SeleniumWaits_Cookies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_ImplicitlyWait {
    WebDriver driver;
   @Test
   public void test01(){
       WebDriverManager.chromedriver().setup();
       driver =new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
       driver.manage().window().maximize();

       //Selenium 4'e kadar 15 saniyeyi belirtmek icin
       //Timeouts class'indan 15 saniye tanimliyorduk
       // Selenium4 ile birlikte zaman belirleme class'i duration oldu.
   }
}
