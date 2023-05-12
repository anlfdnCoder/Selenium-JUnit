package day10_FileTests;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class C01_FileInputStream {

    @Test
    public void test01() throws FileNotFoundException {
        String dosyaYolu = "/Users/Febe/Desktop/Merhabajava.docx";
        FileInputStream fis = new FileInputStream(dosyaYolu); // dosya yolu istiyor

        /*
        Dosya file testlerinde genellikle downloads'a indirilecek bir dosyanin
        indirildigini test etmek
        veya masaustundeki bir dosyanin web'e yuklenebildigini test etmek isteriz

        Ancak herkesin bilgisayarinin ismi, kullanici isimleri gibi farkliliklar olacagindan testler tek bir bilgisayarda
        calisacak gibi yazilmak zorunda kalinir.

        Bu karisikliligin onune gecebilmek icin java iki basit code blogu sunmus:

         */
        System.out.println(System.getProperty("user.dir"));
        //O anda calisan dosyanin (C01_FileInputStream) dosyasinin yolunu verir
        ///Users/Febe/Desktop/Team113_JUnit/com.Team113JUnit : suanda calisan proje.

        System.out.println(System.getProperty("user.home"));
        // kullanicin temel path'ini verir
        // /Users/Febe  hangi user da calisiliyor.

        //Masa ustune gitmek istersek
        // /Users/Febe+/desktop eklememiz yeterli

        // /Users/Febe + /Downloads eklememiz yeterlidir

        // Kodlarimizin dinamik olmasi yani kisinin bilgisayarindaki
        // kullanici adi gibi detaylara takilmamasi icin
        // File testlerinde kullanilacak dosya yolunu
        // user.home... temel path'ini calistigi bilgisayardan alacak sekilde  olustururuz.

        // String dosyaYolu = "/Users/Febe/Desktop/Merhabajava.docx";
        String dinamikDosyaYolu = System.getProperty("user.home")+"/Desktop/Merhabajava.docx";


    }
}
