package techproed.day10_TestBase_Alert;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C02_Alerts  extends TestBase {
     /*
            Eger bir sayfadaki bir buttona tikladigimizda bir uyari penceresi cikiyorsa ve bu cikan pencereye sag click
        yapip locate alamiyorsak, bu bir js Alert'tur.
            Js Alert'u handle edebilmek icin driver'imizi o pencereye gecirmemiz gerekir. Bunun icin;
        driver objemizi kullanarak switchTo() methodu ile alert() methodunu kullanarak js alert'e gecis yapmis oluruz.
        accept() ya da dissmis () methodlariyla js Alert'u onaylar ya da iptal ederek kapatiriz.

         */


    //Bir metod olusturun: acceptAlert
    //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
    //Bir metod olusturun: dismissAlert
    //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    //“successfuly” icermedigini test edin.
    //Bir metod olusturun: sendKeysAlert
    //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

    @Test
    public void acceptAlert() {
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin."
        //Bir metod olusturun: acceptAlert
        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("(//button)[1]")).click();
        bekle(3);
        driver.switchTo().//gecmek icin kullanilar method
                alert().//alert'e gecis yapar
                accept();//cikan alert'te ok ya da tamam butonuna tiklar
        bekle(2);
        WebElement resultMessage = driver.findElement(By.xpath("(//p)[2]"));
        String istenenYazi= "You successfully clicked an alert";
        Assert.assertEquals(istenenYazi,resultMessage.getText());

    }

    @Test
    public void dismissAlert() {
        //Bir metod olusturun: dismissAlert
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        //“successfuly” icermedigini test edin.
        driver.findElement(By.xpath("(//button)[2]")).click();
        driver.switchTo().alert().dismiss();
        WebElement resultMessage = driver.findElement(By.xpath("(//p)[2]"));
        String istenenMetin = "successfuly";
        Assert.assertFalse(resultMessage.getText().contains(istenenMetin));
        bekle(5);

    }

    @Test
    public void sendKeysAlert() {
        //Bir metod olusturun: sendKeysAlert
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.findElement(By.xpath("(//button)[3]")).click();
        bekle(3);
        driver.switchTo().alert().sendKeys("Mustafa");
        bekle(3);
        driver.switchTo().alert().accept();
        bekle(5);
        WebElement resultMessage = driver.findElement(By.xpath("(//p)[2]"));//You entered: Mustafa

       String girilenMetin = "Mustafa";
       Assert.assertTrue(resultMessage.getText().contains(girilenMetin));



    }
}
