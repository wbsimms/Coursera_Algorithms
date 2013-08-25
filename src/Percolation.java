
public class Percolation {

    int numberOfSites;
    int[] sites;
    int height,width;
    WeightedQuickUnionUF quickUnion;
    
    public Percolation(int N) {
        width = height = N;
        numberOfSites = N^2;
        quickUnion = new WeightedQuickUnionUF(numberOfSites+2);
    }
    
    public void open(int i, int j) {
        if (i > height || i < 1 || j > width || j < 1) throw new IndexOutOfBoundsException();
        int cellNum = positionNumber(i,j); // get the position number;
        
        // this connects the cells above and below
        if (i < height) quickUnion.union(cellNum, cellNum+width);
        if (i > 1)  quickUnion.union(cellNum, cellNum-width);

        // this connects the cells left and right
        if (j > 1) quickUnion.union(cellNum, cellNum-1);
        if (j < width) quickUnion.union(cellNum, cellNum+1);
    }
    
    private int positionNumber(int i, int j)
    {
        return ((i-1)*width)+j; // get the position number;
    }
    
    public boolean isOpen(int i, int j) 
    {
        int cellNum = positionNumber(i,j); // get the position number;
        // this connects the cells above and below
        if (i < height && quickUnion.connected(cellNum, cellNum+width)) {return true;}
        if (i > 1 && quickUnion.connected(cellNum, cellNum-width)) {return true;}

        // this connects the cells left and right
        if (j > 1 && quickUnion.connected(cellNum, cellNum-1)) {return true;}
        if (j < width && quickUnion.connected(cellNum, cellNum+1)) {return true;}
        return false;
    }
    
    public boolean isFull(int i, int j) {
    
        return false;
    }
    
    public boolean percolates() {
        
        return false;
    }
    
}
