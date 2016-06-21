package leet;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/roman-to-integer/
 * @author Gavin
 *	2016-06-02
 */
public class RomanToInteger {
	
	/**
	 * 好�?无须判断�?�?�法的情况
	 * @param s
	 * @return
	 */
    public int romanToInt(String s) {
    	if(s==null ||s.length()==0)
    		return -1;
    	Map<Character,Integer> dict = new HashMap<Character,Integer>(); 
    	dict.put('I',1 );
    	dict.put('V',5 );
    	dict.put('X',10 );
    	dict.put('L',50 );
    	dict.put('C',100 );
    	dict.put('D',500 );
    	dict.put('M', 1000);
    	
    	char[] chars = s.toCharArray();
    	if(s.length() ==1)
    		return dict.get(chars[0]);
    	int results = 0;
    	for(int i=s.length()-1;i>=0;i--)
    	{
    		char c = chars[i];
    		if(i==s.length()-1)
    		{
    			results += dict.get(chars[i]);
    			System.out.println("+"+dict.get(chars[i]));
    			continue;
    		}
    		char prev = chars[i+1];
    		if(dict.get(c)>=dict.get(prev))
    		{
    			results += dict.get(c);
    			System.out.println("+"+dict.get(chars[i]));
    		}
    		else
    		{
    			results -=dict.get(c);
    			System.out.println("-"+dict.get(chars[i]));
    		}
    			
    	}
    	return results;
    }
    public static void main(String args[])
    {
    	RomanToInteger test = new RomanToInteger();
    	int k = test.romanToInt("MCMXCVI");
    	System.out.println(k);
    }
}
