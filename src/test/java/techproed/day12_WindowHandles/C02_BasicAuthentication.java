package techproed.day12_WindowHandles;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import techproed.utilities.TestBase;

public class C02_BasicAuthentication extends TestBase {
    @Test
    public void test01() {

//    Aşağıdaki bilgileri kullanarak authentication yapınız:
//    Url: https://the-internet.herokuapp.com/basic_auth
//    Username: admin
//    Password: admin
//    Başarılı girişi doğrulayın.

     driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
     bekle(3);
     //Basarili bir giristen sonra Congratulations! yazisinin ciktigini dogrulayin
        WebElement text = driver.findElement(By.xpath("//p"));
        String expected = "Congratulations!";
        Assert.assertTrue(text.getText().contains(expected));
        bekle(3);
        //Elemental Selenium yazisina tiklayalim
        driver.findElement(By.xpath("(//a)[2]")).click();

        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());//Acilan yeni pencereye gectik
        //Basligin "Elemental Selenium" oldugunu dogrulayin
        String title = "Elemental Selenium";
        System.out.println("title = " + title);
        Assert.assertNotEquals(title,driver.getTitle());
        //DDM'den java secelim
        WebElement ddm = driver.findElement(By.xpath("//select"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Java");

    }
}
