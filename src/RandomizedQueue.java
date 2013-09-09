import java.util.Iterator;


public class RandomizedQueue<Item> implements Iterable<Item> {
    private Deque<Item> deque = null;
    
    public RandomizedQueue() {
        deque = new Deque<Item>();
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }

    public int size() {
        return deque.size();
    }
    
    public void enqueue(Item item) {
        int where = StdRandom.uniform(2);
        if (where == 0) 
            deque.addFirst(item);
        else 
            deque.addLast(item);
    }

    public Item dequeue() {
        return deque.removeFirst();
    }
    public Item sample() {
        Item i = deque.removeFirst();
        deque.addFirst(i);
        return i;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    @Override
    public Iterator<Item> iterator() {
        // TODO Auto-generated method stub
        return deque.iterator();
    }
}
