package techproed.day02_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_ManageMethod_ImplicitlyWait {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        /*
        implicitlyWait(Duration.ofSeconds(20)) sayfadaki webElementleri gorunur olana kadar (sayfada olusana kadar)
        maximum 20 saniye bekler. Eged webelementler 2 saniyede olusursa 2 saniye bekler ve alt satira gecer.Fakat
        belirttigimiz maximum sure boyunca internetten ya da sayfadan kaynakli olarak webElementler olusmazsa testimiz
        fail verir.
        Thread.sleep() java kodlarini bizim belirttigimiz sure kadar bekler. 30 aniye beklemesini belirtirsem
        30 saniye bekler ve alt satira gecer.
         */
        //techproed sayfasina gidelim
        String amazonUrl="https://www.amazon.com/";
        String techproUrl="https://techproeducation.com";
        driver.get(techproUrl);

        //amazona gidelim
        driver.get(amazonUrl);

        //techpro sayfasina geri donelim
        driver.navigate().back();

        //sayfa basliginin techpro icerdigini test edelim.
        String actualTitle = driver.getTitle();
        String arananKelime="Techpro";
        if (actualTitle.contains(arananKelime)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAIL "+actualTitle);

        //tekrar amazon sayfasina gidelim

        driver.navigate().forward();
        //sayfa basliginin Amazon icerdigini test edelim.
        String actualTitle2=driver.getTitle();
        String arananKelime2="Amazon";
        if (actualTitle2.contains(arananKelime2)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAIL");

        //sayfayi kapatiniz.
        driver.close();//


    }
}
