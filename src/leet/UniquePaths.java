package leet;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if(m<1 || n<1)
        	return 0;
       
        return dfs(0,0,m,n);
    }

    private int dfs(int i,int j,int m, int n)
    {
    	if(i == m-1 && j == n-1)
    	{
    		return 1;
    	}
    	int path1 =0, path2 = 0;
    	if(i<m-1)
    		path1 = dfs(i+1,j,m,n);
    	if(j<n-1)
    		path2 = dfs(i,j+1,m,n);
    	return path1 +  path2;
    }
    
    public static void main(String args[])
    {
    	UniquePaths test = new UniquePaths();
    	System.out.println(test.uniquePaths(23, 12));
    }
}
