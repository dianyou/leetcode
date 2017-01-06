package leet;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 * @author I301431
 * 2017-01-06
 */
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
    	if(nums == null || nums.length ==0)
    		return false;
    	int l =0,r = nums.length-1;
    	
    	while(l<=r)
    	{
    		int m = l +(r - l)/2;
    		if(nums[m] == target)
    			return true;
    		/**
    		 * so annoying!
    		 */
    		if(nums[m] > nums[l])
    		{
    			if(nums[m] > target && nums[l]<=target)
    				r = m -1;
    			else
    				l = m + 1; 
    		}
    		else if(nums[m] < nums[l])
    		{
    			if(target > nums[m] && target <= nums[r])
    				l = m +1;
    			else
    				r = m-1;
    		}
    		else
    			l++;
//    		System.out.println(left);
//    		System.out.println(right);
    	}
    	return false;
    }
    
    public static void main(String args[])
    {
    	SearchInRotatedSortedArrayII test = new SearchInRotatedSortedArrayII();
    	int nums[] = {5,1,3};
    	int target = 3;
    	System.out.println(test.search(nums, target));
    }
}
