package techproed.day01_IlkTest_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverMethods {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://amazon.com");
        System.out.println("Amazon Sayfa Basligi: " + driver.getTitle());
        System.out.println("Amazon Actual url : "+driver.getCurrentUrl());
        String amazonWindowHandle= driver.getWindowHandle();
        System.out.println("Amazon Window Handle Degeri "+amazonWindowHandle);

        //getTitle() sayfa basligini verir
        driver.get("https://techproeducation.com");
        System.out.println("Techproed Actual Title : " + driver.getTitle());

        //getCurrentUrl() gidilen sayfanin Url'ini verir.
        System.out.println("Techproed Actual url : "+driver.getCurrentUrl());

        //getPageSource() Acilan sayfanin kaynak kodlarini verir

        //System.out.println("Techproed Kaynak Kodlari : "+driver.getPageSource());

        //getWindowHandle() Gidilen sayfanin handle degerini(hashKod) verir. Bu handle degerini
        //sayfalar arasi gecis icin kullaniriz.

        System.out.println("Techproed Window Handle Degeri "+driver.getWindowHandle());


    }
}
