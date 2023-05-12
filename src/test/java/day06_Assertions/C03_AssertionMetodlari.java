package day06_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_AssertionMetodlari {
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
        Assert.assertTrue(actualTitle.contains(expectedKelime));
        //actualtitel expectedKelimeyi icerir?
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

        Assert.assertTrue(element.getText().contains(expectedKelime));


    }
    @Test
    public void test03(){
        //3.method'da nutella arama sonuc sayisinin 50'den fazla oldugunu test edin.
        WebElement element = driver.findElement(By.cssSelector("[class='a-section a-spacing-small a-spacing-top-small']"));

        String  array= element.getText().split(" ")[2];

        Assert.assertTrue(Integer.parseInt(array)>50);
        System.out.println(element.getText());
    }
}
