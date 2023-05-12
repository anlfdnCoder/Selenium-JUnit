package day13_writeExcel_ScreenShot;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.IOException;

public class C05_IstenenElementScreenShot extends TestBase {

    @Test
    public void test01() throws IOException {
        //amazona git
        driver.get("https://amazon.com/");
        //nutella aratin
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella"+ Keys.ENTER);
        //sonuclarin nutella icerdigini test edin
        WebElement resultOfSearching = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small" +
                " a-spacing-top-small']"));
        String expected = "Nutella";
        String resultOfActual = resultOfSearching.getText();
        Assert.assertTrue(resultOfActual.contains(expected));
        //arama sonuc elementinin screenshot'ini cekin
//        File dateiName = new File("target/ekranResimleri/nutella.jpeg");
//
//        File geciciDosya = resultOfSearching.getScreenshotAs(OutputType.FILE);
//
//        FileUtils.copyFile(geciciDosya,dateiName);

        ReusableMethods.elementCek(resultOfSearching);
    }
}
