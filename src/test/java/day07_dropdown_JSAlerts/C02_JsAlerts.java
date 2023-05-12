package day07_dropdown_JSAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_JsAlerts {
    /*
    Gerekli ayarlamalari yapip
    https://the-internet.herokuapp/javascript alerts adresine gidin
    //3 test method'u olusturup her method'da bir JsAlert'e basin
    // ilgili methodlari kullanin
     */
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }
    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }
    @Test
    public void goToUrl(){// Test metodlari static olmaz
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @Test
    public void checkAlertButton() throws InterruptedException {
        driver.findElement(By.cssSelector("[onclick='jsAlert()']")).click();


        String actualAlertYazisi = driver.switchTo().alert().getText();
        String expected = "I am a JS Alert";

        Assert.assertEquals(expected,actualAlertYazisi);

        driver.switchTo().alert().accept();
        Thread.sleep(2000);


    }

    @Test
    public void checkConfirmButton() throws InterruptedException {
        // 2.alert'e tiklayalim
        // cansel'a basip, cikan sonuv yazisinin "You clicked: Cancel" oldugunu test edin

        driver.findElement(By.cssSelector("[onclick='jsConfirm()']")).click();
        driver.switchTo().alert().dismiss();

        String actual = driver.findElement(By.cssSelector("#result")).getText();
        String expected = "You clicked: Cancel";

        Assert.assertEquals(expected,actual);

        Thread.sleep(2000);

    }

    @Test
    public void checkPromptButton() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("Anil");
        driver.switchTo().alert().accept();

        Thread.sleep(2000);
        String expect = "You entered: Anil";
        String actual = driver.findElement(By.cssSelector("#result")).getText();
        Assert.assertEquals(expect,actual);
    }
}
