package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

import java.security.Key;

public class C03_KeyDownKeyUp extends TestBase {
    @Test
    public void name() {
        //Google anasayfasina gidelim
        driver.get("https://www.google.com");


        //arama kutusuna shift tusuna basili olarak selenium yazdiralim ve shift tusunu serbest birakarak java yazdiralim
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        Actions action = new Actions(driver);
        action.keyDown(aramaKutusu, Keys.SHIFT).//==>arama kutusunda shift tusuna bastik
                sendKeys("selenium").//selenium metnini shift tusuna basili kaldigi icin buyuk yazdi
                keyUp(Keys.SHIFT).//==>shift tusunu serbest biraktik
                sendKeys("java",Keys.ENTER).//==> bu kismi shift'i serbest biraktigimiz icin kucuk yazdi
                perform();


    }

    @Test
    public void test02() {
        //Google anasayfasina gidelim
        driver.get("https://www.google.com");


        //arama kutusuna shift tusuna basili olarak selenium yazdiralim ve shift tusunu serbest birakarak java yazdiralim
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys(Keys.SHIFT,"selenium", Keys.SHIFT,"-java",Keys.ENTER);
        /*
        Mouse islemleri icn actions class'ini kullanmamiz gerekir. Fakat bir metin kutusundaki klavye islemleri icin 
        action class'ina kullanmadan sendkeys methodu ile de istedigimiz bir metni buyuk yazdirabilir, hatta birden fazla
        klavye tuslarina bastirabiliriz. Yukardaki ornekte sendKeys() methodu ile Keys.SHIFT diyerek sonrasinda yazdirmak
        istedigimiz metni kucuk harfle yazmamiza ragmen buyuk harflerle yazdirdi, tekrar Keys.SHIFT kullanarak shift 
        tusunu serbest birakmis olduk
         */
    }

    @Test
    public void test03() {
        //google sayfasına gidelim
        driver.get("https://www.google.com");
        // Arama kutusuna "Selenium" yazın ve Enter tuşuna basın
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys("Selenium",Keys.ENTER);
        // Sayfayı bekleyin
        bekle(2);
        // Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim

        driver.findElement(By.xpath("//*[@class='gLFyf']")). //sayfa yenilendigi icin tekrar locate aldik.
                sendKeys(Keys.CONTROL,"a");//==>Metni kesebilmemiz icin once ctrl+= ile secmemiz gerekir
        bekle(2);
        driver.findElement(By.xpath("//*[@class='gLFyf']")).
                sendKeys(Keys.CONTROL,"x");
        bekle(2);
        //Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım
        driver.navigate().to("https://www.google.com");
        driver.findElement(By.xpath("//*[@class='gLFyf']")).
                sendKeys(Keys.CONTROL,"v");

    }
}
