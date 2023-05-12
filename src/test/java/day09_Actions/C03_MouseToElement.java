package day09_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C03_MouseToElement extends TestBase {

    @Test
    public void test01(){
        /*
        Yeni bir class olusturalim: MouseActions3
1- https://www.amazon.com/ adresine gidin
2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirin
3- “Create a list” butonuna basin
4- Acilan sayfada “Your Lists” yazisi oldugunu test edin
         */
        //1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        Actions actions = new Actions(driver);
        ReusableMethods.wait(5);
        WebElement element = driver.findElement(By.xpath("//*[@id='nav-link-accountList-nav-line-1']"));
        actions.moveToElement(element).perform();
        ////*[@id='nav-link-accountList-nav-line-1']
        //“Create a list” butonuna basin
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();
        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin
        String actual = driver.findElement(By.xpath("//*[@role='heading']")).getText();
        String expect = "Your Lists";
        Assert.assertTrue(actual.contains(expect));

    }
}
