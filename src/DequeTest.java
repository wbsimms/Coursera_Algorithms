import static org.junit.Assert.*;

import org.junit.Test;


public class DequeTest {

    @Test
    public void test() {
        Deque<String> cut = new Deque<String>();
        cut.addFirst("testingFirst");
        cut.addFirst("StringFirstFirst");
    }

}
