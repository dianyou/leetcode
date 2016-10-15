package leet;
public class ImplementStr28 {
	/**
	 * https://leetcode.com/problems/implement-strstr/
	 * Gavin
	 * 2016-5-27
	 * @param haystack
	 * @param needle
	 * @return
	 */

	/**
	 * KMP算法
	 * @param haystack
	 * @param needle
	 * @return
	 */
    public int strStr(String haystack, String needle) {

    	if(haystack ==null || needle == null)
    		return -1;
    	if(needle.length() == 0)
    		return 0;
    	int[] next = generateNext(needle);
    	
    	int k=0;
    	
    	for(int i=0;i<haystack.length();i++)
    	{
    		while(k>0 && haystack.charAt(i) != needle.charAt(k))
    		{
    			k = next[k-1];
    		}
    		if(haystack.charAt(i) == needle.charAt(k))
    		{
    			k++;
    		}
    		
    		if(k == needle.length())
    			return i-k+1;
    		
    	}
    	return -1;

    }

    private int[] generateNext(String s)
    {
    	if(s == null || s.length() ==0)
    		return null;
    	int next[] = new int[s.length()]; 
    	next[0] = 0;
    	int k=0; 
    	
    	for(int i=1;i<s.length();i++)
    	{
    		//the key point is the action when s[i] != s[k]
    		//当前无法匹配时，还需向后回溯匹配，找到最长的匹配的以s[0]开始，以s[k]结尾字符串，直至k=0
    		while(k>0 && s.charAt(i) != s.charAt(k))
    		{
    			k = next[k-1];
    		}
    		
    		if(s.charAt(k) == s.charAt(i))
    			k++;
    		next[i] = k;
    	}
    	return next;

    }

    public static void main(String args[])
    {
    	String haystack = "mississippi";
    	String needle = "a";
    	ImplementStr28 test = new ImplementStr28();
    	int results = test.strStr(haystack, needle);
    	int next[] = test.generateNext(needle);
    	for(int i:next)
    		System.out.print(i+",");
    	System.out.println();
    	System.out.println(results);
    }


}
