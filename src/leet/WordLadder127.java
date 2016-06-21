package leet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder127 {
	
	/**
	 * https://leetcode.com/problems/word-ladder/
	 * 超时了，修改策略：�?需�?和所有�?��?对比，�?�需�?更改字符，然�?��?�匹�?，�?�?�度是 （26*wordlength）
	 * @param beginWord
	 * @param endWord
	 * @param wordList
	 * @return
	 * 2016-5-24
	 * Gavin
	 */
    public int ladderLength2(String beginWord, String endWord, Set<String> wordList) {
    	int counter = 1;
    	Set<String> matchedSet = new HashSet<String>();
    	matchedSet.add(beginWord);
    	
    	while(matchedSet.size()>0)
    	{
    		counter++;
    		Set<String> temp = new HashSet<String>();
    		Set<String> leftSet = new HashSet<>();
    		for(String s1: matchedSet)
    		{
    			for(String s2: wordList)
    			{
	    			if(oneDiff(s1,s2))
	    			{
		    			if(s2.equals(endWord))
		    				return counter;
	    				temp.add(s2);
	    			}
	    			else
	    			{
	    				leftSet.add(s2);
	    			}
    			}
    		}
    		if(temp.size() == 0 || leftSet.size()==0)
    			return 0;
    		else
    		{
    			matchedSet =  new HashSet<String>(temp);
    			wordList =  new HashSet<String>(leftSet);
    		}
    	}
    	return counter;
    }
    
    private boolean oneDiff(String s1,String s2)
    {
    	int count = 0;
    	if(s1.length() != s2.length())
    		return false;
    	else
    	{
    		for(int i=0;i<s1.length();i++)
    		{
    			if(s1.charAt(i)!= s2.charAt(i))
    			{
    				count++;
    			}
    			if(count>1)
    				return false;
    		}
    	}
    	if(count !=1)
    		return false;
    	return true;
    }
    
    /**
     * 优化方法：自�?�字�?，从'a'到'z'
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (beginWord == null || endWord == null || beginWord.equals(endWord)  
                || beginWord.length() != endWord.length() ||beginWord.length() ==0)  
            return 0; 
    	
    	Queue<String> match = new LinkedList<String>();
    	Map<String,Integer> level = new HashMap<String,Integer>();//记录�?个�?��?�的层数
    	Set<String> wordSet = new HashSet<>(wordList);
    	if(wordSet.contains(beginWord))//剔除原集�?�中有首元素的情况
    	{
    		wordSet.remove(beginWord);
    	}
    	match.add(beginWord);
    	level.put(beginWord,1);
    //	hashMatch.add(beginWord);
    	
    	while(!match.isEmpty())
    	{
    		//�?�?对集�?�进行�??历，通过改�?�自己，在HashSet中匹�?
    		String head = match.poll();	//poll：删除并返回队列的首元素
    		for(int i=0;i<head.length();i++)
    		{
    			//从'a'到'z'�?��?�
    			for(char c = 'a';c<='z';c++) 
    			{
    				StringBuilder sb = new StringBuilder(head);
    				sb.setCharAt(i, c);
    				String changed = sb.toString();//一开始错用了replace方法!
    				if(wordSet.contains(changed))
    				{
    					//System.out.println(changed+"::head::"+head+"::"+level.get(head));
    					if(changed.equals(endWord))
    						return level.get(head)+1;
    					
    					match.add(changed.toString());
    					level.put(changed,level.get(head)+1);
        				wordSet.remove(changed);
    				}
    				
    			}
    		}
    	}
    	return 0;
    }
    

    
    public static void main(String[] args)
    {
    	String beginWord= "leet";
    	String endWord = "code";
    	Set<String> set = new HashSet<String>();
    	
    	set.add("lest");
    	set.add("leet");
    	set.add("lose");
    	set.add("code");
    	set.add("lode");
    	set.add("robe");
    	set.add("lost");
    	
//    	set.add("hot");
//    	set.add("cog");
//    	set.add("dot");
//    	
//    	set.add("dog");
//    	set.add("hit");
//    	set.add("lot");
//    	set.add("log");
    	//set.add("c");
//    	int size = set.size();
//    	LinkedList<String> list = new LinkedList<String>(set);
//    	for(int i=0;i<size;i++)
//    	{
//    		
//    		System.out.println(list.toString());
//    	}

     	WordLadder127 test = new WordLadder127();
    	int results = test.ladderLength(beginWord,endWord,set);
    	System.out.println(results);
    	
    }

}
