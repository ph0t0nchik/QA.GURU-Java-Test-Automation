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
    void systemPropertiesTest5(){
        String browser = System.getProperty("browser", "mozilla");
        System.out.println(browser); //не хочет выводить в терминал через команду в терминале
    }
}
