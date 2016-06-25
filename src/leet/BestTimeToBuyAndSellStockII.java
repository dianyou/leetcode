package leet;
/**
 * 
 * @author Gavin
 *	2016-06-25
 */
public class BestTimeToBuyAndSellStockII
{
	/**
	 * 贪心算法
	 * @param prices
	 * @return
	 */
  public int maxProfit(int[] prices) {
    if(prices==null || prices.length<=1)
      return 0;
      int sum=0;
      for(int i=1;i<prices.length;i++)
      {
        if(prices[i]>prices[i-1])
          sum += (prices[i]-prices[i-1]);
      }
      return sum;
}
}
