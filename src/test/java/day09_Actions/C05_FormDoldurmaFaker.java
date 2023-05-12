package day09_Actions;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C05_FormDoldurmaFaker extends TestBase {
    @Test
    public void test01(){
        // facebook.com sayfasina gidin
        driver.get("https://www.facebook.com");
        // cookie kabul ediniz
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _9xo7 _4jy3 _4jy1 selected _51sy']")).click();
        // yeni hesap olustur butonuna basin
        driver.findElement(By.cssSelector("[class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        // ilgili alanlari faker kutuphanesinden degerlerle doldurup
        WebElement firstNameBox = driver.findElement(By.name("firstname"));
        Actions actions = new Actions(driver);
        Faker faker = new Faker();

        String mailAdress = faker.internet().emailAddress(); // fake email adress

        (actions.click(firstNameBox)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)// tab da send keys kullaniriz
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(mailAdress)
                .sendKeys(Keys.TAB)
                .sendKeys(mailAdress)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("23")
                .sendKeys(Keys.TAB)
                .sendKeys("Dec")
                .sendKeys(Keys.TAB)
                .sendKeys("1991")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)).perform();

        WebElement signUpButton = driver.findElement(By.name("websubmit"));





        //kaydol butonuna basin
        signUpButton.click();
        // jayit olamadiginizi test edin
        WebElement element = driver.findElement(By.id("reg_error_inner"));
        ReusableMethods.wait(20);

//        Assert.assertTrue(element.isDisplayed());






    }
}
