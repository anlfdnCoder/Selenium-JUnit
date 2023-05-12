package day11_SeleniumWaits_Cookies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C02_ExplicitylWait {
    /*
    1.  iki tane metod olusturun: ImplicitWait(), explicitWait()
        iki metod icin de asagidaki adimlari test edin
    2.  https://the-internet.herokuapp.com/dynamic controls adresine gidin
    3.  remove butonuna basin
    4.  "It's gone!" mesajinin goruntulendigini dogrulayin
    5.  Add butonuna basin
    6.  It's back mesajinin gorundugunu test edin.
     */

    protected WebDriver driver;
    @Before
    public  void setUp(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @After
    public  void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
    @Test
    public void implicitWaitTest(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 2.  https://the-internet.herokuapp.com/dynamic_controls adresine gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
       // 3.  remove butonuna basin
        driver.findElement(By.xpath("//button[text()='Remove']")).click();

       // 4.  "It's gone!" mesajinin goruntulendigini dogrulayin
        WebElement element = driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(element.isDisplayed());
       // 5.  Add butonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();
       // 6.  It's back mesajinin gorundugunu test edin.
       WebElement element1 =  driver.findElement(By.xpath("//p[@id='message']"));
       Assert.assertTrue(element1.isDisplayed());
    }

    @Test
    public void ExplicitWaitTest(){
      //  2.  https://the-internet.herokuapp.com/dynamic controls adresine gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
      //  3.  remove butonuna basin
        driver.findElement(By.xpath("//button[text()='Remove']")).click();

        //Explicitly wait icin once wait objesi olusturalim:

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        //Bundan sonraki adimi belirlerken
        // islem yapmak istedigimiz elementin locate edilebilir olup olmadigi onemlidir
        // eger locate edilebilirse, once locate edip, sonra wait objesi ile o web element bekletilebilir.
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        //  4.  "It's gone!" mesajinin goruntulendigini dogrulayin
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[@id='message']")));
        ;

        Assert.assertTrue(element.isDisplayed());
        // 5.  Add butonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();


        //  6.  It's back mesajinin gorundugunu test edin.

        WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));

        Assert.assertTrue(element2.isDisplayed());

    }
}
