package techproed.day11_Iframe_WindowLandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import techproed.utilities.TestBase;

public class C03_WindowHandle extends TestBase {
    @Test
    public void windowHandle() {
        /*
            Eger sayfaya gittikten sonra yeni sekme yada yeni bir pencerele baska sayfaya gittikten sonra
            tekrar ilk actiginiz sayfaya donmek isterseniz, ilk sayfaya driver.get() methoduyla gittikten sonra
            String bir degiskene handle degerini assign ederseniz tekrar ilk acilan sayfaya donmek istediginizde
            driver.switchTo().window(ilksayfaHandleDegeri) ile gecis yapabilirsiniz.
         */
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techproedWindowHandle = driver.getWindowHandle();
        //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        String actualTitle = driver.getTitle();
        String expectedTitle = "Techpro Education | Online It Courses & Bootcamps";
        Assert.assertEquals(expectedTitle, actualTitle);

        //Window 2'de (yeni bir pencerede )https://www.youtube.com sayfasını açınız:
        driver.switchTo().//gecis yap
                newWindow(WindowType.WINDOW);//-->Yeni bir pencereye driver'i tasir
        //WindowType.TAB -->Yeni bir sekme acar
        driver.get("https://www.youtube.com");
        String youtubeWindowHandle = driver.getWindowHandle();
        bekle(3);
        //Window 3'te (yeni bir pencerede )https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        bekle(3);
        String linkedinHandle = driver.getWindowHandle();
        bekle(3);
        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(techproedWindowHandle);
        //youtube sayfasına geçiniz:
        driver.switchTo().window(youtubeWindowHandle);
        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedinHandle);
    }

    @Test
    public void test02() {
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techproedWindowHandle = driver.getWindowHandle();
        //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        String actualTitle = driver.getTitle();
        String expectedTitle = "Techpro Education | Online It Courses & Bootcamps";
        Assert.assertEquals(expectedTitle, actualTitle);

        //Window 2'de (yeni bir pencerede )https://www.youtube.com sayfasını açınız:
        driver.switchTo().//gecis yap
                newWindow(WindowType.TAB);//-->Yeni bir pencereye driver'i tasir
        //WindowType.TAB -->Yeni bir sekme acar
        driver.get("https://www.youtube.com");
        bekle(3);
        String youtubeWindowHandle = driver.getWindowHandle();
        //Window 3'te (yeni bir pencerede )https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com");
        bekle(3);
        String linkedinHandle = driver.getWindowHandle();
        bekle(3);
        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(techproedWindowHandle);
        bekle(3);
        //youtube sayfasına geçiniz:
        driver.switchTo().window(youtubeWindowHandle);
        bekle(3);
        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedinHandle);
        bekle(3);
    }
    }
