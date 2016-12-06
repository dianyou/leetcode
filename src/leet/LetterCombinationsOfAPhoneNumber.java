package leet;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
	
	List<String> combinations = new LinkedList<String>();
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() <1)
        	return combinations;
        dfs(digits,0,"");
        return combinations;
    }
    
    private void dfs(String digits, int level, String s)
    {
    	if(level >= digits.length())
    	{
    		combinations.add(s);
    		return;
    	}
    	String mapping = getMapping(digits.charAt(level));
    	if(mapping == null ||mapping.length() == 0)
    		dfs(digits,level+1,s);
    	else
    	{
    		for(int i=0; i<mapping.length();i++)
        	{
        		String tempS  = new StringBuilder(s).append(mapping.charAt(i)).toString();
        		dfs(digits,level+1,tempS);
        	}
    	}
    }
    
    private String getMapping(char c)
    {
    	String result = null;
    	switch(c)
    	{
    		case '2':
    			result = "abc";
    			break;
    		case '3':
    			result = "def";
    			break;
    		case '4':
    			result = "ghi";
    			break;
    		case '5':
    			result = "jkl";
    			break;
    		case '6':
    			result = "mno";
    			break;
    		case '7':
    			result = "pqrs";
    			break;
    		case '8':
    			result = "tuv";
    			break;
    		case '9':
    			result = "wxyz";
    			break;
    		default:
    			result = "";
    	}
    	return result;
    }
    public static void main(String args[])
    {
    	LetterCombinationsOfAPhoneNumber test
    	 = new LetterCombinationsOfAPhoneNumber();
    	List<String> result = test.letterCombinations("2");
    	System.out.println(result.toString());
    }
}
