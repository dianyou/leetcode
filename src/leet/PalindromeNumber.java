package leet;
public class PalindromeNumber
{
	public boolean isPalindrome(int x) 
	{
		if(x == 0)
			return true;
		if(x<10)
			return false;
    	int base=1;
    	while(x/base >10)
    		base *=10;
    	while(base>0)
    	{
    		int head = x/base;
    		int tail = x%10;
    		if(tail != head)
    			return false;
    		x = x- head*base; //qia tou
    		x = x/10; //qu wei
    		base /= 100;

    	}
    	return true;

    }

    public static void main(String args[])
    {
    	PalindromeNumber test = new PalindromeNumber();
    	boolean res = test.isPalindrome(234);
    	System.out.println(res);
    }
}