package leet;

public class LongestPalindromicSubstring {
	
	//dp
    public String longestPalindromeDP(String s) {
        if(s == null || s.length() ==0)
        	return s;
        int len = s.length();
        int[][] dp = new int[len][len];
        int max =0;
        int pStart = 0;
        
        //i: Palindrome length-1
        for(int i=0;i<=len;i++)
        {
        	for(int j=0;j<len-i;j++)
        	{
        		char c1 = s.charAt(j);
        		char c2 = s.charAt(j+i);
        		
        		if((c1 == c2) && (i<2 ||dp[j+1][j+i-1]>0))
        		{
        			dp[j][j+i] = 1;
        			if(i > max)
        			{
        				max = i;
        				pStart = j;
        			}
        		}
        	}
        }
        return s.substring(pStart, pStart+max+1);
    }
    
    //based on the number or two numbers, whether it's palindrom or not
    public String longestPalindrome(String s) {
        if(s == null || s.length() ==0)
        	return s;
        int len = s.length();
        int max =1;
        int pStart = 0;
        for(int i=1;i<len;i++)
        {
        	int l=i-1,r= i+1;
        	//odd
        	while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r))
        	{
        		l--;
        		r++;
        	}
        	
        	//r-l+1-2
    		int k = r-l-1;
    		if(k > max)
    		{
    			max = k;
    			pStart = l+1;
    		}
        	
        	l=i-1;
        	r=i;
        	//even
        	while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r))
        	{
        		l--;
        		r++;
        	}
        	
    		k = r-l-1;
    		if(k > max)
    		{
    			max = k;
    			pStart = l+1;
    		}
        	
        }
    	return s.substring(pStart, pStart+max);
    }
    
    //Manacher
    //explaination: https://segmentfault.com/a/1190000003914228
    public String longestPalindromeM(String s) {
        if(s == null || s.length() ==0)
        	return s;
        
        //pre process string
        StringBuilder sb = new StringBuilder("$");
        for(int i=0;i<s.length();i++)
        {
        	sb.append("#");
        	sb.append(s.charAt(i));
        }
    	sb.append("#");
    	sb.append("^");
    	
    	int pos=0, maxRight=0;
    	int[] p =new int[sb.length()];
    	
    	for(int i=1;i<sb.length()-1;i++)
    	{
    		if(i<maxRight)
    		{
    			//find the symmetrical point
    			p[i] = Math.min(p[2*pos - i],maxRight-i);
    		}
    		else
    		{
    			p[i] = 1;
    		}
    		
    		while(sb.charAt(i+p[i]) == sb.charAt(i-p[i])) //? why not handle the boundary
    			p[i]++;
    		
    		if(i+p[i] > maxRight)
    		{
    			maxRight = i+p[i];
    			pos = i;
    		}
    	}
    	
        int max =1;
        int pStart = 0;
    	
        for(int i=1;i<sb.length()-1;i++)
        	if(p[i]>max)
        	{
        		max = p[i];
        		pStart = i;
        	}
        return s.substring((pStart-max)/2,(pStart-max)/2 + max-1);	
    	
    }
    
    
    public boolean isPalindrome(String s)
    {
    	int l=0,r=s.length()-1;
    	while(l<r)
    	{
    		if(s.charAt(l) != s.charAt(r))
    			return false;
    		l++;
    		r--;
    	}
    	return true;
    }
    
    public static void main(String args[])
    {
    	String s = "bb";
    	LongestPalindromicSubstring test = new LongestPalindromicSubstring();
    	String result = test.longestPalindrome(s);
    	System.out.println(result);
    }
}
