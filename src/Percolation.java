
public class Percolation {

    int numberOfSites;
    int[] sites;
    int height,width;
    WeightedQuickUnionUF quickUnion;
    
    public Percolation(int N) {
        width = height = N;
        numberOfSites = N^2;
        quickUnion = new WeightedQuickUnionUF(numberOfSites+2);
        sites = new int[numberOfSites];
        for (int i = 0; i<= sites.length; i++)
        {
            sites[i] = 0; // all sites are closed
        }
        for(int i = 0; i<=width; i++)
        {
            quickUnion.union(0, i);
            quickUnion.union(sites.length, sites.length-i);
        }
    }
    
    public void open(int i, int j) {
        if (i > height || i < 1 || j > width || j < 1) throw new IndexOutOfBoundsException();

        
        int cellNum = positionNumber(i,j); // get the position number;
        if (sites[cellNum] == 1) return;
        sites[cellNum] = 1;
        
        // this connects the cells above and below
        if (i < height && isOpen(i+1,j)) quickUnion.union(cellNum, cellNum+width); // down
        if (i > 1 && isOpen(i-1,j))  quickUnion.union(cellNum, cellNum-width); // up

        // this connects the cells left and right
        if (j > 1 && isOpen(i,j-1)) quickUnion.union(cellNum, cellNum-1);
        if (j < width && isOpen(i,j+1)) quickUnion.union(cellNum, cellNum+1);
    }
    
    private int positionNumber(int i, int j)
    {
        return ((i-1)*width)+j; // get the position number;
    }

    public boolean isOpen(int i, int j) 
    {
        int cellNum = positionNumber(i,j); // get the position number;
        return sites[cellNum] == 1;
    }
    
    public boolean isFull(int i, int j) {
        int toTest = positionNumber(i,j);
        return quickUnion.connected(0, toTest);
    }
    
    public boolean percolates() {
        return quickUnion.connected(0, sites.length);
    }
    
}
