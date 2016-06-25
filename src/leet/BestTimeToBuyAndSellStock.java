package leet;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * @author Gavin
 * 2016-06-25
 *
 */
public class BestTimeToBuyAndSellStock
{
  public int maxProfit2(int[] prices)
  {
    if(prices==null || prices.length==0)
      return 0;
      int low=prices[0],high=prices[0];
      int ans=0;
      for(int i=1;i<prices.length;i++)
      {
        
          if(prices[i]<low)
          {
            low = prices[i];
          }
          if((prices[i]-low)>ans)
          {
        	  ans = prices[i]-low;
          }
      }

      return ans;
  }
  /** 更喜欢这个思维
   * 用类似动态规划的思想，到第i天买入，那么我能赚到的最大利润是多少呢？
   * 就是i + 1 ~ n天中最大的股价减去第i天的。找最大股价的问题可以在找第i+1~n天的最大利润时顺便记录
   * @param args
   */
  public int maxProfit(int[] prices)
  {    
	  if(prices==null || prices.length==0)
		  return 0;
	  int ans=0;
	  int max = prices[prices.length-1];
	  for(int i=prices.length-1;i>=0;i--)
	  {
		  max = Math.max(prices[i], max);
		  ans = Math.max(ans, max - prices[i]);
	  }
	  return ans;
  }
  public static void main(String args[])
  {
	  BestTimeToBuyAndSellStock test = new BestTimeToBuyAndSellStock();
//	  []
	  int nums[] = {7,1,5,3,6,4};
	  System.out.println(test.maxProfit(nums));
  }
}
