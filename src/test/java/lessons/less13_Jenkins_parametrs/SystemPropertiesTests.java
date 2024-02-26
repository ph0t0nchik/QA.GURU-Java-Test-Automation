package lessons.less13_Jenkins_parametrs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static java.lang.String.format;

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

    @Test
    @DisplayName("имя теста")
    @Tag("hello")
    void systemProperties6Test(){
        String name = System.getProperty("name", "default student");
        String message = format("Hello, %s!", name);
        System.out.println(message);

        // gradle hello_test
        // Hello, default student!

        // gradle hello_test -Dname=Alex Maximov
        // Task 'Maximov' not found in root project 'QA.GURU-Java-Test-Automation'

        // gradle hello_test -Dname="Alex Maximov"
        // gradle hello_test "-Dname=Alex Maximov"
        // Hello, Alex Maximov!


    }
}
