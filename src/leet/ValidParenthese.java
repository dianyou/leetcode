package leet;
import java.util.LinkedList;
import java.util.Stack;

public class ValidParenthese {
/**
 * Gavin
 * 2016-5-31
 * https://leetcode.com/problems/valid-parentheses/
 */
    public boolean isValid(String s) {
    	Stack<Character> stack = new Stack<Character>();
    	if(s == null||s.length() <=1)
    		return false;
    	for(char c: s.toCharArray())
    	{
    		if(stack.isEmpty())
    		{
    			stack.push(c);
    			continue;
    		}
    		char peek = stack.peek();
    		switch(peek)
    		{
    			case '(':
    			{
    				
    				if(c ==')')
    					stack.pop();
    					
    				else
    					stack.push(c);
    				break;
    			}
    			case '[':
    			{
    				if(c ==']')
    					stack.pop();
    				else
    					stack.push(c);
    				break;
    			}
    			case '{':
    			{
    				if(c =='}')
    					stack.pop();
    				else
    					stack.push(c);
    				break;
    			}
    			default:
    			{
    			//	System.out.println("default::"+peek);
    				return false;
    			}
    				
    		}
    	}
    	if(stack.isEmpty())
    		return true;
    	else
    		return false;
        
    }
    public static void main(String args[])
    {
    	ValidParenthese test = new ValidParenthese();
    	System.out.println(test.isValid("()"));
    }
}
