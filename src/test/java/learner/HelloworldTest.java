package learner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloworldTest {

    @Test
    public void testGetMsg() {
        Helloworld hw = new Helloworld();
        String expectedMessage = "Hello world! How does IDEA and github work?";
        assertEquals(expectedMessage, hw.getMsg());
    }
}
