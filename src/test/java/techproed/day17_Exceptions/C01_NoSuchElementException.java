package techproed.day17_Exceptions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import techproed.utilities.TestBase;

public class C01_NoSuchElementException extends TestBase {
    @Test
    public void test01() {
        /*
        NO_SUCH_ELEMENT_EXCEPTION
            -Bir webelementin locate'ini yanlis aldigimizda elementi bulamayacagi icin bu excepiton'i aliriz

         */
        //techproeducation sayfasina gidelim
        driver.get("https://www.techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //arama kutusunda qa aratalim.
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='search']"));
        /*normal locatimiz //*[@type='search'] bu sekilde iken NoSuchElementException alabilmek icin locate'i bozduk ve
        ve exception aldigimizi gorduk. Dolayisiyla bu hatayi handle edebilmek icin duzgun locate almamiz gerekiyor.
        Webelement bir iframe icinde olabilir, bir butona tikladigimizda yeni bir pencere acilabilir, ya da Alert cikabilir bu gibi
        durumlarda da  NoSuchElementException aliriz.
         */


        aramaKutusu.sendKeys("qa", Keys.ENTER);


        //sayfa basliginin qa icerdigini test edelim.
        Assert.assertTrue(driver.getTitle().contains("qa"));

    }
    @Test
    public void test02() {
        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        //arama kutusunda qa aratalım
        WebElement aramaKutusu = driver.findElement(By.cssSelector("//*[@type='search']"));
    /*
    org.openqa.selenium.InvalidSelectorException: xpath ile aldığımız bir webelementin locate'ini
    cssSelector locator ile kullanırsak bu exception'ı alırız. Dolayısıyla bunu handle etmek için
    doğru locator'ı kullanmamız gerekir.
     */

        aramaKutusu.sendKeys("qa", Keys.ENTER);

        //sayfa başlığının qa içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("qa"));
    }
}
