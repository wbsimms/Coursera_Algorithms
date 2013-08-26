public class PercolationStats {

    private double mean, stddev, confidenceLo, confidenceHi;
    private Percolation percolation;
    
    public PercolationStats(int N, int T) {
        percolation = new Percolation(N);
        double[] thresholds = new double[T];
        
        for (int i = 0; i < T; i++)
        {
            int totalSites = N*N;
            int openSites = 0;
            
            percolation = new Percolation(N);
            while (!percolation.percolates())
            {
                openNextPosition(N);
                openSites++;
            }
            thresholds[i] = (double) openSites/totalSites;
        }
        mean = StdStats.mean(thresholds);
        stddev = StdStats.stddev(thresholds);
        confidenceLo = mean-((1.96*stddev)/Math.sqrt(T));
        confidenceHi = mean+((1.96*stddev)/Math.sqrt(T));
        
        System.out.println("mean                  = "+mean);
        System.out.println("stddev                = "+stddev);
        System.out.println("95% Confidence Level  = "
            +confidenceLo
            +", "
            +confidenceHi);
    }
    
    private void openNextPosition(int maxPosition)
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
    
    public double mean() {
        return mean;
    }
    public double stddev() {
        return stddev;
    }
    public double confidenceLo() {
        return confidenceLo;
    }
    public double confidenceHi() {
        return confidenceHi;
    }
    
    public static void main(String[] args) 
    {
        int gridSize, experimentCount = 0;
        
        try
        {
            gridSize = Integer.decode(args[0]);
            experimentCount = Integer.decode(args[1]);
            if (gridSize <= 0 || experimentCount <= 0)
            {
                throw new IllegalArgumentException("arguments must be > zero");
            }
        }
        catch (NumberFormatException e)
        {
            throw e;
        }
        new PercolationStats(gridSize, experimentCount);
    }
}
