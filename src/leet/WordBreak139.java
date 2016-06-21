package leet;
import java.util.HashSet;
import java.util.Set;

public class WordBreak139 {
	/**
	 * 使用DP，如果这个词可以被切割，肯定是以一个单词开始，因此每次循环在命中一个词之后就直接退出循环
	 * @param s
	 * @param wordDict
	 * @return
	 */
	
    public boolean wordBreak(String s, Set<String> wordDict) {
        int len = s.length();
        boolean[] arrays = new boolean[len+1];
        arrays[0] = true;
        for (int i = 1; i <= len; ++i){
          for (int j = 0; j < i; ++j){
            if (arrays[j] && wordDict.contains(s.substring(j, i))){
              // f(n) = f(0,i) + f(i,j) + f(j,n)
              arrays[i] = true;
              break;
            }
          }
        }
        return arrays[len];
    }
    
    /**
     * 超时版本，递归
     * @param s
     * @param wordDict
     * @return
     */
    
    
    public boolean wordBreak2(String s, Set<String> wordDict) {
    	boolean[] memo = new boolean[s.length()];
    	return getWord(s,0,wordDict,memo);
    	
    }
    
    public boolean getWord(String s,int pos,Set<String> wordDict,boolean[] memo)
    {
    	if(wordDict.contains(s.substring(pos)))
    	{
    		memo[s.length()-1] = true;
    		return true;
    	}
    	int len = s.length();
    	
    	//i从pos开始
    	for(int i=pos+1;i<=len;i++)
    	{
    		boolean flag = false;
    		if(wordDict.contains(s.substring(pos,i)))
    		{
    			memo[i-1] = true;
   				flag = getWord(s,i,wordDict,memo);
    		}
    		if(flag == true)
    			return true;
    		
    	}
        return false;
    	
    }
    
    public static void main(String[] args)
    {
    	String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
//    	String s = "leetcode";
//    	System.out.println(s.substring(0,3));
//    	System.out.println(s.substring(3));
//    	
    	
    	Set<String> wordDict = new HashSet<String>();
    	wordDict.add("a");
    	wordDict.add("aa");
    	wordDict.add("aaa");
    	wordDict.add("aaaa");
    	wordDict.add("aaaaa");
    	wordDict.add("aaaaaa");
    	wordDict.add("aaaaaaa");
    	wordDict.add("aaaaaaaa");
    	wordDict.add("aaaaaaaaa");
    	wordDict.add("aaaaaaaaaa");
    	//System.out.println(set.toString());
    //	System.out.println(s.substring(s.length()-1,s.length()));
    	WordBreak139 test = new WordBreak139();
    	System.out.println(test.wordBreak(s, wordDict));
    }

}
