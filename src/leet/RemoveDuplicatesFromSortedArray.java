package leet;
/**
https://leetcode.com/problems/remove-duplicates-from-sorted-array/
这�?�题，一方�?��?求返回�?�?�?数字的个数，一方�?��?把这些数字放在nums数组的�?段
Gavin
2016-06-05
**/

public class RemoveDuplicatesFromSortedArray
{
	
	  public int removeDuplicates(int[] nums) {
	    if(nums ==null || nums.length ==0)
	      return 0;
	    if(nums.length==1)
	      return 1;
	    int newLen=1;
	    int len = nums.length;
	    for(int i=1;i<len;i++)
	    {
	    	if(nums[i-1] == nums[i])
	    	{
	    		continue;
	    	}
	    	else
	    	{
	    		nums[newLen]= nums[i];
	    		newLen++;
	    	}
	
	    }
	    return newLen;
	}

}
