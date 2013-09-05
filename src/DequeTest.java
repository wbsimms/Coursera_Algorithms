import static org.junit.Assert.*;

import org.junit.Test;


public class DequeTest {

    @Test
    public void addFirstTest() {
        Deque<String> cut = new Deque<String>();
        assertTrue(cut.isEmpty());
        assertEquals(0, cut.size());
        cut.addFirst("testingFirst");
        cut.addFirst("StringFirstFirst");
        assertEquals(2, cut.size());
        for (String s : cut)
        {
            System.out.println(s);
        }
    }

    @Test
    public void addLastTest() {
        Deque<String> cut = new Deque<String>();
        assertTrue(cut.isEmpty());
        assertEquals(0, cut.size());
        cut.addLast("testingFirst");
        cut.addLast("StringFirstFirst");
        assertEquals(2, cut.size());
        for (String s : cut)
        {
            System.out.println(s);
        }
    }

    @Test
    public void iterationsTest() {
        Deque<String> cut = new Deque<String>();
        assertTrue(cut.isEmpty());
        assertEquals(0, cut.size());
        cut.addLast("testingFirst");
        cut.addLast("StringFirstFirst");
        for (String s : cut)
        {
            System.out.println(s);
        }
    }

    @Test
    public void removeLastTest() {
        Deque<String> cut = new Deque<String>();
        assertTrue(cut.isEmpty());
        assertEquals(0, cut.size());
        cut.addLast("testingFirst");
        cut.addLast("StringFirstFirst");
        cut.addFirst("String");
        for (String s : cut)
        {
            System.out.println(s);
        }
        System.out.println("==================");
        String retval = cut.removeLast();
        assertEquals("StringFirstFirst", retval);
        System.out.println("==================");
        for (String s : cut)
        {
            System.out.println(s);
        }
        assertTrue(cut.size() == 2);
        
    }

    
//    @Test
//    public void findLastNodeTest() {
//        Deque<String> cut = new Deque<String>();
//        assertTrue(cut.isEmpty());
//        assertEquals(0, cut.size());
//        cut.addFirst("testingFirst");
//        cut.addFirst("StringFirstFirst");
//        cut.addFirst("StringFirstFirstFirst");
//        Node<String> lastnode = cut.findNextToLastNode(cut.getFirstNode());
//        System.out.println(lastnode.item);
//    }

}
