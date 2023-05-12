package day06_Assertions;

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

public class C05_CheckBox {
    /*
    Gerekli yapiyi olusturun ve asagidaki gorevi tamamlayin
        a. Verilen web sayfasina gidin.
            https://the-internet.herokuapp.com//checkboxes
        b. Checkbox1 ve checkbox2  elementlerini locate edin
        c. Checkbox1 secili degilse onay kutusunu tiklayin ve secili oldugunu test edin
        d. Checkbox2 secili degil ise onay kutusunu tiklayin ve secili oldugunu test edin.
     */
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
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement element1 = driver.findElement(By.xpath("//*[@type='checkbox'][1]"));
        WebElement element2 = driver.findElement(By.xpath("//*[@type='checkbox'][2]"));

        if (!element1.isSelected()){
            element1.click();
        }
        Assert.assertTrue(element1.isSelected());

        if (!element1.isSelected()){
            Assert.assertTrue(element2.isSelected());

            Thread.sleep(3000);
        }
        // Cookies ler her ulkede farkli olusturulur ondan bir class repo ull ederken dikkat et
    }
}
