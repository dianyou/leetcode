package leet;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 * @author I301431
 * 2016-12-08
 */
public class TwoSum {
	
    public int[] twoSum(int[] nums, int target) {
    	int[] result = new int[2];
    	if(nums==null || nums.length <2)
    		return result;
    	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    	
    	for(int i=0;i<nums.length;i++)
    	{
    		
    		if(map.containsKey(target - nums[i]))
    		{
    			result[1] = i;
    			result[0] = map.get(target-nums[i]); 
    			break;
    		}
    		map.put(nums[i], i);
    	}
    	
    	return result;
    }
    
    
    public static void main(String args[])
    {
    	int nums[] = {3,2,4};
    	int target = 6;
    	TwoSum test = new TwoSum();
    	int[] solution = test.twoSum(nums, target);
    	
    	System.out.println(solution[0]+","+solution[1]);
    	
    }

}
