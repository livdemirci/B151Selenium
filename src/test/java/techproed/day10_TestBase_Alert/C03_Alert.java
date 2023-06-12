package techproed.day10_TestBase_Alert;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import techproed.utilities.TestBase;

public class C03_Alert extends TestBase {
    @Test
    public void test01() {
        driver.get("https://demoqa.com/alerts");
        //Click Button to see alert karsisindaki butona tiklayalim
        driver.findElement(By.xpath("(//button)[2]")).click();
        bekle(2);
        //Cikan Alert'te You clicked a button yazisinin ciktigini dogrulayalim
        System.out.println(getTextAlert());
        Assert.assertEquals("You clicked a button",getTextAlert());
        bekle(2);
        //ve alert'i kapatalim
        acceptAlert();
        bekle(5);
    }

    @Test
    public void test02() {
        //On button click, confirm box will appear karşısındaki butona tıklayalım.
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.xpath("(//button)[4]")).click();
        bekle(2);
        //Çıkan alertte iptale basalım.
        dismissAlert();
        // Sonuç yazısında You selected Cancel yazdığını doğrulayalım
        String sonucYazisi=driver.findElement(By.id("confirmResult")).getText();
        Assert.assertEquals("You selected Cancel",sonucYazisi);
    }

    @Test
    public void test03() {
        driver.get("https://demoqa.com/alerts");
        //On button click, prompt box will appear karşısındaki butona tıklayalım
        driver.findElement(By.xpath("(//button)[5]")).click();
        bekle(2);
        //çıkan alerte ismimizi girelim
        sendKeysAlert("Mustafa");
        bekle(2);
        acceptAlert();
        //ismi girdiğimizi doğrulayalım
        String sonucYazisi= driver.findElement(By.id("promptResult")).getText();
        Assert.assertTrue(sonucYazisi.contains("Mustafa"));

    }
}
