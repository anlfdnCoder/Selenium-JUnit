package day12_WebTables_Excel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C01_WebTables extends TestBase {
    @Test
    public void test01(){

       //1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
       // 2. Headers da bulunan basliklari yazdirin
        By header = By.cssSelector("[class='rt-thead -header']");
        List<WebElement>headerList = driver.findElements(header);
        headerList.stream().forEach(s-> System.out.println(s.getText()));
        //3. 3.sutunun basligini yazdirin

        System.out.println();

        List<WebElement>basliklarListesi = driver.findElements(By.cssSelector("[class='rt-th rt-resizable-header -cursor-pointer']"));
        for (int i = 0; i < basliklarListesi.size(); i++) {
            if (basliklarListesi.get(i).getText().equals("Age")){
                System.out.println(basliklarListesi.get(i).getText());

            }
        }
        //4. Tablodaki tum datalari yazdirin
        List<WebElement>everyData = driver.findElements(By.cssSelector("[class='rt-td']"));
        for (var each:everyData) {
            System.out.println(each.getText());
        }
        //5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        List<WebElement>DATALARlISTESI = driver.findElements(By.cssSelector("[class='rt-td']"));
        int siraNo=1;
        for (var each:DATALARlISTESI) {
            if (!each.getText().equals("")||!each.getText().equals(" ")){
                System.out.println(siraNo+". "+each.getText());
                siraNo++;
            }
        }
        //6. Tablodaki satir sayisini yazdirin
        System.out.println(driver.findElements(By.cssSelector("[class='rt-tr-group']")).size());
        //7. Tablodaki sutun sayisini yazdirin
        // Basta basliklar listesi olusturmusutk, onun size'ini alalim.
        System.out.println("Sutun sayisi:  "+basliklarListesi.size());
        //8. Tablodaki 3.kolonu yazdirin
        System.out.println("==========");
       List<WebElement>elements= driver.findElements(By.xpath("//div[@class='rt-tr-group']/div[1]/div[3]"));
        for (var each:elements) {
            if ((!each.getText().equals(" ")||(!each.getText().equals("")))){
                System.out.println(each.getText());
            }
        }
        System.out.println();
        //9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        List<WebElement> list = driver.findElements(By.xpath("//div[@class='rt-tr-group']/div[1]/div[1]"));
        int sayac = 0;
        for (int i = 0; i < list.size() ; i++) {
            sayac++;
            if (list.get(i).getText().equals("Kierra")){
                System.out.println(sayac);
                break;
            }
        }
        WebElement list1 = driver.findElement(By.xpath("(//div[@class='rt-tr-group']/div[1]/div[5])"+
                "["+sayac+"]"));
        System.out.println(list1.getText());



        //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin

    }
}
