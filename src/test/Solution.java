package test;

public class Solution {
	public String shortestPalindrome(String s) {
	    StringBuilder builder = new StringBuilder(s);
	    return builder.reverse().substring(0, s.length() - getCommonLength(s)) + s;
	}

	private int getCommonLength(String str) {
	    StringBuilder builder = new StringBuilder(str);
	    String rev = new StringBuilder(str).reverse().toString();
	    builder.append("#").append(rev);
	    int[] p = new int[builder.length()];
	    for (int i = 1; i < p.length; i++) {
	        int j = p[i - 1];
	        while (j > 0 && builder.charAt(i) != builder.charAt(j)) 
	        	j = p[j - 1];
	        if(j==0)
	        {
	        	if(builder.charAt(i)==builder.charAt(0))
	        		p[i] =1;
	        	else
	        		p[i] =0;
	        }
	        else
	        	p[i] = j+1;
	        //p[i] = j == 0 ? (builder.charAt(i) == builder.charAt(0) ? 1 : 0) : j + 1;
	    }
	    for(int i=0;i<p.length;i++)
	    {
	    	System.out.println(p[i]);
	    }
	    return p[p.length - 1];
	}
	public static void main(String args[])
	{
//		Solution test = new Solution();
//		test.shortestPalindrome("aacecaaa");
		String path = "/C:/dev/tomcat/apache-tomcat-8.0.36/wtpwebapps/gavin/WEB-INF/classes/";
		path = path.substring(0, path.lastIndexOf("/WEB-INF/"));	
		System.out.println(path);
		System.out.println(path.indexOf("/C:"));
	}
}
