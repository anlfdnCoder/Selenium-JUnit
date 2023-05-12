package day12_WebTables_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class C03_ReadExcel {

    /*
    Yeni bir test method olusturalim readExcel2( )
- 1.satirdaki 2.hucreye gidelim ve yazdiralim
- 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
- 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
- Satir sayisini bulalim
- Fiziki olarak kullanilan satir sayisini bulun
- Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
     */
    @Test
    public void test01() throws IOException {
        // ulkeler excel'indeki sayfa1'e gidecek sekilde ayarlari yapalim
        String dosyaYolu = "src/test/java/day12_webtables_excel/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        //- 1.satirdaki 2.hucreye gidelim ve yazdiralim

        System.out.println(workbook.getSheet("Sayfa1").getRow(0).getCell(1));//Baskent(Ingilizce)

        //- 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String istenenHucredekiStr = workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString();
        System.out.println(istenenHucredekiStr);

        //- 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim

       String actualBaskent =  workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString();
       String expectBaskent = "Kabil";

        Assert.assertEquals(expectBaskent,actualBaskent);

        //- Satir sayisini bulalim

        System.out.println("satir Sayisi "+(workbook.getSheet("Sayfa1").getLastRowNum()+1));//satir sayisi
        // index numarasindan dolayi +1 ekledik.

        //- Fiziki olarak kullanilan satir sayisini bulun

        // bunun icin sayfa2 deki son satir index'ini ve fiziki kullanilan satir sayisini yazdiralim.

        System.out.println("ikinci sayfa son satir indexi : "+workbook.getSheet("Sayfa2").getLastRowNum());//23

        System.out.println("2.sayfa fiziki kullanilan satir sayisi : "+
                workbook.getSheet("Sayfa2").getPhysicalNumberOfRows());//8

        //- Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim

        Map<String,String>UlkeIsimBaskent = new TreeMap<>();

        int sonSatirIndexi = workbook.getSheet("Sayfa1").getLastRowNum();
        String key = "";
        String value= "";

        for (int i = 0; i < sonSatirIndexi; i++) {
            key = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            value = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()+", "+
                    workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()+", "+
                    workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();

            UlkeIsimBaskent.put(key,value);
            
        }
        System.out.println(UlkeIsimBaskent);



    }
}
