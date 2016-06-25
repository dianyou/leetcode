package leet;


public class ShortestPalindrome
{
  public String shortestPalindrome(String s)
  {
	  if(s==null||s.length()<2)
	        return s;
      int longestCommon = generateNext(s);
      
      StringBuilder res = new StringBuilder(s.substring(longestCommon)).reverse();
      res.append(s);
      return res.toString();
  }

  private int generateNext(String s)
  {
    StringBuilder revS = new StringBuilder(s).reverse();
    StringBuilder mergeS = new StringBuilder(s).append("#").append(revS.toString());
   
    int next[] = new int[mergeS.length()];
    next[0] = 0;
    int p=0;  //common length
    for(int i=1;i<mergeS.length();i++)
    {
    //	int p=next[i-1];
    	//KMP算法，最关键的一步是在字符不匹配时的处理方法！
        while(p>0&& mergeS.charAt(i)!= mergeS.charAt(p))
        	p = next[p-1];
    	if(p==0)
    	{
    		if(mergeS.charAt(i)==mergeS.charAt(p))
    			p++;
    	}
    	else
    		p++;
    	next[i] = p;
     //   System.out.println("next::"+next[i]);
    }
	   return next[mergeS.length()-1];
   }

  /**
    超时了，之所以超时，还是因为有冗余的重复劳动
  **/
  public String shortestPalindrome2(String s) {
    if(s==null||s.length()<2)
      return s;
    StringBuilder sb = new StringBuilder(s);
    String reverS = sb.reverse().toString();
  //  System.out.println(reverS);
    char[] cs = s.toCharArray();
    char[] cs_reverse = reverS.toCharArray();
    for(int i=0;i<s.length();i++) //reverse string
    {
      int start =i;
      for(int j=0;j<s.length()&& start<s.length();j++)
      {
    	  if(cs_reverse[start] != cs[j])
          break;
        start++;
      }
      if(start==s.length())
      {
        return reverS.substring(0,i)+s;
      }
    }
    return s;
  }
  public static void main(String args[])
  {
	  ShortestPalindrome test = new ShortestPalindrome();
	  String s = test.shortestPalindrome("aba");
	  //"abbaabba"
	  System.out.println(s);
  }
}
