package day09_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C02_dragAndDrop extends TestBase {

    @Test
    public void test01(){
        /*
        Yeni bir class olusturalim: MouseActions2
1- https://demoqa.com/droppable adresine gidelim
2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
         */
       //1- https://demoqa.com/droppable adresine gidelim
       driver.get("https://demoqa.com/droppable");
       //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions actions = new Actions(driver);
        WebElement a1 = driver.findElement(By.cssSelector("#draggable"));
        WebElement a2 = driver.findElement(By.xpath("(//*[@id='droppable'])[1]"));
        actions.dragAndDrop(a1,a2).perform();
        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        ReusableMethods.wait(2);
        String actual = driver.findElement(By.xpath("//*[text()='Dropped!']")).getText();
        String expect = "Dropped!";

        Assert.assertEquals(expect,actual);



    }
}
