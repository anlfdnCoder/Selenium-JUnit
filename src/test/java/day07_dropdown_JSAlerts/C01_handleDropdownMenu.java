package day07_dropdown_JSAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_handleDropdownMenu {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


    }
    @After
    public void tearDown(){
        driver.close();

    }

    @Test
    public void test01() throws InterruptedException {
        // ilgili ayarlari yapin
        // amazon anasayfaya gidin
        // arama kutusu yanindaki dropdown menuden book secin
        //arama kutusuna java yazdirip aramayi yapin
        // title'in  java icerdigini test edin.

        driver.get("https://www.amazon.com");

        //Dropdown menu'den istedigimiz option'i secebilmek icin
        // oncelikle select classindan bir obje olusturmaliyiz
        // ancak select objesi olusturmak icin Select class'inin constructor'i
        // handle edecegimiz web element'i istediginden
        // select objesi olusturmadan once dropdown webElementini locate etmeliyiz.

        //1.Adim
        WebElement dropdown = driver.findElement(By.cssSelector("#searchDropdownBox"));

        //2.Adim
        Select select = new Select(dropdown);

        //3.Adim
        select.selectByValue("search-alias=stripbooks-intl-ship");// option'in value attribute demek
//        select.selectByIndex(5);

        String actualResult = select.getFirstSelectedOption().getText();
        String expectedResult = "Books";

        Assert.assertEquals(expectedResult,actualResult);
        Thread.sleep(2000);

        /*
        Locate ettigimiz elementi bulamazsa NoSuchElementException
        sayfa yenilendigi icin var olan bir elementi kullanamazsa
        StaleElementException verir.
        bu durumda locate ve secme islemini yeniden yaparsak kodumuz calisir.
         */

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java"+ Keys.ENTER);



        Assert.assertTrue(driver.getTitle().contains("Java"));


        // Dropdown menudeki secenek sayisinin 24 oldugunu test edin

        List<WebElement>optionsWebElementListesi = select.getOptions();

        int actualOptionSayisi = optionsWebElementListesi.size();
        int expectedOptionsSayisi = 28;

        Assert.assertEquals(expectedOptionsSayisi,actualOptionSayisi);





    }
}
