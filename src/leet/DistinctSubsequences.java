package leet;

public class DistinctSubsequences {
	
	public int numDistinct(String s,String t)
	{
        if(s == null || t == null)
        	return 0;
        if(s.length() < t.length())
        	return 0;
        
        int[][] dp = new int[s.length()+1][t.length()+1];

        for(int i=0;i<s.length();i++)
        {
        	dp[i][0] = 1;
        }
        
        for(int i=1;i<=s.length();i++)
        	for(int j=1;j<=t.length();j++)
        	{
        		if(s.charAt(i-1) == t.charAt(j-1))
        			dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
        		else
        			dp[i][j] = dp[i-1][j];
        	}
        
        return dp[s.length()][t.length()];
        
        
	}
	
	
	//TTL
    public int numDistinctTTL(String s, String t) {
        if(s == null || t == null)
        	return 0;
        if(s.length() < t.length())
        	return 0;
        
        return numsCal(s,t,0,0);
    }
    
    private int numsCal(String s,String t,int positionS,int positionT)
    {
    	  int nums = 0;
          char header = t.charAt(positionT);
          if(positionT == t.length()-1)
          {
        	  for(int i = positionS;i<s.length();i++)
        	  {
        		  if(s.charAt(i) == header)
        			  nums += 1;
        	  }
          }
          else
          {
              for(int i = positionS;i<s.length();i++)
              {
            	  if(s.charAt(i) == header )
            	  {
            		  int k = numsCal(s,t,i+1,positionT+1); 
            		 nums += k;
            	  }
              }
          }
          return nums;
    }
    public static void main(String args[])
    {
    	DistinctSubsequences ds = new DistinctSubsequences();
    	String s = "ddd";
    	String t = "dd";
    	int result = ds.numDistinct(s,t);
    	System.out.println(result);
    }
}
