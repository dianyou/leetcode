package leet;

/**
 * 2016-07-18
 * @author Wen
 * https://leetcode.com/problems/next-permutation/
 */
public class NextPermutation {
	
	/**
	 * 从末位向前遍历，若是递增序列，直接交换末尾的两个数字即可
	 * 若后几位是递减的，找到递减序列的前一个数，在其后的递减序列中，找出最小的且比其大的数
	 * 与这个拐点交换，在reverse递减序列即可
	 * 
	 * 如是一完整的递减序列，整体reverse一遍
	 * @param nums
	 */
    public void nextPermutation(int[] nums) {
        if(nums==null || nums.length<2)
        	return;
        int n=nums.length;
        if(nums[n-1]>nums[n-2])
        {
        	swap(nums,n-1,n-2);
        	return;
        }
        int breakpoint = -1;
        for(int i=nums.length-2;i>=0;i--)
        {
      //  	System.out.println("i::"+i);
        	if(nums[i]<nums[i+1])
        	{
        		breakpoint = i;
        		break;
        	}
        }
    //    System.out.println("break point"+breakpoint);
        if(breakpoint == -1)
        {
        	reverse(nums,0,n-1);
        	return;
        }
        //categorized
//        if(nums[breakpoint]<nums[n-1])
//        {
//        	swap(nums,breakpoint,n-1);
//        	reverse(nums,breakpoint+1,n-1);
//        }
        for(int j=n-1;j>=breakpoint;j--)
        {
        	if(nums[j]>nums[breakpoint])
        	{
        		swap(nums,breakpoint,j);
        		reverse(nums,breakpoint+1,n-1);
        		break;
        	}
        }
        
    }
    
    private void reverse(int[] nums,int start,int end)
    {
    	while(start<end)
    	{
    		swap(nums,start,end);
    		start++;
    		end--;
    	}
    }
    private void swap(int[] nums,int a,int b)
    {
    	int temp = nums[a];
    	nums[a] = nums[b];
    	nums[b] = temp;
    }
    
    public static void main(String args[])
    {
//    	int[] nums = {1,2,3};
    	int[] nums = {1,3,2};
    	NextPermutation test = new NextPermutation();
    	test.nextPermutation(nums);
    	for(int i=0;i<nums.length;i++)
    		System.out.println(nums[i]);
    	
    }

}
