package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReusableMethods {

    public static void wait(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {  // baska classlardan cagirdigimizda artik bize exception itiraz etmeyecek

        }
    }

    public static void tumSayfaScreenshotCek(WebDriver driver) {
        //1- TakeScreenshot objesi olustur

        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2- resmi son olarak kaydedecegimiz dosyayi olustur.

        //her resim cektiginde ust uste kaydetmemesi icin
        // resim dosya yoluna tarih ve saat iceren bir ek yapalim
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String tarih = ldt.format(dtf);
        String dosyaYolu  = "target/ekranResimleri/tumEkran"+tarih+".jpeg";

       File tumSayfaScreenShot = new File(dosyaYolu);

        //3. tss objesi kullanarak ekran goruntusu alip, gecici dosyaya kaydet.

        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        //4- gecici dosyayi ana dosyaya kopyala
        try {
            FileUtils.copyFile(geciciDosya,tumSayfaScreenShot);
        } catch (IOException e) {

        }
    }

    public static void elementCek( WebElement element) {
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String tarih = ldt.format(dtf);
        String dosyaYolu  = "target/ekranResimleri/ElementEkran"+tarih+".jpeg";
        File dateiName = new File(dosyaYolu);

        File geciciDosya = element.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(geciciDosya,dateiName);
        } catch (IOException e) {

        }

    }
}
