package day11_SeleniumWaits_Cookies;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C04_WebTables extends TestBase {
    /*
    1."https://www.amazon.com" adresine gidin
    2.Sayfanin en altina inin
    3.Web table tum body’sini yazdirin
    4.Web table’daki satir sayisinin 9 oldugunu test edin
    5.Tum satirlari yazdirin
    6. Web table’daki sutun sayisinin 13 olduğunu test edin
    7. 5.sutunu yazdirin
    8.Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun
     */
    @Test
    public void test01(){
     // 1."https://www.amazon.com" adresine gidin
     driver.get("https://www.amazon.com");
     //2.Sayfanin en altina inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();

       //3.Web table tum body’sini yazdirin
        WebElement element = driver.findElement(By.cssSelector("tbody"));


        //4.Web table’daki satir sayisinin 9 oldugunu test edin
        List<WebElement>listRow = driver.findElements(By.xpath("//tbody/tr"));
        System.out.println(listRow.size());
        //  5.Tum satirlari yazdirin
        for (var each: listRow) {
            System.out.println(each.getText()+" ");
        }

//        Assert.assertEquals(10,listRow.size());

        //6. Web table’daki bir satirdaki sutun sayisinin 13 olduğunu test edin

        List<WebElement>columnList = driver.findElements(By.xpath("//tbody/tr[1]/td"));

//        Assert.assertEquals(13,columnList.size());

        //7. 5.sutunu yazdirin

        List<WebElement>column5 = driver.findElements(By.xpath("//tbody/tr/td[5]"));
        for (var each:column5) {
            System.out.println(each.getText());
        }

        //    8.Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun

        System.out.println("============");
        WebElement istenenDataElementi = eightQuestion(3,5);
        System.out.println(istenenDataElementi.getText());

        ReusableMethods.wait(5);
    }
    private WebElement eightQuestion(int satir, int sutun){
//        String row = String.valueOf(satir);
        int row = satir;
//        String column = String.valueOf(sutun);
        int column = sutun;

        WebElement element = driver.findElement(By.xpath("//tbody/tr["+row+"]/td["+column+"]"));
        return element;

    }
}
