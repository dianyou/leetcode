package leet;
/**
 * https://leetcode.com/problems/decode-ways/
 * @author Gavin
 * 2016-06-08
 * ac率�?�有17.7.............
 *
 */
public class DecodeWays
{
  /**
  若两�?数，大于26，则f(n) = f(n-1)
  若�?于等于26，则f(n)=f(n-1)+f(n-2)
  */

	/**
	 * 超时了，有�?�?计算�?�?�?�?f(n-1)和f(n-2)
	 * @param s
	 * @return

  public int numDecodings(String s)
  {
    if(s ==null || s.length()==0)
      return 0;
    if(s.length() ==1)
      return 1;
    if(s.length() ==2)
    {
      int temp = Integer.parseInt(s);
      if(temp<=26)
        return 2;
      else
        return 1;

    }
    String firstTwo = s.substring(0,2);
    int value = Integer.parseInt(firstTwo);
    if(value>26)
      return numDecodings(s.substring(1));
    else
    {
      int sum1 = numDecodings(s.substring(1));
      int sum2 = numDecodings(s.substring(2));
      return sum1 + sum2;
    }

  }
 */
	/**
	 * 使用一个数组记录，f(n-1),f(n-2)，都是�?计算的
	 * 包�?�"0"是个问题
	 * @param s
	 * @return
	 */
	public int numDecodings(String s)
	{
	  if(s ==null || s.length()==0)
	    return 0;
	  if(s.equals("0"))
		  return 0;
	  if(s.length() ==1)
	    return 1;

	  int[] f = new int[s.length()+1];
	  //�?始化f
	  f[1] = 1;
	  String firstTwo = s.substring(0,2);
	  int value = Integer.parseInt(firstTwo);
	  if(value<10)
		  return 0;
	  if(value==10||value==20)
		  f[2]=1;
	  else if(value %10 ==0)
		  return 0;
	  else if(value<=26)
		  f[2] = 2;
	  else
		  f[2]= 1;
	  //i：字符串的指针
	  for(int i=2;i<s.length();i++)
	  {
		  
		  String temp = s.substring(i-1,i+1);
		  value = Integer.parseInt(temp);
		  if(value ==0)
			  return 0;
		  if(value ==10 || value ==20)
		  {
			  f[i+1] = f[i-1];
			  continue;
		  }
		  if(value<10)
		  {
			  if(f[i]==0)
				  return 0;
			  else
				  f[i+1] = f[i];
			  continue;
		  }
		  if(value%10 == 0) //30,40,50,,,,,
			  return 0;
		  
		  if(value<=26) // 10<value<=26,且value<>20
		  {
		    f[i+1] = f[i]+f[i-1];
		  }
		  else
		  	f[i+1] = f[i];
	  }
	  return f[s.length()];
	}
  public static void main(String args[])
  {
	  DecodeWays test = new DecodeWays();
	  String s = "30";
	  int value =  test.numDecodings(s);
	  System.out.println(value);
//	  System.out.println(s.substring(0,3));
  }

}
