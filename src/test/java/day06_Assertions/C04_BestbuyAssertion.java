package day06_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BestbuyAssertion {
    /*
    1) Bir class olusturun: BestBuyAssertions
    2) https://www.bestbuy.com/ Adresine gidin farkli test method'lari olusturarak
        asagidaki testleri yapin:
            . sayfa URL'nin https://www.bestbuy.com/'a esit oldugunu test edin
            . titleTest => sayfa basliginin "Rest" icermedigini(contains) test edin
            . logoTest => BestBuy logosunun goruntulendigini test edin
            . FrancaisLinkTest => Fransizca Linkin goruntulendigini test edin.

     */
    // Junit de siralama nasil yapildigi ongorulemiyor
    static WebDriver driver;

   @BeforeClass
    public static void setUp(){
       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       driver.get("https://www.bestbuy.com/");
    }
    @AfterClass
    public static void tearDown(){
       driver.close();
    }
    @Test
    public void urlTest(){
       //sayfa URL'nin https://www.bestbuy.com/'a esit oldugunu test edin
        Assert.assertEquals("https://www.bestbuy.com/",driver.getCurrentUrl());
    }
    @Test
    public void titleTest(){
       //titleTest => sayfa basliginin "Rest" icermedigini(contains) test edin

        Assert.assertFalse(driver.getTitle().contains("Rest"));

    }
    @Test
    public void logoTest(){
       //          . logoTest => BestBuy logosunun goruntulendigini test edin
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='logo'])[1]")).isDisplayed());
    }

    @Test
    public void frenchLinkTest(){
       //            . FrancaisLinkTest => Fransizca Linkin goruntulendigini test edin.
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@lang='fr'])[1]")).isDisplayed());
    }
}
