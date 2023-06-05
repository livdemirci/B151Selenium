package techproed.day05_Xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_cssSelector {
    public static void main(String[] args) {
        /*
        cssSelector ile xpath arasindaki farklar;
        1-cssSelector de @ isareti ve //
         */
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//        https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

//        Add Element butonuna basin
        WebElement addElementButton = driver.findElement(By.cssSelector("button[onclick='addElement()']"));


//        Delete butonu’nun gorunur oldugunu test edin
//        Delete tusuna basin
//“Add/Remove Elements” yazisinin gorunur oldugunu test edin
    }
}
