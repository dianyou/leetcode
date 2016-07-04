package leet;

import java.util.Arrays;
/**
 * 
 * @author Gavin
 * 	2016-06-27
 *
 */
public class HIndex
{
	//统计+遍历
	public int hIndex(int[] citations)
	{
	    if(citations==null || citations.length <1)
	        return 0;
	    int len = citations.length;
	    int[] factors = new int[len+1];
	    for(int i=0;i<len;i++)
	    {
	    	if(citations[i]>=len)
	    		factors[len]++;
	    	else
	    	{
	    		factors[citations[i]]++;
	    	}
	    }
	    int ans=0;
	    for(int i=len;i>0;i--)
	    {
	    	ans += factors[i];
	    	if(ans>=i)
	    		return i;
	    }
	    return 0;
	}
	
	//先排序！！！
	public int hIndex2(int[] citations)
	{
    if(citations==null || citations.length <1)
      return 0;
    Arrays.sort(citations);
    int len = citations.length;
    for(int i=len;i>0;i--)
    {
      if(citations[len-i]>=i)
      return i;
    }
    return 0;
	}
	//最low
  public int hIndex3(int[] citations)
  {
    if(citations==null || citations.length <1)
      return 0;
    for(int factor = citations.length;factor>0;factor--)
    {
      int counter =0;
      for(int i=0;i<citations.length;i++)
      {
        if(citations[i]>=factor)
          counter++;
      }
      if(counter>=factor)
        return factor;
    }
    return 0;
  }
}
