package techproed.day10_TestBase_Alert;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import techproed.utilities.TestBase;

public class C01_TestBaseDemo extends TestBase {

    @Test
    public void test01() {
        //Techproeducation sayfasina gidelim
        //Basligin Bootcamp icerdigini test edelim.
        driver.get("https://techproeducation.com");
        bekle(3);

        //Basligin Bootcamp icerdigini test edelim
        String actualTitle=driver.getTitle();
        String expectedTitle="Bootcamp";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

}
