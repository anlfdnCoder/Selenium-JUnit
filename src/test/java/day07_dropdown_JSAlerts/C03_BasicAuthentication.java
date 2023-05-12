package day07_dropdown_JSAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BasicAuthentication {
    /*
    1- Bir class olusturun :
    2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
    3- asagidaki yontem ve test datalarini kullanarak authentication'i yapin

    Html komutu : https://username:password@URL
        username : admin
        password: admin

    4- Basarili sekilde sayfaya gidirldigini dogrulayin
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
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/basic_auth");

        Thread.sleep(3000);

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        String actual = driver.findElement(By.tagName("p")).getText();
        String expected = "Congratulations";

        Assert.assertTrue(actual.contains(expected));
        Thread.sleep(3000);

    }
}
