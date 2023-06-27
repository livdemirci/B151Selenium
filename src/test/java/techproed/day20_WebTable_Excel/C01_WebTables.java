package techproed.day19_ExtentReport_WebTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

import java.util.List;

public class C03_WebTables extends TestBase {

    /*
    WEBTABLE;
           <table> tagi ile baslar
                <thead> basliklar icin bu tag ile devam eder.
                    <tr> basliklarin satiri
                    <th> table head
                        <td> basliktaki veriler
                    <tbody> basliklar altindaki verileri temsil eder.
                        <tr> table row(satir)
                            <td> table data
     */
    @Test
    public void name() {
        extentReport("Chrome","WebTable");
        extentTest=extentReports.createTest("WebTable","Test Raporu");
        //    https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");
        extentTest.info("Sayfaya gidildi");

        //    Task 1 : Table1’i yazdırın
        WebElement table1 = driver.findElement(By.xpath("(//table)[1]"));
        System.out.println("table1 = " + table1.getText());
        extentTest.info("Tablo1 yazdirildi");

        //    Task 2 : 3. Satır verilerini yazdırın
        WebElement ucuncuSatir = driver.findElement(By.xpath("(//table)[1]//tr[3]"));
        System.out.println("******************************************");
        System.out.println("ucuncuSatir = " + ucuncuSatir.getText());
        extentTest.info("3. Satir verileri yazdirildi");

        //    Task 3 : Son satırın verilerini yazdırın
        WebElement sonSatir= driver.findElement(By.xpath("(//tbody)[2]//tr[last()]"));
                                                //last() ==>istenilene gore son satir ya da sutun bilgilerini verir.
        System.out.println("1. Tablo Son Satir Bilgileri:" + sonSatir.getText());
        extentTest.info("Son satir verileri yazdirildi");

        //    Task 4 : 5. Sütun verilerini yazdırın
        WebElement besinciBaslik= driver.findElement(By.xpath("(//thead)[1]//th[5]"));
        System.out.println("besinciBaslik = " + besinciBaslik.getText());//==>Besinci sutun basligi
        List<WebElement> besinciSutun = driver.findElements(By.xpath("(//tbody)[1]//td[5]"));
        besinciSutun.forEach(t-> System.out.println(t.getText()));
        extentTest.info("5. Sutun verileri yazdirildi.");

        //Task 5: 3. satirdaki 1. ve 2. sutun bilgilerini yazdiriniz.
        System.out.println("********************************************");
        List<WebElement> ucuncuSatirr = driver.findElements(By.xpath("(//tbody)[1]//tr[3]//td[position()>=1 and position()<=2]"));
        ucuncuSatirr.forEach(t-> System.out.println(t.getText()+"\t"));
        extentTest.info("3. satirdaki 1. ve 2. sutun bilgilerini yazdirildi");
        System.out.println("************************");
        //    Task 6 : Iki parametreli bir Java metodu oluşturalım: printData


        //    Parameter 1 = satır numarası
        //    Parameter 2 = sütun numarası
        //    printData(2,3);  => 2. satır, 3. sütundaki veriyi yazdırsın.

        printDate(3,2);
        System.out.println(printDate(2, 3));
        extentTest.info("2. satır, 3. sütun bilgileri yazdirildi");

        //3. satir 2. sutun bilgisinin Jack olup olmadigini dogrulayin
        String actualData = printDate(3,2);
        String unExpectedData="Jack";
        Assert.assertNotEquals(unExpectedData,actualData);
        extentTest.fail("3. satir 2. sutun bilgisinin Jason oldugu goruldu");
        extentTest.pass("Sayfa Kapatildi");
        extentReports.flush();
    }

    private String printDate(int satir, int sutun) {
        WebElement satirSutun = driver.findElement(By.xpath("(//tbody)[1]//tr["+satir+"]//td["+sutun+"]"));
        return satir+".satir "+sutun+".sutun " + satirSutun.getText();
    }

    //ODEV
    //C03_WebTables class'i icin aldigimiz ropora gidelim basligin Extent Report oldugunu test edelim
    //NOT:driver.get("testOutput/extentReports/extentReport_01_58_26_27062023.html)
    //Rapor temasini dark yapalim
    //Dashboord bolumune gidip tabloyu yazdiriniz
    //Tester'in "ismininiz" olugunu dogrulayalim.
    //Sayfayi kapatalim
}
