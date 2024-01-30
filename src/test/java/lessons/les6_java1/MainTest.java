package lessons.les6_java1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {
    @Test
    void sum(){
        int sum = new Main().sum(2,3);
        Assertions.assertTrue(sum == 5);
    }
}
