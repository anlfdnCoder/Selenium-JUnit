package day10_FileTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C03_FileUploadTesti extends TestBase {
    @Test
    public void test01(){
        // https://the-internet.herokuapp.com/upload
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim
        //Yuklemek istediginiz dosyayi secelim

        /*
        Bu gorevi yapabilmek icin chooseFile butonuna basildiginda
        acilan bilgisayarimizdaki file dosyalarini click yapabilmemiz gerekiyor
        ancak Selenium bilgisayarimizdaki dosyalari click yapamaz.

        Bunun yerine soyle bir cozum uretilmistir.
        1- chooseFile butonunu locate edin
        2- upload edilecek dosyanin dosya yolunu olusturun
        3-chooseFile butonuna sendKeys ile dosya yolunu yollayin
         */
        WebElement chooseFileButton = driver.findElement(By.xpath("//*[@id='file-upload']"));
        String dosyaYoli = System.getProperty("user.home")+"/Desktop/Merhabajava.docx";

        chooseFileButton.sendKeys(dosyaYoli);

        //upload butonuna basalim
        driver.findElement(By.xpath("//*[@id='file-submit']")).click();

        //"File Uploaded" textinin goruntulendigini test edelim.
        WebElement uploadedElement = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(uploadedElement.isDisplayed());
        ReusableMethods.wait(3);






    }
}
