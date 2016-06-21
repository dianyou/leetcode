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
    		//	i--;	//æ— é¡»å†?åˆ¤æ–­ï¼Œäº¤æ?¢è¿‡æ?¥çš„è‚¯å®šæ˜¯1ï¼Œå› ä¸ºé??åŽ†é¡ºåº?æ˜¯ä»Žå·¦åˆ°å?³
    			continue;
    		}
    		if(nums[i]==2)
    		{
    			//System.out.println("Here::"+2);
    			int temp = nums[right];
    			nums[right] = 2;
    			nums[i] = temp;
    			right--;
    			i--; //éœ€è¦?ç»§ç»­åˆ¤æ–­äº¤æ?¢è¿‡æ?¥çš„æ•°æ?®ï¼Œå› ä¸ºæœ‰å?¯èƒ½äº¤æ?¢è¿‡æ?¥çš„æ˜¯2
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
