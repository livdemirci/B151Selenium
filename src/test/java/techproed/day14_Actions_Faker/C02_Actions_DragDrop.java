package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C02_Actions_DragDrop extends TestBase {
    @Test
    public void test01() {
        //Given user is on https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //And user moves the target element(Drag me to my target) in to  destination
        // (Drop here
        //webelementi uzerine birakalim
        /*
        drag ve drop elementleri iframe icinde oldugu icin iframe gecis yapmaliyiz
         */
        driver.switchTo().frame(0);
        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions =new Actions(driver);
        actions.dragAndDrop(drag,drop).perform();
        /*
        Eger bir haraketli webelementi tutup baska bir webelementin uzerine birakmak istersek
        suruklemek istedigimiz webelementin locatini alip uzerine birakacagimiz  webelementin
        locatini de alarak dragAndDrop (kaynak,hedef) methodu ile islemi gerceklestirebiliriz*/

    }

    @Test
    public void test02() {
        //Given user is on https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //And user moves the target element(Drag me to my target) in to  destination
        // (Drop here
        //webelementi uzerine birakalim
        /*
        drag ve drop elementleri iframe icinde oldugu icin iframe gecis yapmaliyiz
         */
        driver.switchTo().frame(0);
        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(drag).//==>bu method ile webelemente mouse ile basili tuttuk
                moveToElement(drop).//==>bu method ile basili tuttugumuz webelementi diger webelementin uzerine goturduk
                release().//==>bu method ile basili tuttugumuz webelemeneti serbest biraktik
                perform();// ==>perform ile islemi sonlandirdik
    }

    @Test
    public void test03() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
    /*
    drag ve drop webelementleri iframe içinde olduğu için iframe geçiş yapmalıyız
     */
        driver.switchTo().frame(0);
        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
//        WebElement element = driver.findElement(By.xpath("//*[@id='droppable']"));
//        Rectangle rect = element.getRect();
//        int x = rect.getX();
//        int y = rect.getY();
//        System.out.println("X koordinatı: " + x);
//        System.out.println("Y koordinatı: " + y);

        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(drag).
                moveByOffset(84,28).//==>belirtmis oldugumuz koordinatlara webelementi tasir
                release().perform();
    }
}
