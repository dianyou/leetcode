package leet;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length <1)
        	return 0;
        int len = nums.length;
        int maxResult = nums[0];
        //表示以nums[i]开头的，最大连续子串的值
        int[] dp = new int[len];
        dp[0] = nums[0];
        for(int i=1;i<len;i++)
        {
        	dp[i] = Math.max(nums[i], nums[i] + dp[i-1]);
//        	if(dp[i-1]<0)
//        		dp[i] = nums[i];
//        	else
//        		dp[i] = dp[i-1] + nums[i];
        	maxResult = Math.max(maxResult, dp[i]);
        }
        
        return maxResult;
    }
    
}
