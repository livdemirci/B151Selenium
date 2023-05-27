package techproed.day01_IlkTest_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_IlkTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        //Java uygulamalarind system ozelliklerini ayarlamak icin setProperty methodu ile kullaniriz.
        //setProperty methodu ile class'imiza driver'in fiziki yolunu belirttik.
        System.out.println(System.getProperty("webdriver.chrome.driver"));
        //getProperty ile "Key" degerini girerek "value"ya ulasabilirim.

        WebDriver driver =new ChromeDriver();
        //ChromeDrivr turunde yeni bir obje olusturduk
        driver.get("https://techproeducation.com");//String olarak girilen url'e gider.

    }

}
