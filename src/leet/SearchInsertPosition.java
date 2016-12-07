package leet;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length <1)
        {
        	return 0;
        }
        int l=0,r=nums.length-1;
        while(l<=r)
        {
        	int m =  l + (r-l)/2;
        	if(nums[m]==target)
        	{
        		return m;
        	}
        	if(nums[m] > target)
        	{
        			r=m-1;
        	}
        	else
        	{
        			l=m+1;
        	}
        }
        return l;
    }
}
