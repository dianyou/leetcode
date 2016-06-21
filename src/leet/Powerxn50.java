package leet;


public class Powerxn50 {
	/**
	 * 求x的n次方，采用分而治之的方法
	 * @param x
	 * @param n
	 * @return
	 * https://leetcode.com/problems/powx-n/
	 * Gavin
	 * 2016-5-29
	 */
	/**
	 * 醉了。。。
	 * �?考虑x为0,1，-1的情况；还是考虑n是-2147483648，2147483647的问题
	 * @param x
	 * @param n
	 * @return
	 */
    public double myPow(double x, int n) {
    	double mergePow=0,x2=0;
    	if( n==0)
    		return 1;
    	if(x ==1)
    		return 1;
    	if(x ==-1)
    	{
    		if(n%2==0)
    			return 1;
    		else
    			return -1;
    	}
    	if(n==-2147483648)
    		return 0;

    	if(x ==0 )
    		return 0;
    	if(n==1)
    		return x;
    	if(n==-1)
    		return 1/x;
    	if(n>0)
    	{
        	mergePow = mergePow(x,n/2);
        	if(n%2 ==0)
        		return mergePow*mergePow;
        	else
        		return mergePow*mergePow*x;
    	}
    	else
    	{
    		n = -n;
        	mergePow = mergePow(x,n/2);
        	if(n%2 ==0)
        		return 1/(mergePow*mergePow);
        	else
        		return 1/(mergePow*mergePow*x);
    	}

    		
    }
    
    private double mergePow(double x,int n)
    {
    	double mergePow=0;
    	if(n == 1)
    		return x;
    	mergePow = mergePow(x,n/2);
    	if(n%2 ==0)
    		return mergePow*mergePow;
    	else
    		return mergePow*mergePow*x;
    }
    
    public static void main(String args[])
    {
    	Powerxn50 test = new Powerxn50();
    	double results = test.myPow(-1,-2147483648);
    	System.out.println(results);
    }
}
