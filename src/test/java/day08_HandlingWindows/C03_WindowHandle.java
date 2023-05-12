package day08_HandlingWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C03_WindowHandle {
    //https://the-internet.herokuapp.com/iframe adresine gidin
    // elemental selenium linkini tiklayin
    // yeni tab'a gecip sayfadaki en buyuk yazinin "Elemental Selenium" oldugunu test edin
    // ilk sayfaya geri donup sayfadaki yazinin
    //"An iFrame containing the TinyMCE WYSIWYG Editor" oldugunu test edin.

    static WebDriver driver;
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
        //https://the-internet.herokuapp.com/iframe adresine gidin
        driver.get("https://the-internet.herokuapp.com/iframe");
        // elemental selenium linkini tiklayin
        //Linke tikladigimizda yeni sayfa acilacagindan
        // click yapmadan once ilk sayfanin WHD'ini alip kaydedelim
        String ilkSayfaWHD = driver.getWindowHandle();
        driver.findElement(By.linkText("Elemental Selenium")).click();

        //click yapinca yeni tab eacilir ancak driver eski tab'da kalir.
        //yeni tab'a driver'i gecirmek icin yeni tab'i WHD ihtiyacimiz var.

        Set<String> ilkSayfaninWHDDegerleriSeti = driver.getWindowHandles();

        String ikinciSayfaWHD = "";
        for (var eachWindowsHandle:ilkSayfaninWHDDegerleriSeti) {
            if (!eachWindowsHandle.equals(ilkSayfaWHD)){
                ikinciSayfaWHD = eachWindowsHandle;
            }
        }

        //Foreach Loop bittiginde ikinci sayfanin windowHandle degerini elde etmis olacagiz.
        // bu degeri kullanarak, driver'i 2.sayfaya gecirebiliriz.
        driver.switchTo().window(ikinciSayfaWHD);
        // yeni tab'a gecip sayfadaki en buyuk yazinin "Elemental Selenium" oldugunu test edin
        String expectedIkincisayfaYazi = "Elemental Selenium";
        String actualIkincisayfaYazi = driver.findElement(By.tagName("h1")).getText();

        Assert.assertEquals(expectedIkincisayfaYazi,actualIkincisayfaYazi);
        Thread.sleep(3000);

        driver.switchTo().window(ilkSayfaWHD);
        String expected = "An iFrame containing the TinyMCE WYSIWYG Editor";
        String actual = driver.findElement(By.tagName("h3")).getText();

        Assert.assertEquals(expected,actual);
        Thread.sleep(3000);


        // ilk sayfaya geri donup sayfadaki yazinin
        //"An iFrame containing the TinyMCE WYSIWYG Editor" oldugunu test edin.







    }

}
