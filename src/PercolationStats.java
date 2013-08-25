
public class PercolationStats {

    double _mean,_stddev,_confidenceLo,_confidenceHi = 0.0;
    
    public static void main(String[] args) 
    {
        int gridSize, experimentCount = 0;
        
        try
        {
            gridSize = Integer.decode(args[0]);
            experimentCount = Integer.decode(args[1]);
            if (gridSize <= 0 || experimentCount <= 0)
            {
                throw new IllegalArgumentException("arguments must be greater than zero");
            }
        }
        catch (Exception e)
        {
            throw e;
        }
        PercolationStats s = new PercolationStats(gridSize, experimentCount);
    }
    
    public PercolationStats(int N, int T) {
        for (int i = 0; i<=T;i++)
        {
            Percolation percolation = new Percolation(N);
            boolean retval = percolation.percolates();
        }
        
    }
    
    public double mean(){
        return _mean;
    }
    public double stddev(){
        return _stddev;
    }
    public double confidenceLo(){
        return _confidenceLo;
    }
    public double confidenceHi(){
        return _confidenceHi;
    }
}
