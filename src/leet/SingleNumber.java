package leet;
/**
 * 2016-07-19
 * @author I301431
 *
 */
public class SingleNumber {
	/**
	 * Liner runtime complexity, O(1) space
	 * exclusive or, XOR
	 * @param nums
	 * @return
	 */
    public int singleNumber(int[] nums) {
    	if(nums==null || nums.length ==0)
    		return 0;
    	
    	int result =0;
    	
    	for(int i=0;i<nums.length;i++)
    	{
    		result ^= nums[i];
    	}
    	return result;
        
    }

}
