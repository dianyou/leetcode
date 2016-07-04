package leet;
/**
 * 
 * @author Gavin
 *	2016-06-27
 */


public class BestTimeToBuyAndSellStockIV {
	
	
	/**
	 * 参考III中leetcode讨论区的方法，但是空间占用越界了
	 * 目前，不知道原因，同样是双重循环	2016-06-26
	 * 原因在于当k值较大时，可以直接贪心算法，大大降低大数值时的复杂度
	 * 
	 * @param k
	 * @param prices
	 * @return
	 */
    public int maxProfit(int k, int[] prices) {
        if(prices ==null ||prices.length<2||k<1)
        	return 0;
        int len = prices.length;
        // validate input 2 : if k is large enough, the question will be the same as question II.  
        if (k >=  len/ 2) {  
            int result = 0;  
            for (int i = 1; i < len; ++i) {  
                if (prices[i] - prices[i - 1] > 0) {  
                    result += prices[i] - prices[i - 1];  
                }  
            }  
            return result;  
        }  
        
        int[] toBuy = new int[k]; 
        for(int i=0;i<k;i++)
        	toBuy[i] = Integer.MIN_VALUE;
        int[] toSell = new int[k];
        toSell[0] = 0;
        for(int i=0;i<prices.length;i++)
        {
        	//System.out.println("Price::"+prices[i]);
        	if(toBuy[0]<-prices[i])
        	{
        		toBuy[0] = -prices[i];
        		//System.out.println(0+"th buy::"+prices[i]);
        	}
        		
        	if(toSell[0]<toBuy[0]+prices[i])
        	{
        		toSell[0]=toBuy[0]+prices[i];
        		//System.out.println(0+"th sell::"+prices[i]);
        	}
        	/**
        	 * DP算法
        	 * 每次计算到i位置，通过j+1次交易获得的最大收益
        	 */
        	
        	for(int j=1;j<k;j++)
        	{
        		if(toBuy[j] < toSell[j-1] - prices[i])
        		{
        			toBuy[j] = toSell[j-1] - prices[i];
        			//System.out.println(j+"th buy::"+prices[i]);
        		}
        		if(toSell[j]<toBuy[j]+prices[i])
        		{
        			toSell[j] = toBuy[j]+prices[i];
        			//System.out.println(j+"th sell::"+prices[i]);
        		}
        			
        	}
        	//System.out.println("temp profit::"+toSell[k-1]);
        }
        return toSell[k-1];
        
    }
    public static void main(String args[])
    {
    	int k=4;
    //	4
    //	[1,2,4,2,5,7,2,4,9,0]  15
    	int[] prices ={1,2,4,2,5,7,2,4,9,0};
    	BestTimeToBuyAndSellStockIV test = new BestTimeToBuyAndSellStockIV();
    	int res =test.maxProfit(4, prices);
    	System.out.println("Result::"+res);
    }
}
