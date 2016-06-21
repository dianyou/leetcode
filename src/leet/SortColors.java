package leet;
/**
 * https://leetcode.com/problems/sort-colors/
 * @author Gavin
 * 2016-06-03
 *
 */
public class SortColors {
    public void sortColors(int[] nums) {
        if(nums ==null || nums.length==0)
        	return;
        int len = nums.length;
        //0:red;1:white;2:blue
    	int left=0,right=len-1; 
    	for(int i=0;i<=right;i++)
    	{
    		if(nums[i]==1)
    		{
    			//System.out.println("Here::"+1);
    			continue;
    		}
    			
    		if(nums[i]==0)
    		{
    			//System.out.println("Here::"+0);
    			int temp = nums[left];
    			nums[left] = 0;
    			nums[i]= temp;
    			left++;
    		//	i--;	//无须�?判断，交�?�过�?�的肯定是1，因为�??历顺�?是从左到�?�
    			continue;
    		}
    		if(nums[i]==2)
    		{
    			//System.out.println("Here::"+2);
    			int temp = nums[right];
    			nums[right] = 2;
    			nums[i] = temp;
    			right--;
    			i--; //需�?继续判断交�?�过�?�的数�?�，因为有�?�能交�?�过�?�的是2
    			continue;
    		}
    		
    	}
    }
    public static void main(String args[])
    {
    	int[] nums = {0,1,2,0,2};
    	SortColors test = new SortColors();
    	test.sortColors(nums);
    	for(int i=0;i<nums.length;i++)
    		System.out.println(nums[i]);
    	
    }
}
