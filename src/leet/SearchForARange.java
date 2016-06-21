package leet;
/**
 * https://leetcode.com/problems/search-for-a-range/
 * @author Gavin
 *	2016-06-10
 */
public class SearchForARange {
	/**
	 * 先找到target，�?�?�左�?��??�?�寻找边界
	 * 方法二：：对区间两端分别二分法查找，左：nums[k] = target && nums[k-1]<target...
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
    public int[] searchRange(int[] nums, int target) {
    	int[] badResult = {-1,-1}; 
        if(nums==null || nums.length ==0)
        	return badResult;
        	
        int left=0,right= nums.length-1;
        while(left<=right)
        {
          int middle = (left+right)/2;
          if(nums[middle] == target)
          {
        	  System.out.println(middle);
        	  return find(nums,middle,target);
          }
            
          if(nums[middle]>target)
            right = middle-1;
          else
            left = middle+1;
        }
    	return badResult;
    }
    private int[] find(int nums[],int middle,int target)
    {
      int start = middle,end =middle;
      while(end<nums.length-1 && nums[end+1]==target)
        end++;
      while(start>0 &&nums[start-1] ==target)
        start--;
      int[] results = {start,end};
      return results;

    }
    public static void main(String args[])
    {
    	int[] nums = {1};
    	SearchForARange test = new SearchForARange();
    	int[] results = test.searchRange(nums, 1);
    	System.out.println(results[0]+","+results[1]);
    }
}
