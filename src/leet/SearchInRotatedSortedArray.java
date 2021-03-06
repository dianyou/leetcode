package leet;
/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * @author Gavin
 * 2016-06-07
 */
public class SearchInRotatedSortedArray{
	
    public int search(int[] nums, int target) {
    	if(nums == null || nums.length ==0)
    		return -1;
    	int l =0,r = nums.length-1;
    	
    	while(l<=r)
    	{
    		int m = l +(r - l)/2;
    		if(nums[m] == target)
    			return m;
    		/**
    		 * so annoying!
    		 */
    		if(nums[m] >= nums[l])
    		{
    			if(nums[m] > target && nums[l]<=target)
    				r = m -1;
    			else
    				l = m + 1; 
    		}
    		else
    		{
    			if(target > nums[m] && target <= nums[r])
    				l = m +1;
    			else
    				r = m-1;
    		}
    	}
    	return -1;
    }
	
    public int searchII(int[] nums,int target)
    {
      if(nums ==null || nums.length <1)
        return -1;
      int left=0,right = nums.length-1;

      //find the pivot
      int pivot = findPivot(nums);
      if(target<=nums[right])
      {
          left = pivot;
          return findTarget(nums,left,right,target);
      }
      else
      {
          right = pivot-1;
          return findTarget(nums,left,right,target);
      }
    }

    private int findTarget(int[] nums,int left,int right,int target)
    {
      while(left <= right)
      {
        int middle = left+(right-left)/2;
        if(nums[middle]==target)
          return middle;
        if(nums[middle]<target)
        {
          left = middle +1;
        }
        else
        {
          right = middle -1;
        }
      }
      return -1;
    }

    private int findPivot(int nums[])
    {
      if(nums ==null || nums.length <1)
        return -1;
      int left=0,right = nums.length-1,middle = 0;
      int pivot;
      if(nums[left] <= nums[right])
        return 0;
      while(left <= right)
      {
        middle = left+(right-left)/2;
        if(middle ==0) //预防边界
        	return 1;
        if(nums[middle] < nums[middle-1])
        {
          pivot = middle;
          return pivot;
        }
        else
        {
          if(nums[middle]>nums[right])
          {
            left = middle+1;
          }
          else
          {
            right = middle -1;
          }
        }
      }
      return -1;
    }
    public static void main(String args[])
    {
      SearchInRotatedSortedArray test = new SearchInRotatedSortedArray();
      int nums[] = {5,1,2,3,4};
      int results = test.search(nums,4);
      System.out.println(results);
    }

}
