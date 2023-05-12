package day07_dropdown_JSAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_IFrame {
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
        /*
        1- https://the-internet.herokuapp.com/i/iframe adresine gidin

        2- Bir method olusturun: iframeTest
            - An IFrane containing... " textinin erisilebilir oldugunu test edin
            - ve konsolda yazdirin
            - Text Box'a "Merhaba Dunya!" yazin.
            - TextBox'in altinda bulunan "Elemental Selenium" linkini textinin gorunur oldugunu dogrulayin ve konsolda yazdirin.
         */
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement actual = driver.findElement(By.tagName("h3"));

        Assert.assertTrue(actual.isEnabled()); // erisebilir oldugunu test etmek : isEnabled()
        Thread.sleep(3000);

        WebElement iFrame = driver.findElement(By.xpath("//*[@id='mce_0_ifr']"));
        driver.switchTo().frame(iFrame);

        WebElement letterBox = driver.findElement(By.xpath("//body[@id='tinymce']"));
        letterBox.clear();// yaziyi sildik
        letterBox.sendKeys("Merhaba Dunya");
        Thread.sleep(3000);


        /*
        normal locate yapip yazdirmayi denedigimizde NoSuchElementException verdi
        yani elementi bulamadi
        kontrol ederken istedigimiz webelement'in vir iframe icinde oldugunu gorduk
        bu durumda once o iframe'e switchTo() yapmaliyiz
         */

        //Iframe'in icine girdikten sonra oradan cik denilinceye kadar
        // driver ifram'in icinde kalir
        //eger disina cikmak isterseniz

//        driver.switchTo().parentFrame();// bulundugu iframe'den bir ust html sayfasina gecer
        // bu daha cok ic ice ifremler oldugunda tercih edilir.

        driver.switchTo().defaultContent();// Anasayfaya gecis yapar.

        WebElement elementalSeleniumLink = driver.findElement(By.xpath("//div[text()='Powered by ']"));

        System.out.println(elementalSeleniumLink.getText());









    }


}
