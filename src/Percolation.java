import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;


public class Percolation {

    int numberOfSites;
    int[] sites;
    int height,width;
    WeightedQuickUnionUF quickUnion;
    
    public Percolation(int N) {
        width = height = N;
        numberOfSites = N*N;
        quickUnion = new WeightedQuickUnionUF(numberOfSites);
        sites = new int[numberOfSites];
        for (int i = 0; i< sites.length; i++)
        {
            sites[i] = 0; // all sites are closed
        }
//        for(int i = 0; i<=width; i++)
//        {
//            quickUnion.union(0, i);
//            quickUnion.union(sites.length, sites.length-i);
//        }
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
        return ((i-1)*width)+j-1; // get the position number;
    }

    public boolean isOpen(int i, int j) 
    {
        int cellNum = positionNumber(i,j); // get the position number;
        return sites[cellNum] == 1;
    }
    
    public boolean isFull(int row, int j) {
        int toTest = positionNumber(row,j);
        for (int i = 0; i<width; i++)
        {
            if (isOpen(row,j) && quickUnion.connected(i, toTest))
            {
                return true;
            }
        }
        return false;
    }
    
    public boolean percolates() {
        for (int bottomrow = sites.length-width; bottomrow < sites.length; bottomrow++)
        {
            for (int toprow = 0; toprow < width; toprow++)
            {
                if (quickUnion.connected(toprow, bottomrow)) return true;
            }
        }
        return false;
    }
}
