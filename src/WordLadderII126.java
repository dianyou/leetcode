import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


public class WordLadderII126 {
	/**
	 * https://leetcode.com/problems/word-ladder-ii/
	 * @param beginWord
	 * @param endWord
	 * @param wordList
	 * @return
	 * Gavin
	 * 2016-5-25
	 */
	
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
    	if (beginWord == null || endWord == null || beginWord.equals(endWord)  
                || beginWord.length() != endWord.length() ||beginWord.length() ==0)  
            return null; 
    	List<List<String>> results = new LinkedList<List<String>>();
    	
    	Queue<String> match = new LinkedList<String>();
    	Map<String,Integer> level = new HashMap<String,Integer>();//记录每个变换的层数
    	Map<String,List<String>> recallHM = new HashMap<String,List<String>>();//回溯；key存储当前字符串；value存储pre的字符串
    	Set<String> wordSet = new HashSet<>(wordList);
    	if(wordSet.contains(beginWord))//剔除原集合中有首元素的情况
    	{
    		wordSet.remove(beginWord);
    	}
    	match.add(beginWord);
    	level.put(beginWord,1);
    	
    	boolean flag = false;
    	while(!match.isEmpty() && !flag)
    	{
    		//不再对集合进行遍历，通过改变自己，在HashSet中匹配
    		String head = match.poll();	//poll：删除并返回队列的首元素
    		for(int i=0;i<head.length();i++)
    		{
    			//从'a'到'z'变换
    			for(char c = 'a';c<='z';c++) 
    			{
    				StringBuilder sb = new StringBuilder(head);
    				sb.setCharAt(i, c);
    				String changed = sb.toString();//一开始错用了replace方法!
    				if(wordSet.contains(changed))
    				{
    					//System.out.println(changed+"::head::"+head+"::"+level.get(head));
    					//recallHM中添加记录
    					
    					recallHM.put(changed, head);
    					if(changed.equals(endWord))
    					{
    						//results.add(recall(recallHM,beginWord,endWord));
    						flag = true;
    					}
    					
    					match.add(changed.toString());
    					level.put(changed.toString(),level.get(head)+1);
        				wordSet.remove(changed);
    				}
    				
    			}
    		}
    	}
    	return results;
    }
    
    private List<String> recall(Map<String,String> map,String beginWord,String endWord)
    {
    	if(map.isEmpty())
    		return null;
    	String skey = endWord;
    	ArrayList<String> list = new ArrayList<String>();
    	
    	while(map.containsKey(skey))
    	{
    		list.add(skey);
    		skey = map.get(skey);
    	}
    	list.add(beginWord);
    	if(list.size()<=1)
    		return list;
    	else//reverse
    	{
    		List<String> reverseList = new LinkedList<String>();
    		for(int i =list.size()-1;i>=0;i--)
    		{
    			reverseList.add(list.get(i));
    		}
    		return reverseList;
    	}
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
    	
     	WordLadderII126 test = new WordLadderII126();
     	List<List<String>> results = test.findLadders(beginWord,endWord,set);
    	System.out.println(results.toString());
    }

}
