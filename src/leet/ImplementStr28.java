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
    	int n = haystack.length();
    	int m = needle.length();
    	if( m ==n)
    	{
    		if(needle.equals(haystack))
    			return 0;
    		else
    			return -1;
    	}
    	
    	if(n<m)
    		return -1;
    	if(m==0 ) //needle字符串为空字符串时，返回0
    		return 0;
    	
    	int next[];
    	next = generateNext(needle);
    	if(next ==null)
    		return -1;
    	
    	int p=0; //标识needle匹�?的�?置
    //	int i=0; //标识haystack的�?置
    	for(int i=0;i<n;i++)
    	{
    		if(needle.charAt(p)==haystack.charAt(i))
    		{
    			p++;
//    			System.out.println("p::"+ (p-1));
//    			System.out.println("i::"+i);
	    		if( p ==m )
	    		{

	    			return i+1-m; //由于此时循环还没结�?�，因此i值需�?+1
	    		}
    		}
    		else
    		{
    			if(p>0) //如果已�?有匹�?的字符，则当�?未命中字符需�?�?新比较
        			i--;
    			if(p>0)
    				p = next[p-1];
    			else
    				p=0;
    			
//    			System.out.println("new p::"+p);
//    			System.out.println("new i::"+i);
    		}
    		
    	}
    	return -1;
        
    }
    /**
     * 生�?next数组，第一个元素值为0
     * 当�?��?置对应一个next值，�?次移动字符串时，移动长度为 s.length()-next[p]
     * p为当次匹�?到的�?置
     * @param s
     * @return
     */
    private int[] generateNext(String s)
    {
    	if(s == null || s.length() ==0)
    		return null;
    	int next[] = new int[s.length()]; //next数组从0开始
    	next[0] = 0;
    	if(s.length()==1)
    		return next;
    	int p=1; //匹�?的�?缀字符串的长度
    	
    	for(int i=1;i<s.length();i++)
    	{
    		if(s.charAt(i) == s.charAt(p-1))
    		{
    			next[i] = p;	
    			p++;
    			
    		}
    		else
    		{
    			next[i] = 0;
    			p = 1;
    		}
    			
    	}
    	
    	return next;
    }
    
    public static void main(String args[])
    {
    	String haystack = "mississippi";
    	String needle = "issip";
    	ImplementStr28 test = new ImplementStr28();
  //  	int results = test.strStr(haystack, needle);
    	int next[] = test.generateNext(needle);
    	for(int i:next)
    		System.out.print(i+",");
    	System.out.println();
    }
    

}
