package leet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
    	Queue<String> match = new LinkedList<String>(); //变换后存在于集合中的元素
    	Map<String,List<String>> recallHM = new HashMap<String,List<String>>();//回溯；key存储当前字符串；value存储pre的字符串
    	Map<String,Integer> level = new HashMap<String,Integer>();//记录每个变换的层数
    	int shortestLevel = wordList.size();
    //	Set<String> wordSet = new HashSet<>(wordList);
    	if(wordList.contains(beginWord))//剔除原集合中有首元素的情况
    	{
    		wordList.remove(beginWord);
    	}
    	match.add(beginWord);
    	level.put(beginWord,1);
    	
    	boolean flag = false;
    	while(!match.isEmpty())
    	{
    		//不再对集合进行遍历，通过改变自己，在HashSet中匹配
    		String head = match.poll();	//poll：删除并返回队列的首元素
    		if(level.get(head) >=shortestLevel)
    			continue;
    		
    		
    		wordList.remove(head);	//集合中删除元素
    		
    		
    		for(int i=0;i<head.length();i++)
    		{
    			//从'a'到'z'变换
    			for(char c = 'a';c<='z';c++) 
    			{
    				StringBuilder sb = new StringBuilder(head);
    				sb.setCharAt(i, c);
    				String changed = sb.toString();//一开始错用了replace方法!
    				if(wordList.contains(changed))
    				{
    	//				System.out.println(changed+"::head::"+head);
    					//recallHM中添加记录
    					List<String> tempList ;
    					if(recallHM.containsKey(changed))
    					{
    						tempList = recallHM.get(changed);
    					}
    					else
    					{
    						tempList = new ArrayList<String>();
    					}
    					if(tempList.contains(head))
    						continue;
    					tempList.add(head);//由于会remove集合中的数据，所以不会存在重复值
    					recallHM.put(changed,tempList);
    					if(changed.equals(endWord))
    					{
    						shortestLevel = level.get(head)+1;
    						flag = true;
    					}
    					if(!flag)
    					match.add(changed);
    					level.put(changed,level.get(head)+1);
    					
    				}
    				
    			}
    		}
    	}
    	List<List<String>> results = new LinkedList<List<String>>();
    	if(!flag)
    		return results;
    	LinkedList<String> path = new LinkedList<String>();
    	path.add(endWord);
    	System.out.println("Recall::"+recallHM.toString());
    //	dfs(recallHM,endWord,beginWord,path,results);
    	return results;
    }
    
    //dfs时，以始做终，endWord为起始key
    //Memory limited exceed!!!!!!!!!
    private void dfs(Map<String,List<String>> map,String start,String end,LinkedList<String> path,List<List<String>> results)
    {
    	if(map.containsKey(start))
    	{
    		//System.out.println();
    		List<String> al=map.get(start); 
    		for(int i=0;i<al.size();i++)
    		{
    			String s = al.get(i);
    			LinkedList<String> ll = new LinkedList<String>(path);
    			ll.add(s);
    			if(s.equals(end))
    			{
    				Collections.reverse(ll);
    				results.add(ll);
    				return;
    			}
    			else
    				dfs(map,s,end,ll,results);
    		}
    	}
    	else
    		return;
			
    }
    
    public static void main(String[] args)
    {
    	String beginWord= "cet";
    	String endWord = "ism";
    	String[] ss = {"kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"};
    	Set<String> set = new HashSet<String>(Arrays.asList(ss));
    	
    	//    	set.add("ted");
//    	set.add("tex");
//    	set.add("red");
//    	set.add("tax");
//    	set.add("tad");
//    	set.add("den");
//    	set.add("rex");
//    	set.add("pee");
    	
     	WordLadderII126 test = new WordLadderII126();
     	List<List<String>> results = test.findLadders(beginWord,endWord,set);
    	System.out.println(results.toString());
    }

}
