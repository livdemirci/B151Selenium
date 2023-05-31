package techproed.day03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class C03_findelements {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Amazon sayfasina gidelim
        driver.get("https://www.amazon.com/");
        //Sayfadaki linklerin sayisini ve linkleri yazdiralim.
        /*
        findelement ile bir elemente ulasabilirken, birden fazla webelement icin findelements methodunu kullaniriz.
        Bu weblelementlerin sayisina ulasmak icin ya da bu webelementlerin yazisini konsola yazdirabilmek icin
        List <Webelement> linklerListesi = driver.findElements(By.locator("locator degeri)) olarak kullaniriz.
        Olusturmus oldugumuz list'i loop ile konsola yazdirabiliriz.
         */
        List<WebElement> linklerListesi = driver.findElements(By.tagName("a"));
        System.out.println("Linklerin Sayisi = " + linklerListesi.size());

//        for (WebElement w : linklerListesi) {
//            if (!w.getText().isEmpty())
//                System.out.println(w.getText());
//        }
//
        //lambda ile yazdiralim
        //linklerListesi.forEach(link -> {if (!link.getText().isEmpty())
        //{System.out.println(link.getText());}});

        linklerListesi.forEach(webElement -> {
                    if (!(webElement == null)) {
                        System.out.println(webElement.getText());
                    }
                });


        //Shop deals in Electronics webElementinin yazisini yazdiralim
        System.out.println("********************************");
        System.out.println(driver.findElement(By.linkText("Shop great deals now")).getText());
        driver.close();
    }

    //Amazon sayfasina gidiniz

    //iphone aratiniz
    //cikan sonuc yazisini konsola yazdiriniz.
    //cikan urunlerden ilk 5 tanesine tiklayip basliklarini yazdiriniz.
}

