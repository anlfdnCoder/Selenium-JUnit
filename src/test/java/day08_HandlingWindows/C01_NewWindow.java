package day08_HandlingWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class C01_NewWindow {
    /*
    Selenium 4 ile windows konusunda yeni bir ozellik geldi.

    Istersek kontrollu olarak driver icin yeni bir window beya bir Tab olusturabiliriz
    Bu durumda driver'imiz da otomatik olarak yeni sayfaya gecmis olur.

    Testin ilerleyen asamalarinda yeniden eski sayfalara donus gorevi varsa o sayfada iken o sayfanin window Handle degeri
    alinip kaydedilir.
    ve o sayfaya gecmek istendiginde driver.switchTo(window(istenenSayfaninWindowHandleDegeri)
    kodu ile o sayfaya gecis yapilir.
    String ilkSayafaHandle = driver.getWindowHandle()

    driver.switchTo(window(istenenSayfaninWindowHandleDegeri)

     driver.switchTo().newWindow(WindowType.TAB); // yeni bir tab acar.

     */

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
        driver.get("https://www.amazon.com");
        Thread.sleep(3000);
        String ilkSayafaHandle = driver.getWindowHandle();// bu string ifadesini almak istersek bulundugu site de yazmamaiz lazim

        // yeni bir tab'da wisequarter.com'a gidin ve gittigimizi test edin.

        driver.switchTo().newWindow(WindowType.TAB); // yeni bir tab acar.

        driver.get("https://www.wisequarter.com");

        String actual = driver.getCurrentUrl();
        String expected = "wisequarter";
        Assert.assertTrue(actual.contains(expected));
        Thread.sleep(3000);

        // wisequarter testini yaptiktan sonra yeniden amazonun acik oldugu tab'a gecin ve amazon ana sayfanin
        // acik oldugunu test edin

        /*
        Testin ilerleyen asamalarinda yeniden amazon sayfasina donmek gerekiyor ise
        amazon sayfasindayken bu window'un window handle degerini alip kaydetmeliyiz.

         */


        driver.switchTo().window(ilkSayafaHandle);

        String actualUrl = driver.getCurrentUrl();
        String expectedd = "amazon";

        Assert.assertTrue(actualUrl.contains(expectedd));

//        Set<String> handle = driver.getWindowHandles();
//
//        Iterator<String>it = handle.iterator();
//
//        String parent = it.next();


    }

}
