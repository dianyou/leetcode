package leet;

/**
 * https://leetcode.com/problems/jump-game/
 * @author I301431
 * 2016-12-21
 */

public class JumpGame {
	//超时了
    public boolean canJumpTTL(int[] nums) {
        if(nums == null || nums.length ==0)
        {
        	return false;
        }
        
        int maxJump = nums[0];
        
        for(int i=0;i<=maxJump && i<nums.length;i++)
        {
        	maxJump = Math.max(i+nums[i], maxJump);
        	if(maxJump>=(nums.length-1))
        		return true;
        }
        
        return maxJump>= (nums.length-1);
        
    }
    
    
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length ==0)
        {
        	return false;
        }
        
        int maxJump = nums[0];
        
        for(int i=0;i<nums.length;i++)
        {
        	if(i>maxJump)
        		return false;
        	maxJump = Math.max(i+nums[i], maxJump);
        	
        }
        
        return true;
        
    }


}
