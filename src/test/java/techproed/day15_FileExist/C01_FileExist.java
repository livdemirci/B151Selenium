package techproed.day15_FileExist;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import techproed.utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileExist extends TestBase {

    @Test
    void test01() {
           /*
        Bir websitesini test ettigimizde dowload islemi yapildigi zaman dosyanin bilgisayarimiza inip inmedigini kontrol etmek
        yani bilgisayarimizdaki herhangi bir dosyanin varligini dogrulayabilmek icin;
            Files class'indan exists() methodunu kullanarak parametre olarak Paths.get(dosyayolu) methodunu kullanarak
            dosyanin varligini test edebiliriz. ==> Files.exists(Paths.get(dosyayolu)
            Dolayisiyla bu isleme baslamadan once dosya varligini test edecegimiz dosyanin yolunu String bir degiskene
            assign ederiz.
         */
        String dosyaYolu = "C:\\Users\\livde\\Desktop\\git.txt";
        System.out.println("Files.exists(Paths.get(dosyaYolu)) = " + Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }

    @Test
    public void test03() {
    /*
        Bir server'da farkli işlerim sistemleri ile aynı anda dosya varlığını test etmek istediğimiz zaman,
    daha dinamik olması açısından System.getProperty("os.name") bu şekilde işletim sistemi alır
    her işletim sistemin kullanıcı yolu farklı olacağından System.getProperty("user.home")
    bilgisayarımızdaki kullanıcı yolunu bu şekilde String bir değişkene farklıYol ismiyle System.getProperty("user.home")
    atayarak herseferinde farklı yolları almayla uğraşmamış oluruz. Dosya diyelimki masaüstünde ve her işletim
    sisteminde bize aynı yolu vereceği için bunuda ortakYol olarak bir String'e assing ederiz

        Windows10 surumlerinden onceki surumler icin pratik olarak dosya yolu almak istedigimiz dosyanin uzerine gelip
        shift+sag click tusana basarak yol olarak kopyala secenegi ile yolu dosya yolunu kopyalayabiliriz.
     */
        String farkliYol = "";
        String isletimSistemiAdi = System.getProperty("os.name");//-->İşletim sistemimizin adını verir
        System.out.println(isletimSistemiAdi);
        System.out.println(System.getProperty("user.home"));//-->Bilgisayarımızdaki kullanıcı yolunu verir
        if (isletimSistemiAdi.contains("Win")) {
            farkliYol = System.getProperty("user.home");//-->Windows 10/-->C:\Users\Lenovo
        } else if (isletimSistemiAdi.contains("mac")) {
            farkliYol = "/Users/aycapolatkamali";//-->Mac işletim sistemi yolu
        }
        String ortakYol = "/OneDrive/Masaüstü/sen.txt";
        String dosyaYolu = farkliYol + ortakYol;
        System.out.println("Files.exists(Paths.get(dosyaYolu)) = " + Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        try {
            Files.delete(Paths.get(dosyaYolu));//Bu sekilde belirtmis oldugumuz dosyayi sileriz.::..
        } catch (IOException e) {
            System.out.println("Dosya bulunamadi");
        }
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        //sildigimiz dosya isminde yeni bir dosya olusturalim
        try {
            Files.createFile(Paths.get(dosyaYolu));//Belirtmis oldugumuz dosyayi olusturduk
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        /*
        Her seferinde test ettigimiz sayfada download islemi yapiliyorsa gereksiz dosya kalabaligini onlemek yukaridaki
        delete islemini kullanabiliriz
         */
    }

    @Test
    void test04() {
        /*
        Yukaridaki methodlara bilgisayarimizdaki dosya yolunun varligini Files.exists() methoduyla test etmistir
        Ayni islemi asagidaki ornekteki gibi File class'indan obje olusturarak da yapabiliriz.
         */
        String dosyaYolu = "C:\\Users\\livde\\Desktop\\git.txt";
        //File file = new File(dosyaYolu);
        System.out.println("new File(dosyaYolu).exists() = " + new File(dosyaYolu).exists());


    }
}