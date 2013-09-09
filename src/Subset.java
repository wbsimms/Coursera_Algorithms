
public class Subset {

    /**
     * @param args
     */
    public static void main(String[] args) {
        if (args == null || args[0] == null) throw new NullPointerException();
        int toPrint = Integer.parseInt(args[0]);
        RandomizedQueue<String> rndQ = new RandomizedQueue<String>();

        String[] inputs = StdIn.readAllStrings();
        for (String s : inputs)
        {
            rndQ.enqueue(s);
        }
        
        for (int i = 0; i < toPrint; i++)
        {
            System.out.println(rndQ.dequeue());
        }
    }
}
