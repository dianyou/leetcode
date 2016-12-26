package leet;

/**
 * https://leetcode.com/problems/remove-element/
 * @author I301431
 * 2016-12-19
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
    	if(nums == null || nums.length ==0)
    		return 0;
    	
    	int slow=0;
    	for(int i=0;i<nums.length;i++)
    	{
    		if(nums[i] != val)
    		{
    			nums[slow++] = nums[i];
    		}
    	}
    	
    	return slow;
    }
    
    public static void main(String args[])
    {
    	int nums[] = {2,1,2,3};
    	RemoveElement test = new RemoveElement();
    	int len = test.removeElement(nums, 3);
    	System.out.println(len);
    }
    
}
