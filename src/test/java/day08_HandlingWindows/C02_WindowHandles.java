package day08_HandlingWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class C02_WindowHandles {
    /*
    - https://the-internet.herokuapp.com/windows adresine gidin.
    - Sayfadaki textin "Opening a new window" oldugunu dogrulayin
    - Sayfa basliginin (title) "The Internet" oldugunu dogrulayin
    - Click Here buttona basin.
    - Acilan yeni pencerenin sayfa basliginin (title) "New Window oldugunu dogrulayin"
    - Sayfadaki textin "New Window" oldugunu dogrulayin.
    - Bir onceki pencereye geri dondukten sonra sayfa basliginin "The Internet" oldugunu dogrulayin


     */
WebDriver driver;
    @Before
    public  void setUp(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }
    @After
    public  void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");

        String expected = "Opening a new window";
        String actual = driver.findElement(By.tagName("h3")).getText();

        Assert.assertEquals(expected,actual);

        String expectedInt = "The Internet";
        String actualInt = driver.getTitle();

        String ilkSayfaHandleDegeri = driver.getWindowHandle();

        Assert.assertEquals(expectedInt,actualInt);

        driver.findElement(By.linkText("Click Here")).click();

        /*
        Kontrolsuz acilan tab'a gecis yapmak icin
        1-ilk sayfada iken o sayfanin WindowHandle degerini alip kaydedin
        2-2. sayfa acildiktan sonra getWindowHandles kullanarak
            acik olan tum sayfalarin windowHandle degerlerini bir set olarak kaydedin.
        3- Suanda elimizde 2 elementli set var. Elementlerden birtanesi birinci sayfanin windowHandle degeri
            1.sayfanin WHD'ine esit olmayan ise 2.sayfanin WHD olur.
         */

        Set<String> TumWindows = driver.getWindowHandles();// acik olan sayfalarinin windowHandel degerlerini set olarak donduru.
        // Set'de indeks muhabbeti yok.

        Collection<String> list = new ArrayList<>();


        String ikinciSayfaWHD;
        for (var each: TumWindows) {
            if (!each.equals(ilkSayfaHandleDegeri)){
                ikinciSayfaWHD = each;
                driver.switchTo().window(each);  // Bura onemli
            }
        }


        String expectedNewSayfa = "New Window";
        String actualNewSayfa = driver.getTitle();

        Assert.assertEquals(expectedNewSayfa,actualNewSayfa);

        Thread.sleep(3000);



    }
}
