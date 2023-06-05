package techproed.day07_MavenJunit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeAfter {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void Test1() {
        driver.get("https://techproeducation.com");
    }

    @Test
    public void Test2() {
        driver.get("https://amazon.com");
    }


    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Her classtan once bir kez calisir");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Her classtan sonra bir kez calisir");
    }
}

//a.Verilen web sayfasına gidin.
//https://the-internet.herokuapp.com/checkboxes
//b.Checkbox1 ve checkbox2 elementlerini locate edin.
//c.Checkbox1 seçili değilse onay kutusunu tıklayın
//d.Checkbox2 seçili değilse onay kutusunu tıklayın


//-https://www.facebook.com adresine gidin
//-Cookies’i kabul edin
//-“Create an Account” button’una basin
//-“radio buttons” elementlerini locate edin
//-Secili degilse cinsiyet butonundan size uygun olani secin
