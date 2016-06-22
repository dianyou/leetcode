package leet;
public class HouseRobber198 {
    public int rob(int[] nums) {
        int[] max = new int[nums.length+1];
        if(nums.length==1)
        	return nums[0];
        if(nums.length ==0)
        	return 0;
        max[1] = nums[0];
        for(int i=2;i<=nums.length;i++){
        	if((max[i-2]+nums[i-1])<max[i-1])
        		max[i] = max[i-1];
        	else
        		max[i] = max[i-2]+nums[i-1];
        }
        
    	return max[nums.length];
    }
}
