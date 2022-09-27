package baseTest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    @BeforeAll
    static void setUp() {
        System.out.println("start test");
    }

    @AfterAll
    void tearDown() {
        System.out.println("finish test");
    }
}
