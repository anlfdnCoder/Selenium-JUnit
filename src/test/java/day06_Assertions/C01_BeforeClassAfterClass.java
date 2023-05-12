package day06_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BeforeClassAfterClass {
    // 3 ayri test method'u olusturun
    //1.method'da amazon/a gidip, amazona gittigimizi test edin
    //2.method'da amazon'da nutella aratip, sonuclarin nutella icerdigini test edin.
    //3.method'da nutella arama sonuc sayisinin 50'den fazla oldugunu test edin.

    /*
    @BeforeClass ve @AfterClass notasyou kullanan method'lar static olmak zorundadir.
     1. Method setUp() should be static
     2. Method tearDown() should be static
     */
    static WebDriver driver;
    WebElement aramaKutusu;


    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
    @Test
    public void test01 (){
        //1.method'da amazon/a gidip, amazona gittigimizi test edin
        driver.get("https://www.amazon.com/");
        String expectedKelime = "Amazon";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedKelime)){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }
//        if (actualTitle.contains(expectedKelime)){
//            System.out.println("PASSED");
//        }else
//            System.out.println("FAILED");
    }
    @Test
    public void test02(){
        //2.method'da amazon'da nutella aratip, sonuclarin nutella icerdigini test edin.
      aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        String expectedKelime = "Nutella";
        WebElement element = driver.findElement(By.cssSelector("[class='a-section a-spacing-small a-spacing-top-small']"));

        if (element.getText().contains(expectedKelime)){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }


    }
    @Test
    public void test03(){
        //3.method'da nutella arama sonuc sayisinin 50'den fazla oldugunu test edin.
        WebElement element = driver.findElement(By.cssSelector("[class='a-section a-spacing-small a-spacing-top-small']"));


        System.out.println(element.getText());
    }


}
