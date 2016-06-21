package leet;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
/**
 * 
 * @author Gavin
 * 2016-06-19
 *https://leetcode.com/problems/word-break-ii/
 */
public class WordBreakII
{
	/**
	 * 暴力�?�索方法，超时
	 * 继承自wordBreak的�?想，首先判断哪些点�?�以break，�?�??历一�??
	 * @param s
	 * @param wordDict
	 * @return
	 */
  public List<String> wordBreak(String s,Set<String> wordDict)
  {
    List<String> res = new LinkedList<String>();
    if(s==null || s.length() ==0)
      return res;
    if(wordDict == null || wordDict.size() ==0)
      return res;
    int len = s.length();
    boolean memo[] = new boolean[len];
    memo[0] = wordDict.contains(s.substring(0,1));
    for(int i=0;i<len;i++)
    {
    	if(wordDict.contains(s.substring(0,i+1)))
    		memo[i] = true;
    	else
    	{
    	  for(int j=0;j<=i;j++)
   	      {
   	    	  if(j==0)
   	    		  continue;
   	    	  if(memo[j-1] && wordDict.contains(s.substring(j,i+1)))
   	    	  {
   	    		  memo[i]= true;
   	    		  break;
   	    	  }
   	    		  
   	      }
    	}
	     
    }
//    System.out.println(len);
//    for(int i=0;i<len;i++)
//    	System.out.println(memo[i]);
    if(memo[len-1])
    {
        newBreakWords(len-1,s,wordDict,"",res,memo);
    }
    return res;
  }

  private void newBreakWords(int end,String s,Set<String> wordDict,String words,List<String> res,boolean[] memo)
  {
	  if(end ==0)
	  {
		  res.add((s.substring(0,1)+" "+words).trim());
		  return;
	  }
	  if(wordDict.contains(s.substring(0, end+1)))
	  {
		  res.add((s.substring(0, end+1)+" "+words).trim());
	  }
	  for(int i=end;i>0;i--)
	  {
		  if(wordDict.contains(s.substring(i,end+1)) && memo[i-1])
	    	{
			  String temp = s.substring(i,end+1) + " " +words;
	    		newBreakWords(i-1,s,wordDict,temp,res,memo);
	    	}
	  }
  }
  private void breakWords(int start,String s,Set<String> wordDict,String words,List<String> res)
  {
    if(start == s.length())
    {
          res.add(words);
          return;
    }
    for(int i=start;i<s.length();i++)
    {
      if(wordDict.contains(s.substring(start,i+1)))
      {
        String temp = words+" "+s.substring(start,i+1);
        breakWords(i+1,s,wordDict,temp,res);
      }
    }
  }
  public static void main(String args[])
  {
	  String s ="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
	  WordBreakII test = new WordBreakII();
	  String words[] =  {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
	  Set<String> wordDict = new HashSet<String>();
	  for(int i=0;i<words.length;i++)
		  wordDict.add(words[i]);
	  List<String> res = test.wordBreak(s, wordDict);
	  System.out.println(res.toString());
  }


}
