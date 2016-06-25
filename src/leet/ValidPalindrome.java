package leet;
/**
 * https://leetcode.com/problems/valid-palindrome/
 * @author Gavin
 *	2016-06-21
 */
public class ValidPalindrome {
	/**
	 * 一开始，左右依次移动，超时了，遂改成循环移动，AC!
	 * @param s
	 * @return
	 */
    public boolean isPalindrome(String s) {
    	char c[] = s.toLowerCase().toCharArray();
    	int left =0;
    	int right = s.length()-1;
    	while(left<=right)
    	{
    		while(left<s.length()&&(c[left]>'z'|| c[left]<'a')&&(c[left]<'0' || c[left]>'9') )
    		{
    			left++;
    		}
    			
    		while(right>=0&&(c[right]>'z'|| c[right]<'a')&&(c[right]<'0' || c[right]>'9') )
    		{
    			right--;
    		}
    		if(left >right)
    			break;
    	
    		if(c[left] != c[right])
    				return false;
    			left++;
    			right--;
    	}
    	return true;
    }
    public static void main(String args[])
    {
    	ValidPalindrome test = new ValidPalindrome();
    	boolean res= test.isPalindrome(" ");
    	System.out.println(res);
    }
}
