package leet;

import java.util.ArrayList;
import java.util.List;
/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 * @author I301431
 * 2016-09-08
 * it does not need to find out all sequence, just note this!
 */

public class LongestIncreasingSubsequence {
	/**
	 * dp
	 * it just need the length of LIS, don't need to store all subsequence of them
	 * only need to store length before
	 * @param nums
	 * @return
	 */
    public int lengthOfLISI(int[] nums) {
    	if(nums ==null || nums.length==0)
    		return 0;
    	int lis[] =new int[nums.length];
    	int max=0;
    	for(int i=0;i<nums.length;i++)
    	{
    		int curLis=0;
    		for(int j=0;j<i;j++)
    		{
    			if(nums[i]>nums[j])
    				curLis=Math.max(curLis, lis[j]);
    		}
    		lis[i] = curLis+1;
    		/**
    		 * the last one of array is not the last of LIS
    		 * so it needs a global max
    		 */
    		max = Math.max(lis[i], max);
    	}
    	return max;
    }
    
    /**
     * binary search
     * just copied
     * @param args
     */
    public int lengthOfLIS(int[] nums) {
        // write your code here
        if(nums.length == 0){
            return 0;
        }
        // len表示当前最长的升序序列长度（为了方便操作tails我们减1）
        int len = 0;
        // tails[i]表示长度为i的升序序列其末尾的数字
        int[] tails = new int[nums.length];
        tails[0] = nums[0];
        // 根据三种情况更新不同升序序列的集合
        for(int i = 1; i < nums.length; i++){
            if(nums[i] <= tails[0]){
                tails[0] = nums[i];
            } else if (nums[i] > tails[len]){
                tails[++len] = nums[i];
            } else {
            // 如果在中间，则二分搜索
                tails[binarySearch(tails, 0, len, nums[i])] = nums[i];
            }
        }
        return len + 1;
    }
    
    private int binarySearch(int[] tails, int min, int max, int target){
        while(min <= max){
            int mid = min + (max - min) / 2;
            if(tails[mid] == target){
                return mid;
            }
            if(tails[mid] < target){
                min = mid + 1;
            }
            if(tails[mid] > target){
                max = mid - 1;
            }
        }
        return min;
    }
    
    public static void main(String args[])
    {
    	LongestIncreasingSubsequence test 
    	= new LongestIncreasingSubsequence();
    //	int[] nums ={1,3,6,7,9,4,10,5,6};
    	int[] nums ={10,9,2,5,3,7,101,18};
    	int res=test.lengthOfLISI(nums);
    	System.out.println(res);
    }

}
