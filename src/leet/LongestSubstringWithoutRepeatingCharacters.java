package leet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * @author I301431
 * 2016-12-14
 */
public class LongestSubstringWithoutRepeatingCharacters {

	//map
    public int lengthOfLongestSubstringII(String s) {
        if(s == null || s.length() ==0)
        	return 0;
        int max = 1;

        Map<Character,Integer> map = new HashMap<Character,Integer>(); 
        //slow fast pointer
        for(int i=0,j=0;i<s.length();i++)
        {
        	char c = s.charAt(i);
        	if(map.containsKey(c))
        	{
        		j = Math.max(j, map.get(c)+1);
        	}
        	map.put(c, i);
        	max = Math.max(max, i-j+1);
        }
        return max;
    }
    
    
    //set
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() ==0)
        	return 0;
        int max=1;
        
        Set<Character> set = new HashSet<Character>();
        int slow=0,fast =0;
        while(fast < s.length())
        {
        	char c = s.charAt(fast);
        	
        	if(set.contains(c))
        	{
        		set.remove(s.charAt(slow));
        		slow++;
        	}
        	else
        	{
        		set.add(c);
        		fast++;
        		max = Math.max(max, set.size());
        	}
        	
        }
        return max;   	
    	
    }
    
    
}
