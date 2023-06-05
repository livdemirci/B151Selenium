package techproed.day07_MavenJunit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C02_BeforeAfter {

    @After
    public void tearDown() {
        /*
            Notasyonlara sahip method'lar olusturabilmek icin mause+sag click+generate
            after methodu icin teardown'i seceriz
            before methodu icin setup'i seceriz
            test methodu icin de test'i seceriz.

            Junit frameworkunde teslerimizi siralama yapabilmek icin ekstra bir notasyon yoktur
            Eger belli bir siralamada calistirmak istersek method isimlerini alfabetik ve sayisal olarak belirtmemiz gerekir.
         */
        System.out.println("After Her test methodundan sonra bir kez calisir");

    }

    @Before
    public void setUp() {
        System.out.println("Before Her test methodundan once bir kez calisir");
    }

    @Test
    public void test1() {
        System.out.println("Test1 methodu calisti");
    }

    @Test
    public void test2() {
        System.out.println("Test2 methodu calisti");
    }

    @Test
    public void test3() {
        System.out.println("Test3 methodu calisti");
    }
}
