package techproed.day02_DriverMethods;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_ManageMethods {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Browser'in konumunu yazdiralim
        System.out.println("Sayfanin konumu = "+driver.manage().window().getPosition());

        //Browser'in boyutlarini yazdiralim
        System.out.println("Sayfanin boyutlari = "+driver.manage().window().getSize());

        //Browser'i maximize yapalim
        driver.manage().window().maximize();
        /*
        Bir web sitesinde gittigimizde browser default olarak bir boyuta gelir.ve acilan browser'daki
        webElementlere browser maximize olmadigi icin ulasamayabiliriz. Dolayisiyla browser'i actiktan sonra
        maximize yaparsak driver butun webelementleri gorur ve rahatlikla mudahale edebilir. Bu yuzden
        browser'i actiktan sonra ilk olarak driver.manage().window().maximize(); yapmamamiz bizim webelementlere
        ulasmada isimizi kolaylastirir. Boylelikle fail almamis oluruz.
         */

        //Techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");

        //Browser'in konumunu yazdiralim
        System.out.println("Sayfanin konumu = "+driver.manage().window().getPosition());

        //Browser'in boyutlarini yazdiralim
        System.out.println("Sayfanin boyutlari = "+driver.manage().window().getSize());
        Thread.sleep(3000);

        //Sayfayi minimize yapalim
        driver.manage().window().minimize();

        //Sayfayi fullScreen yapalim
        driver.manage().window().fullscreen();
        Thread.sleep(3000);
        driver.manage().window().setPosition(new Point(50,50));//istedigimiz konuma getirir.
        driver.manage().window().setSize(new Dimension(600,600));//istedigimiz
        Thread.sleep(3000);
        //sayfayi kapatiniz
        driver.close();

    }
}
