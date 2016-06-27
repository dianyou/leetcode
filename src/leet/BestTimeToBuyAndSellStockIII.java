package leet;
/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 * @author I301431
 *	2016-06-25
 */
public class BestTimeToBuyAndSellStockIII {
	/**
	 * 一开始图简单，分成两部分后，分别调用I中的方法，结果超时了
	 * 使用两个数组分别记录前和后的最大利润，最后再遍历一遍，寻找最大值
	 * @param prices
	 * @return
	 */
    public int maxProfit(int[] prices) 
    {
    	if(prices==null || prices.length<=1)
    		return 0;
    	if(prices.length==2)
    		return prices[1]-prices[0]>0?(prices[1]-prices[0]):0;
    	int len = prices.length;
    	int[] positiveProfit = new int[len];//记录从0到i的最大盈利
    	int low=prices[0];
    	int ans1=0;
    	for(int i=0;i<len;i++)
    	{
    		low = Math.min(low, prices[i]);
    		ans1 = Math.max(ans1, prices[i]-low);
    		positiveProfit[i]= ans1;
    	} 	
    	int[] reverseProfit = new int[len];
    	int max=prices[prices.length-1];
    	int ans2=0;
    	for(int i =prices.length-1;i>=0;i--)
    	{
    		max = Math.max(max, prices[i]);
    		ans2 = Math.max(ans2, max-prices[i]);
    		reverseProfit[i] = ans2;
    	}
    	
    	int ans=0;
        for(int i=1;i<prices.length;i++)
        {
        	ans = Math.max(ans,positiveProfit[i]+reverseProfit[i]);
        }
        return ans;
    }
    /**
     * 超时的
     * @param prices
     * @param start
     * @param end
     * @return
     */
    
    private int oneMaxProfit(int[] prices,int start,int end)
    {
    	int max =prices[end];
    	int ans=0;
    	for(int i=end;i>=start;i--)
    	{
    		max = Math.max(prices[i], max);
    		ans = Math.max(ans,max-prices[i]);
    	}
    	return ans;
    }
    /**
     * 来自Leetcode Discuss的更快解法
     */
    public int maxProfitBetter(int[] prices) {
        // these four variables represent your profit after executing corresponding transaction
        // in the beginning, your profit is 0. 
        // when you buy a stock ,the profit will be deducted of the price of stock.
        int firstBuy = Integer.MIN_VALUE, firstSell = 0;
        int secondBuy = Integer.MIN_VALUE, secondSell = 0;

        for (int curPrice : prices) {
            if (firstBuy < -curPrice) firstBuy = -curPrice; // the max profit after you buy first stock
            if (firstSell < firstBuy + curPrice) firstSell = firstBuy + curPrice; // the max profit after you sell it
            if (secondBuy < firstSell - curPrice) secondBuy = firstSell - curPrice; // the max profit after you buy the second stock
            if (secondSell < secondBuy + curPrice) secondSell = secondBuy + curPrice; // the max profit after you sell the second stock
        }

        return secondSell; // secondSell will be the max profit after passing the prices
    }
    public static void main(String args[])
    {
    	BestTimeToBuyAndSellStockIII test = new BestTimeToBuyAndSellStockIII();
    	int prices[] = {1,2,4,2,5,7,2,4,9,0};
    	int res = test.maxProfitBetter(prices);
    	System.out.println(res);
    }
}
