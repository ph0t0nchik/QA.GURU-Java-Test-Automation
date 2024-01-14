package lessons.les3_tools_libraries;

import org.junit.jupiter.api.*;

public class ExampleDemoJUnitTest {
    ExampleCalculator calc;
    @BeforeAll
    static void beforAll(){
        System.out.println("#### @BeforeAll");
//        Configuration.browser = "chrome";
    }

    @AfterAll
    static void afterAll(){
        System.out.println("#### @AfterAll");
//        Configuration.browser = "chrome";
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("    #### @BeforeEach");
        calc = new ExampleCalculator();
    }

    @AfterEach
    void afterEach(){
        System.out.println("    #### @AfterEach");
    }

    @Test
    void firstTest() {
        System.out.println("        #### @Test firstTest");
        int result = calc.sum(2, 2);
        Assertions.assertTrue(result == 4);
    }

    @Test
    void secondTest() {
        System.out.println("        #### @Test secondTest");
        int result = calc.mult(2, 2);
        Assertions.assertTrue(result == 4);
    }
}
