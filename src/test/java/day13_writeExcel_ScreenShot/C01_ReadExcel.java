package day13_writeExcel_ScreenShot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void test01() throws IOException {

        //Excel dosyalari bilgisayarimizda oldugu icin (selenium webDriver'in bir isi yok)
        // Java'da FileInputStream class'i yardimiyla ulasacagiz.

        String dosyaYolu = "src/test/java/day12_webtables_excel/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu); // dosyaya ulastik

        Workbook workbook = WorkbookFactory.create(fis); // excel dosyasini kopyaladik ve workbook objesinin icine koyduk

        workbook.getSheet("Sayfa1").getRow(3).getCell(1);

        //Satir ve sutun bilgisini parametre olarak alip
        // o hucredeki bilgiyi yazdiran bir metod olusturun

        dataYazdir(25,2);//Brunei
        dataYazdir(25,2);//Dakka






    }

    private void dataYazdir(int satir, int sutun) throws IOException {
        String dosyaYolu = "src/test/java/day12_webtables_excel/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu); // dosyaya ulastik

        Workbook workbook = WorkbookFactory.create(fis); // excel dosyasini kopyaladik ve workbook objesinin icine koyduk

        System.out.println(workbook.getSheet("Sayfa1").getRow(3).getCell(1));
    }
}
