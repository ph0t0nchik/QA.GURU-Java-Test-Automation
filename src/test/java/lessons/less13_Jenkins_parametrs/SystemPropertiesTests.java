package lessons.less13_Jenkins_parametrs;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {
    @Test
    void systemPropertiesTest1(){
        String browser = System.getProperty("browser");
        System.out.println(browser); //null
    }

    @Test
    void systemPropertiesTest2(){
        System.setProperty("browser", "chrome");
        String browser = System.getProperty("browser");
        System.out.println(browser); //chrome
    }

    @Test
    void systemPropertiesTest3(){
        String browser = System.getProperty("browser", "mozilla");
        System.out.println(browser); //mozilla
    }

    @Test
    void systemPropertiesTest4(){
        System.setProperty("browser", "chrome");
        String browser = System.getProperty("browser", "mozilla");
        System.out.println(browser); //chrome
    }

    @Test
    @Tag("property")
    void systemProperties5Test(){
        String browser = System.getProperty("browser", "mozilla");
        System.out.println(browser); //mozilla

        // gradle property_test -Dbrowser=opera - позволяет устанавливать значения переменной из вне (из дженкинса)
        //opera
    }
}
