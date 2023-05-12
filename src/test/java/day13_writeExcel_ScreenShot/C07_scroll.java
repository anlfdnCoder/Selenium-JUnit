package day13_writeExcel_ScreenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C07_scroll extends TestBase {
    @Test
            public void test01(){
        driver.get("https://wisequarter.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath(
                "(//*[@class='elementskit-btn  whitespace--normal'])[3]"));

        js.executeScript("arguments[0].scrollIntoView();",element);

        js.executeScript("alert('yasasinnn');");


    }


}
