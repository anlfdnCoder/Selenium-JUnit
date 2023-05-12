package day13_writeExcel_ScreenShot;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.IOException;

public class C03_TakeScreenShotTumSayfa extends TestBase {

    @Test

    public void test01() throws IOException {
        //amazona gidin
        driver.get("https://www.amazon.com");
        //Nutella yazdirin
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella"+ Keys.ENTER);
        //arama sonuclarinin Nutella icerdigini test edin
        WebElement resultOfSearching = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small" +
                " a-spacing-top-small']"));
        String expected = "Nutella";
        String resultOfActual = resultOfSearching.getText();
        Assert.assertTrue(resultOfActual.contains(expected));
        //Tum sayfanin screenShot'ini alin
        String extra ="tum2ekranGoruntusu";

        ReusableMethods.tumSayfaScreenshotCek(driver);




    }
}
