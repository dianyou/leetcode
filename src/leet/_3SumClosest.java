package leet;

import java.util.Arrays;

public class _3SumClosest {

    public int threeSumClosest(int[] nums, int target) {
    	if(nums == null || nums.length < 3)
    		return -1;
    	
    	Arrays.sort(nums);
    	
    	int closest= nums[0] + nums[1] + nums[2];
    	
    	for(int i=0; i<nums.length;i++)
    	{
    		int l = i+1, r= nums.length - 1;
    		
    		while(l<r)
    		{
    			int sum = nums[i] + nums[l] + nums[r];
    			
    			if(Math.abs(closest -target) > Math.abs(sum - target))
    				closest = sum;
    			
    			if(sum < target)
    				l++;
    			else
    				r--;
    			
    		}
    		
    	}
    	
    	return closest;
    }
    
    public static void main(String args[])
    {
    	int[] nums = {-3,-2,-5,3,-4};
    	int target = -1;
    	_3SumClosest solution = new _3SumClosest();
    	int result = solution.threeSumClosest(nums, target);
    	System.out.println(result);
    	
    }
}
