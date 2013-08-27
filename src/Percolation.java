public class Percolation {

    private int numberOfSites;
    private int[] sites;
    private int height, width;
    private WeightedQuickUnionUF quickUnion;
    
    public Percolation(int N) {
        width = N; 
        height = N;
        numberOfSites = N*N;
        quickUnion = new WeightedQuickUnionUF(numberOfSites+1);
        sites = new int[numberOfSites];
        for (int i = 0; i < sites.length; i++)
        {
            sites[i] = 0; // all sites are closed
        }
        for (int i = 0; i <= width; i++)
        {
//            quickUnion.union(, i);
            quickUnion.union(numberOfSites, sites.length-i);
        }
    }
    
    public void open(int i, int j) {
        if (i > height || i < 1 || j > width || j < 1)
            throw new IndexOutOfBoundsException();

        
        int cellNum = positionNumber(i, j); // get the position number;
        if (sites[cellNum] == 1) return;
        sites[cellNum] = 1;
        
        // this connects the cells above and below
        if (i < height && isOpen(i+1, j)) 
            quickUnion.union(cellNum, cellNum+width); // down
        if (i > 1 && isOpen(i-1, j))  
            quickUnion.union(cellNum, cellNum-width); // up

        // this connects the cells left and right
        if (j > 1 && isOpen(i, j-1)) 
            quickUnion.union(cellNum, cellNum-1);
        if (j < width && isOpen(i, j+1)) 
            quickUnion.union(cellNum, cellNum+1);
    }
    
    private int positionNumber(int i, int j)
    {
        return ((i-1)*width)+j-1; // get the position number;
    }

    public boolean isOpen(int i, int j) 
    {
        if (i > height || i < 1) throw new IndexOutOfBoundsException();
        if (j > width || j < 1) throw new IndexOutOfBoundsException();
        
        int cellNum = positionNumber(i, j); // get the position number;
        return sites[cellNum] == 1;
    }
    
    public boolean isFull(int row, int j) {
        if (row > height || row < 1) throw new IndexOutOfBoundsException();
        if (j > width || row < 1) throw new IndexOutOfBoundsException();

        int toTest = positionNumber(row, j);
        for (int i = 0; i < width; i++)
        {
            if (isOpen(row, j) && quickUnion.connected(i, toTest))
            {
                return true;
            }
        }
        return false;
    }
    
    public boolean percolates() {
        for (int toprow = 0; toprow < width; toprow++)
        {
            if (quickUnion.connected(toprow, numberOfSites)) return true;
        }
        return false;
    }
}
