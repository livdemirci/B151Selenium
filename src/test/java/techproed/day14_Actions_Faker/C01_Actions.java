package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C01_Actions extends TestBase {
    @Test
    public void name() {
        //techpro sayfasina gidelim
        driver.get("https://www.techproeducation.com");
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        bekle(2);
        //sayfanin altina dogru gidelim
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        bekle(2);
        //sayfanin ustune dogru gidelim
        actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP).perform();

    }

    @Test
    public void test02() {
        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        bekle(2);
        //sayfanın en altına scroll yapalım
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END);

        //sayfanın en üstüne scroll yapalım
        actions.sendKeys(Keys.HOME).build().perform();
        //build() --> methodu action'ları birleştirmek için kullanılan methoddur.Birden fazla oluşturduğumuz action
        //objesini birbirine bağlar
        //release() ==> methodu mouse'u serbest birakir

    }

    @Test
    public void test03() {

            driver.get("https://techproeducation.com");
            driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
            bekle(1);
            //sayfanin altina dogru gidelim
            Actions actions = new Actions(driver);
            actions.scrollByAmount(0, 1500).perform();

            //sayfanin ustune dogru gidelim
            actions.scrollByAmount(0, -1500).perform();
        }
    }


