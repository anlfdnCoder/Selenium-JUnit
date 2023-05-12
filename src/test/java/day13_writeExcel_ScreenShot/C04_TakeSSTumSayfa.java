package day13_writeExcel_ScreenShot;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.IOException;

public class C04_TakeSSTumSayfa extends TestBase {
    @Test
    public void test01() throws IOException {
        //wisequarter ana sayfaya gidin
        driver.get("https://wisequarter.com/");
        //anasayfaya gittigimizi test edin
        WebElement element = driver.findElement(By.cssSelector("img[class*='attachment-large']"));

        Assert.assertTrue(element.isDisplayed());
        //tum sayfa screenshot alin
        String jpegName = "wisequarterHomePage";

        ReusableMethods.tumSayfaScreenshotCek(driver);

//        TakesScreenshot ts = (TakesScreenshot) driver;
//
//        File screenshotPicture = new File("target/ekranResimleri/sade.jpeg");
//
//        File geciciDosya = ts.getScreenshotAs(OutputType.FILE);
//
//        FileUtils.copyFile(geciciDosya,screenshotPicture);



    }
}
