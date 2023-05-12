package day09_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Set;

public class C01_MouseActions extends TestBase {
    @Test
    public void test01(){
        // 1- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        // 2- cizili olan uzerinde sag click yapin
        Actions mouse = new Actions(driver);
        WebElement vierEck = driver.findElement(By.cssSelector("#hot-spot"));
//        mouse.moveToElement(vierEck).contextClick().perform();
        mouse.contextClick(vierEck).perform();
        ReusableMethods.wait(3);
        // 3- Alert'te cikan yazinin "You selected a context menu" oldugunu test edin
        String actual = driver.switchTo().alert().getText();
        String expect = "You selected a context menu";
        Assert.assertEquals(expect,actual);
        // 4-- tamam diyerek alert'i kapatalim
        driver.switchTo().alert().accept();
        // 5- eLEMANTAL sELENIUM lINKINE TIKLAYALIM
        driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();
        String firstPageWH = driver.getWindowHandle();

        //6- Acilan sayfada h1 taginda ""Elemental Selenium" yazdigini test edelim
        ReusableMethods.wait(5);
        Set<String> handle = driver.getWindowHandles();

        /*
        Test sirasinda test icin yapilan tum eylemleri webdriver objesi yaptigi icin,
        yeni acilan sayfada islem yapilabilmesi icin webdriver’in yeni sayfaya gecis yapmasi gerekir.
         */

        for (var each: handle) {
            if (!each.equals(firstPageWH)){
                driver.switchTo().window(each);
                String actual1 = driver.findElement(By.xpath("//h1[text()='Elemental Selenium']")).getText();
                String expect1 = "Elemental Selenium"; //  Elemental Selenium

                Assert.assertEquals(expect1,actual1);

            }
        }

//        String actual1 = driver.findElement(By.xpath("//h1[text()='Elemental Selenium']")).getText();
//        String expect1 = "Elemental Selenium"; //  Elemental Selenium
//
//        Assert.assertEquals(expect1,actual1);




    }
}
