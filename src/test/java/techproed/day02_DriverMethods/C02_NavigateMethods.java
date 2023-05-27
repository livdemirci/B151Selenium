package techproed.day02_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_NavigateMethods {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Techproeducation sayfasina gidelim
        driver.navigate().to("https://www.techproeducation.com");//get() methodu ile ayni mantikta calisir
        Thread.sleep(3000);//Java kodlarini bekletmek icin Thread.sleep kullanabiliriz
        //Sonra Amazon sayfasina gidelim
        driver.navigate().to("https://amazon.com");
        Thread.sleep(3000);
        //Amazon sayasinin basligini yazdiralim
        System.out.println("Amazon Sayfa Basligi : "+driver.getTitle());
        Thread.sleep(3000);
        //Techproeducation sayfasina geri donelim
        driver.navigate().back();
        //Sayfa basligini yazdiralim
        System.out.println("Techproed Sayfa Basligi : "+driver.getTitle());
        Thread.sleep(3000);
        //Amazon sayfasina tekrar gidip url'i yazdiralim.
        driver.navigate().forward();
        System.out.println("Amazon Sayfa Url'i : "+driver.getCurrentUrl());
        Thread.sleep(3000);
        //Amazon sayfasindayken sayfayi yenileyelim.
        driver.navigate().refresh();



    }
}
