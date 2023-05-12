package day13_writeExcel_ScreenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C06_JSExecutor extends TestBase {
    @Test
    public void test01(){
        //amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //sell linkine JS executor kullanarak click yapin
        JavascriptExecutor JS = (JavascriptExecutor) driver;

        WebElement element = driver.findElement(By.xpath("//a[text()='Sell']"));
        JS.executeScript("arguments[0].click();",element);



    }
}
