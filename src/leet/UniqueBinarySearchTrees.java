package leet;

/**
 * https://leetcode.com/problems/unique-binary-search-trees/
 * @author gavin
 * 2017-01-16
 */
public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
    	if(n ==0)
    		return 0;
    	if(n == 1)
    		return 1;
    	
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++)
        {
        	int count = 0;
        	for(int j=0;j<i;j++)
        	{
        		count += dp[j]*dp[i-j-1];
        	}
        	dp[i] = count;
        }
        
        return dp[n];
    }
}
