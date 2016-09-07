package leet;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-partitioning/
 * @author I301431
 * 2016-08-24
 */
public class PalindromePartitioning {
	List<List<String>> result= new LinkedList<List<String>>();
    public List<List<String>> partition(String s) {
        if(s==null || s.length()==0)
        	return result;
        dp(s,0,0,new LinkedList<String>());
        return result;
        
    }
    
    private void dp(String s,int start,int end,List<String> list)
    {
    	if(end >= s.length())
    		return;
    	String got = s.substring(start, end+1);
    	boolean isPal = isPalindrome(got);
    	if(isPal)
    	{
    		List<String> temp = new LinkedList<String>(list);
    		temp.add(got);
    		if(end == s.length()-1)
    		{
    			result.add(temp);
    			return;
    		}
    		dp(s,end+1,end+1,temp);
    		
    	}
    	//whether it is Palindrome or not, continue searching
    	dp(s,start,end+1,list);
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
    	String s= "aab";
    	System.out.println(s.substring(1, 1).length());
    	
    	
//    	PalindromePartitioning pp = new PalindromePartitioning();
//    	List<List<String>> ret = pp.partition(s);
//    	for(List<String> list:ret)
//    		System.out.println(list.toString());
    }

}
