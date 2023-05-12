package day05_JunitFramework;

import org.junit.Ignore;
import org.junit.Test;

public class C01_ElvedaMainMetod {

    @Test
    // meta data denir notasyonlar bizim frameworka emir verir metodlarin calismasi icin
    // Annotations ile compil'a talimatlar verilebilir.
    public void test01(){
        System.out.println("Test01 calisti");
        // @Test notasyonu sayesinde her bir test metodu  bagimsiz olarak calisabilir.
        // eger icersinde bir assertion yoksa
        // kod problem yasanmadan calisip bittiginde
        // Junit test passed olarak raporlar
    }

    @Test @Ignore
    public void test02(){
        System.out.println("test02 calisti");
        //@ ignore notasyonu yazildigi test metodunun calistirilmamasini saglar.
    }
    @Test
    public void test03(){
        System.out.println("test03 calisti");
    }
}
