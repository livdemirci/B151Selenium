package techproed.day15_FileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C03_FileUploadTest extends TestBase {
    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //chooseFile butonuna basalim
        String dosyaYolu = "C:\\Users\\livde\\Desktop\\git.txt";
        WebElement dosyaSec = driver.findElement(By.id("file-upload"));
        dosyaSec.sendKeys(dosyaYolu);
       // dosyaSec.click();
        /*
        Eger dosyaSec butonuna basmamiz istenirse ve otomasyon ile bu butona click yapmak istedigimizde
        exception aliyorsak, direk dosyayi sayfaya upload yapabiliriz
         */

        //Yuklemek istediginiz dosyayi secelim.
        //
        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        //
        //"File Uploaded!" textinin goruntulendigini test edelim.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
    }
}
