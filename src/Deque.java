import java.util.Iterator;


public class Deque<Item> implements Iterable<Item> {

    private Node<Item> firstNode = null;
    private Node<Item> lastNode = null;
    private int nodeCount = 0;
    
    public Deque() {
    }

    public boolean isEmpty() {
        return nodeCount == 0;
    }

    public int size() {
        return nodeCount;
    }
    
    public void addFirst(Item item) {
        if (firstNode == null) {
            firstNode = new Node<Item>();
            firstNode.item = item;
            lastNode = firstNode;
        }
        else
        {
            Node<Item> temp = firstNode;
            Node<Item> newNode = new Node<Item>();
            newNode.item = item;
            newNode.node = temp;
            firstNode = newNode;
        }
        nodeCount++;
    }
    
    public void addLast(Item item) {
        if (firstNode == null) {
            firstNode = new Node<Item>();
            firstNode.item = item;
            lastNode = firstNode;
        }
        else {
            Node<Item> temp = lastNode;
            Node<Item> newNode = new Node<Item>();
            newNode.item = item;
            temp.node = newNode;
            lastNode = newNode;
        }
        nodeCount++;
    }

    public Item removeFirst() {
        return (Item) new Object();
        
    }

    public Item removeLast() {
        return (Item) new Object();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    class Node<NodeItem>
    {
        public NodeItem item;
        public Node<NodeItem> node;
    }

}


