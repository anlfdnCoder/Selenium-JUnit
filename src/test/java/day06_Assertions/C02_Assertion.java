package day06_Assertions;

import org.junit.Assert;
import org.junit.Test;

public class C02_Assertion {
    /*
    JUnit framework'u calistirilan testlerin passed veya failed olmasini raporlar
    Ancak rapolamanin dogru sonuc vermesi icin
    Test'lerin Assert class'indaki hazir metod'larla yapilmasi gerekir.

    Eger Assert class'i kullnilmazsa
    JUnit kodlarin sorunsuz olarak calisip bittigini raporlar
    C01'de testleri if-else ile yaptigimiz icin
    Testler failed olsa da kodlar sorunsuz calistigi icin
    testler yesil tik olarak isaretlendi.


     */
    int P1yas1 = 60;
    int P2yas2 = 66;
    int P3yas3 = 70;

    @Test
    public void test01(){
        // emekli yasi 65 olduguna gore
        // yas2'nin emekli olabilecegini test edin
//        Assert.assertFalse(P2yas2>70);
        Assert.assertFalse("girilen yas 65 den kucuk olmadigindan emekli olabilir",P3yas3>66);

    }
}
