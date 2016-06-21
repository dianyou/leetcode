package leet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern290 {
    public boolean wordPattern(String pattern, String str) {
    	String[] words = str.split(" ");
    	Map<String,Character> hm = new HashMap<String,Character>();
    	Set<Character> set = new HashSet<Character>();
    	int len = words.length;
    	if(len != pattern.length())
    		return false;
    	for(int i=0;i<len;i++)
    	{
    		char c = pattern.charAt(i);
    		if(hm.containsKey(words[i]))
    		{
    			char temp = hm.get(words[i]);
    			if(temp == c)
    				continue;
    			else
    				return false;
    			
    		}
    		else if(set.contains(c))
    			return false;
    		else
    		{
    			hm.put(words[i], c);
    			set.add(c);
    		}
    			
    	}
    	return true;
    }

}
