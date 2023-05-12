package day10_FileTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownloadTest extends TestBase {
    @Test
    public void test01(){

    //2. https://the-internet.herokuapp.com/download adresine gidelim.
    driver.get("https://the-internet.herokuapp.com/download");
   // 3. Facebook.png dosyasını indirelim
        driver.findElement(By.xpath("//a[text()='logo.jpg']")).click();
        ReusableMethods.wait(5);
   // 4. Dosyanın başarıyla indirilip indirilmediğini test edelim


        //Test icin oncelikle dosyanin indirildiginde dosya yolunun ne olacak bunu olusturmaliyiz

        String dosyaYolu = System.getProperty("user.home")+"/Downloads/logo.jpg";
        // hep ayni dosyayi indiridiginde indirilen dosya ismini hep degistirmen lazim.

        //bir dosyanin var olup olmadigini kontrol etmek icin Javadaki Files classindan yardim aliyoruz.

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
    @Test
    public void test02(){
        String dosyaYolu2 = System.getProperty("user.home")+"/Desktop/Merhabajava.docx";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu2)));
    }




}
