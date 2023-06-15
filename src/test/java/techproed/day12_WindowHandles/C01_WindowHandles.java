package techproed.day12_WindowHandles;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import techproed.utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C01_WindowHandles extends TestBase {
    @Test
    public void test01() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfasının Handle degerini alın yazdırın
        String ilkSayfaHandle = driver.getWindowHandle();
        System.out.println("ilkSayfaHandle = " + ilkSayfaHandle);

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText,actualText);

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle,actualTitle);

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();//kontrolumuz disinda yeni sekme acildi
        bekle(3);
        /*
            Bir butona click yaptigimizda Kontrolumuz disinda yeni bir sekme ya da pencere acilirsa
            direk yeni acilan pencerenin handle degerini bilmedigim icin normal getWindowHandle ile
            driver'imi yeni pencereye geciremem.Bunun icin getWindowHandles() methoduyla acilan tum
            pencereleri bir Set'e assign edip, ilkactigimiz pencere digilse ikinci acilan yeni penceredir
            mantigiyla bir loop icinde cozebiliriz.
         */

        Set<String> pencereler = driver.getWindowHandles();
        for (String w:pencereler){
            System.out.println(w);
            if (!w.equals(ilkSayfaHandle)){//E61D2F8F506D07E4E02D938F3AD0574B==> ilk sayda handle degeri
                driver.switchTo().window(w);//E26B659EFE7D9ADCCCABA908A402AD17
            }
        }

        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        String actualTitleNewWindow = driver.getTitle();
        String expectedTitleNewWindow ="New Window";
        Assert.assertEquals(expectedTitleNewWindow,actualTitleNewWindow);
        String ikinciSayfaHandle =driver.getWindowHandle();
        System.out.println(ikinciSayfaHandle);

        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(ilkSayfaHandle);
        String ilkSayfaActualTitle = driver.getTitle();
        String ilkSayfaExpectedTitle = "The Internet";
        Assert.assertEquals(ilkSayfaExpectedTitle,ilkSayfaActualTitle);
        bekle(2);
        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(ikinciSayfaHandle);
        bekle(2);
        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(ikinciSayfaHandle);
        bekle(2);
        //Assert.assertTrue ==> isSelected, isEnable, isDisplay ve contains tarzinda boolean donduren ifadelerde kullanilir
        //Assert.assertTrue ==> ... oldugu gibi esitlik isteyen ifadelerde kullanilir
    }

    @Test
    public void test02() {

        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");


        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText,actualText);


        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle,actualTitle);

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();//kontrolumuz disinda yeni sekme acildi
        bekle(3);

        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        List<String> pencereler = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pencereler.get(1));
        String actualTitleNewWindow = driver.getTitle();
        String expectedTitleNewWindow ="New Window";
        Assert.assertEquals(expectedTitleNewWindow,actualTitleNewWindow);
        bekle(2);
        /*
            getWindowHandles() methodunu kullanarak acilan tum pencerelerin handle degerlerini bir arraylist' e atadaik
        Index 0(sifir)'dan basladigi icin kontrolum disinda acilan pencere 1. index de oldugundan
         driver.switchTo().window(pencereler.get(1)); ile yeni acilan pencereye gecis yaptik
         */
        bekle(2);
        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(pencereler.get(0));
        String ilkSayfaActualTitle = driver.getTitle();
        String ilkSayfaExpectedTitle = "The Internet";
        Assert.assertEquals(ilkSayfaExpectedTitle,ilkSayfaActualTitle);
        bekle(2);
        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(pencereler.get(1));
        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(pencereler.get(0));
    }

    @Test
    public void test03() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText,actualText);

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle,actualTitle);

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();//--> Kontrolümüz dışında Yeni bir sekme açıldı
        bekle(3);
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        /*
        Set ve ArrayList kullanmadan switchTo().window() methodu icine arguman olarak driver.getWindowHandles() methodunu ile
        butun acilan pencereli bir array olarak alip indev belirterek istedigim pencereye gecis yapabildim.
         */
        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.

        String actualTitleNewWindow = driver.getTitle();
        String expectedTitleNewWindow = "New Window";
        Assert.assertEquals(expectedTitleNewWindow,actualTitleNewWindow);
    /*
        getWindowHandles() methodunu kullanarak açılan tüm pencerelerin handle değerlerini bir arraylist'e atadık.
    Index 0(sıfır)'dan başladığı için kontrolüm dışında açılan pencere 1. index de olduğundan
     driver.switchTo().window(pencereler.get(1)); ile yeni açılan penceye geçiş yaptık
     */

        bekle(2);
        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        String ilkSayfaActualTitle = driver.getTitle();
        String ilkSayfaExpectedTitle = "The Internet";
        Assert.assertEquals(ilkSayfaExpectedTitle,ilkSayfaActualTitle);
        bekle(2);
        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        bekle(2);
        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        bekle(2);
    }
}
