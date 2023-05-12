package day09_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_KeyboardActions extends TestBase {
    @Test
    public void test01(){
        /*
        1- https://www.amazon.com adresine gidelim
        2- Samsung A71 yazdirin ve enter'a basin
        3-
         */
        // 1- https://www.amazon.com adresine gidelim
        driver.get("https://www.amazon.com");
        //2- Samsung A71 yazdirin ve enter'a basin
        Actions actions = new Actions(driver);

        WebElement element = driver.findElement(By.id("twotabsearchtextbox"));

        actions
                .click(element)
                .keyDown(Keys.SHIFT)// shifte basili tut
                .sendKeys("s")
                .keyUp(Keys.SHIFT)// shiftten elini cek
                .sendKeys("amsung ")
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("71")
                .sendKeys(Keys.ENTER) // click yerine geciyor mouse da
                .perform();
        ReusableMethods.wait(3);

        // 4- aramanin gerceklestigini test edin

        WebElement element1 = driver.findElement(By.xpath("//*[@class='a-color-state a-text-bold']"));

        String expected = "Samsung A71";
        String actual = element1.getText();

        Assert.assertTrue(actual.contains(expected));

    }
}
