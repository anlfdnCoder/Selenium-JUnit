package day08_HandlingWindows;

import org.junit.Assert;
import org.junit.Test;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_TestBaseIlkTest  extends TestBase {
    @Test
    public void test01(){

        // amazon'a gidin
        driver.get("https://www.amazon.com");
        // amazon'a gittiginizi test edin

        String expected = "amazon";
        String actual = driver.getCurrentUrl();

        Assert.assertTrue(actual.contains(expected));
        ReusableMethods.wait(3);


    }
}
