package leet;

/**
 * https://leetcode.com/problems/palindrome-partitioning-ii/
 * @author I301431
 * 2016-09-07
 */
public class PalindromePartitioningII {
	
	//merge the two for loop
    public int minCut(String s) {
        if(s==null || s.length() ==0)
        	return 0;
        int[][] memo = new int[s.length()][s.length()]; 
        int[] cnt = new int[s.length()+1];
        //initialize memo, just judge P(i,j) is palindrome or not
        //and dp from end
        for(int i=s.length()-1;i>=0;i--)  
        {  
        	cnt[i]=s.length();
            for(int j=i;j<s.length();j++)  
            {  
            	//P(i-1,j+1) is palindrome when P(i,j) is palindrome and  s[i-1]==s[j+1]
                if(s.charAt(i)==s.charAt(j)&&(j-i<2||memo[i+1][j-1]==1))  
                {  
                    memo[i][j]=1; 
                    cnt[i] = Math.min(1+cnt[j+1], cnt[i]);
                }  
            }  
        }  
        
        return cnt[0]-1;
    }
	
    public int minCutII(String s) {
        if(s==null || s.length() ==0)
        	return 0;
        int[][] memo = new int[s.length()][s.length()]; 
       
        //initialize memo, just judge P(i,j) is palindrome or not
        for(int i=s.length()-1;i>=0;i--)  
        {  
            for(int j=i;j<s.length();j++)  
            {  
            	//P(i-1,j+1) is palindrome when P(i,j) is palindrome and  s[i-1]==s[j+1]
                if(s.charAt(i)==s.charAt(j)&&(j-i<2||memo[i+1][j-1]==1))  
                {  
                    memo[i][j]=1;  
                }  
            }  
        }  
        int[] cnt = new int[s.length()+1];
        //dp from end
        for(int i=s.length()-1;i>=0;i--)
        {
        	cnt[i]=s.length();
        	for(int j=i;j<s.length();j++)
        	{
        		if(memo[i][j]==1)
        			cnt[i] = Math.min(1+cnt[j+1], cnt[i]);
        	}
        	
        }
        return cnt[0]-1;
    }
    
    private int minCut;
    public int minCutI(String s) {
        if(s==null || s.length() ==0)
        	return 0;
        minCut = Integer.MAX_VALUE;
        int[][] memo = new int[s.length()][s.length()]; 
        int[][] cnt = new int[s.length()+1][s.length()+1];
        //initialize memo, just judge P(i,j) is palindrome or not
        for(int i=s.length()-1;i>=0;i--)  
        {  
            for(int j=i;j<s.length();j++)  
            {  
            	//P(i-1,j+1) is palindrome when P(i,j) is palindrome and  s[i-1]==s[j+1]
                if(s.charAt(i)==s.charAt(j)&&(j-i<2||memo[i+1][j-1]==1))  
                {  
                    memo[i][j]=1;  
                }  
            }  
        }  
        dfs(0,0,s.length(),memo,cnt);
        return minCut-1;
    }
    
    private void dfs(int startX,int steps,int len,int[][] memo,int[][] cnt)  
    {  
    	//avoid double calculation
        if(cnt[startX][steps]==1) return;  
          
        if(startX==len)  
        {  
            if(steps<minCut)  
            {  
            	minCut=steps;  
            }  
            return;  
        }  
          
        cnt[startX][steps]=1;  
          
        for(int j=len-1;j>=startX;j--)  
        {  
            if(memo[startX][j]==1&&steps<minCut)  
            {  
                dfs(j+1,steps+1,len,memo,cnt);  
            }  
        }  
    }     
    
    /**
     * P(i-1,j+1) is palindrome when P(i,j) is palindrome and  s[i-1]==s[j+1]
     * @param s
     * @return
     */
    private boolean isPalindrome(String s)
    {
    	int left=0,right = s.length()-1; 
    	while(left < right)
    	{
    		if(s.charAt(left) != s.charAt(right))
    			return false;
    		left++;
    		right--;
    	}
    	return true;
    }
    
    public static void main(String args[])
    {
    	PalindromePartitioningII pdpII = new PalindromePartitioningII();
    	String s = "abba";
    	System.out.println(pdpII.isPalindrome(s));
    	int min = pdpII.minCut(s);
    	System.out.println(min);
    }
}
