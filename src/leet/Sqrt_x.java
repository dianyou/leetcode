package leet;

/**
 * https://leetcode.com/problems/sqrtx/
 * @author I301431
 * 2016-12-28
 */
public class Sqrt_x {
	public int mySqrt(int x)
	{
		if(x <0)
			return -1;
		int low = 0,high=x;
		while(low <= high)
		{
			long middle = (low +(high-low)/2);
			long temp = (long)(middle * middle);
			if(temp == x)
				return (int)middle;
			if(temp > x)
				high = (int)middle-1;
			else 
				low = (int)middle+1;
		}
		return high;
	}
	
	public static void main(String[] args)
	{
		long l=3;
		int i=3;
//		System.out.println(Integer.MAX_VALUE);
		Sqrt_x test = new Sqrt_x();
		System.out.println(test.mySqrt(1579205274));
	}
}
