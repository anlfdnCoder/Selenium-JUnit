package day12_WebTables_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcell {

    @Test
    public void test01() throws IOException {

        //dosya yolunu olusturalim
         String dosyaYolu = "src/test/java/day12_webtables_excel/ulkeler.xlsx";
         //FileInputStream objesi olusturup, parametre olarak dosya yolunu yazalim
        FileInputStream fis = new FileInputStream(dosyaYolu);
        //Kod alanimizda excel'in bir kopyasini olusturup
        //tum bilgileri ona kopyalayacagiz
        Workbook workbook = WorkbookFactory.create(fis);

        //workbook icerisinde birden fazla sayfa olabilir.
        //istedigimiz sayfaya gidelim.

        Sheet sheet = workbook.getSheet("sayfa1");

        //Angola yazdirmak istedigimiz icin 5.satira gidelim.

        Row row = sheet.getRow(5);
        // 5.satirda 2. indexindeki datayi alalim

        Cell cell = row.getCell(2);

        System.out.println(cell);

        //1.satirdaki 2.hucreye gidelim ve yazdiralim
        //- 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim -
        //2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        //- Satir sayisini bulalim
        //- Fiziki olarak kullanilan satir sayisini bulun
        //- Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim


    }
}
