package leet;
/**
 * https://leetcode.com/problems/divide-two-integers/
 * @author Gavin
 * 2016-06-13
 * 变态的testcase.....
 */
public class DivideTwoIntegers
{
	/**
	 * 不允许使用乘除法，使用减法会超时，选择移位运算
	 * @param dividend
	 * @param divisor
	 * @return
	 */
	
  public int divide(int dividend,int divisor)
  {
    if(divisor ==0)
    	return dividend>0? Integer.MAX_VALUE:Integer.MIN_VALUE;
    if(dividend ==0)
    	return 0;
    boolean flag = false; //false:-  true:+
    if((dividend >0 && divisor <0)||(dividend <0 && divisor >0))
    {
    	flag =false;
    }
    else 
    	flag = true;
    //在运算时，会有移位到最大值的时候，因此使用long类型
	long L_dividend = Math.abs((long)dividend);
	long L_divisor = Math.abs((long)divisor); 
    if(L_dividend < L_divisor)
    	return 0;
    long count=0,tempCount=1;
    long shift = L_divisor;
    while(L_dividend>0)
    {
    	long temp = L_dividend - shift;
    	if(temp<L_divisor && temp >=0)
    	{
    		count = count + tempCount;
			break;
    	}
    	else if(temp >= -L_divisor && temp <0)
    	{
    		count =count + tempCount -1;
    		break;
    	}
   	
    	if(shift > L_dividend)
    	{
    		//运算顺序敲错了好几次
    		shift = shift >>1;
    		tempCount = tempCount >>1;
    		L_dividend =  L_dividend - shift;
    		count = count+tempCount;
    		tempCount = 1;
    		shift = L_divisor;
    		continue;
    	}
    	shift = shift <<1;
    	tempCount = tempCount<<1;
    }
    //考虑边界条件: -2147483648
    if((count+Integer.MIN_VALUE)==0)
    	return divisor==1? Integer.MIN_VALUE:Integer.MAX_VALUE;
    if(flag)
    	return (int)count;
    else
    	return -(int)count;
    
  }
  public static void main(String args[])
  {
	  DivideTwoIntegers test = new DivideTwoIntegers();
	  int r = test.divide(-2147483648, -1);
	  System.out.println(r);
  }
}
