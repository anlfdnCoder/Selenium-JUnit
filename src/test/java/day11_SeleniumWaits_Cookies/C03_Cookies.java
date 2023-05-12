package day11_SeleniumWaits_Cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C03_Cookies extends TestBase {
    @Test
    public void test01(){
        //1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //2- tum cookie’leri listeleyin
        Set<Cookie>cookieSet =  driver.manage().getCookies();
        int siraNo= 1;
        for (Cookie each:cookieSet) {
            System.out.println(siraNo+"- "+each);
            siraNo++;
        }
        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(cookieSet.size()>5);
        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String expectedCookieDegeri  = "USD";
        String actualCookieDegeri = "";
        for (Cookie each:cookieSet) {
            if (each.getName().equals("i18n-prefs")){
                actualCookieDegeri = each.getValue();
            }
        }
        Assert.assertEquals(expectedCookieDegeri,actualCookieDegeri);
//        for (var each:cookieSet) {
//            if (each.getValue().equals(expectedCookieDegeri)){
//                actualCookieDegeri = each.getValue();
//                Assert.assertEquals(actualCookieDegeri,expectedCookieDegeri);
//            }
//        }
        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
        System.out.println();
        String isim = "en sevdigim cookie";
        String value = "cikolatali";
        Cookie benimCookie = new Cookie(isim,value);
        driver.manage().addCookie(benimCookie);
        cookieSet =  driver.manage().getCookies(); // her ekleme durumunda bu ifade hep yazilmali

        siraNo= 1;
        for (Cookie each:cookieSet) {
            System.out.println(siraNo+"- "+each);
            siraNo++;
        }
        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        String isim1 = "en sevdigim cookie";
        String expected = "cikolatali";
        String actual = "";
        for (var each:cookieSet) {
            if (each.getName().equals(isim1)){
                actual = each.getValue();
            }
        }
        Assert.assertEquals(expected,actual);

        //ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        cookieSet = driver.manage().getCookies();
        int skinCookieSayisi=0;
        for (var each:cookieSet) {
            if (each.getName().equals("skin")){
                skinCookieSayisi++;
            }
        }
        Assert.assertEquals(0,skinCookieSayisi);

    }
    /*
    Yeni bir class olusturun : cookiesAutomation
1- Amazon anasayfaya gidin
2- tum cookie’leri listeleyin
3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
6- eklediginiz cookie’nin sayfaya eklendigini test edin
7- ismi skin olan cookie’yi silin ve silindigini test edin
8- tum cookie’leri silin ve silindigini test edin
     */

    /*
    otomatik cookies disable

    ChromeOptions options = new ChromeOptions();
    options.addArguments("--disable-notifications");
    options.addArguments("disable-infobars");


     */
}
