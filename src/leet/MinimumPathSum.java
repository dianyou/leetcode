package leet;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0||
        		grid[0].length == 0)
        	return 0;
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dp = new int[m][n];
        
        int paths = 0;
        for(int i=0;i<m;i++)
        {
        	paths = paths + grid[i][0];
        	dp[i][0] = paths;
        }
        paths =0;
        for(int j=0;j<n;j++)
        {
        	paths = paths + grid[0][j];
        	dp[0][j] = paths;
        }
        
        for(int i=1;i<m;i++)
        	for(int j=1;j<n;j++)
        	{
        		dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
        	}
        return dp[m-1][n-1];
    }
}
