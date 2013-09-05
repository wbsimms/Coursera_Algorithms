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
            newNode.next = temp;
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
            temp.next = newNode;
            lastNode = newNode;
        }
        nodeCount++;
    }

    public Item removeFirst() {
        Node<Item> first = firstNode;
        firstNode = first.next;
        Item i = first.item;
        first = null;
        return i;
    }

    public Item removeLast() {
        Node<Item> last = lastNode;
        Node<Item> nextToLast = findNextToLastNode(firstNode);
        Item i = last.item;
        nextToLast.next = last = null;
        lastNode = nextToLast;
        return i;
    }
    
    public Node<Item> getFirstNode()
    {
        return this.firstNode;
    }
    
    private Node<Item> findNextToLastNode(Node<Item> node)
    {
        if (node.next.next == null) return node;
        return findNextToLastNode(node.next);
   }

    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator<Item>();
    }

    
    class DequeIterator<IItem> implements Iterator<IItem> {

        private Node<IItem> currentNode = (Node<IItem>) firstNode;
        
        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public IItem next() {
            Node<IItem> temp = currentNode;
            currentNode = currentNode.next;
            return temp.item;
        }

        @Override
        public void remove() {
       }
    
    }

    class Node<NodeItem>
    {
        public NodeItem item;
        public Node<NodeItem> next;
    }

}



