import java.io.Console;


public class PercolationStats {

    static double _mean,_stddev,_confidenceLo,_confidenceHi = 0.0;
    Percolation percolation;
    
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
        System.out.println("mean                  = "+_mean);
        System.out.println("stddev                = "+_stddev);
        System.out.println("95% Confidence Level  = "+_confidenceLo+", "+_confidenceHi);
    }
    
    public PercolationStats(int N, int T) {
        percolation = new Percolation(N);
        double[] thresholds = new double[T];
        
        for (int i = 0; i<T;i++)
        {
            int totalSites = N*N;
            int openSites = 0;
            
            percolation = new Percolation(N);
            while (!percolation.percolates())
            {
                openNextPosition(N);
                openSites++;
            }
            thresholds[i] = (double)openSites/totalSites;
        }
        _mean = StdStats.mean(thresholds);
        _stddev = StdStats.stddev(thresholds);
        _confidenceLo = _mean-((1.96*_stddev)/Math.sqrt(T));
        _confidenceHi = _mean+((1.96*_stddev)/Math.sqrt(T));
        
    }
    
    public void openNextPosition(int maxPosition)
    {
        boolean retval = false;
        
        while (!retval)
        {
            int row = StdRandom.uniform(maxPosition)+1;
            int column = StdRandom.uniform(maxPosition)+1;
            if (!percolation.isOpen(row, column))
            {
                percolation.open(row, column);
                return;
            }
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
