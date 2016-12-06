package leet;

public class QuickSort {

    private void quickSort(int[] nums,int l,int r)
    {
    	if(nums == null || nums.length<=1)
    		return;
    	int partiton = partition(nums,l,r);
    	
    	quickSort(nums,l,partiton);
    	quickSort(nums,partiton,r);
    		
    }
    
    private int partition(int[] nums,int l,int r)
    {
    	int pivot = nums[l];
    	while(l<r)
    	{
    		while(nums[r] > pivot && r>l)
    		{
    			r--;
    		}
    		nums[l] = nums[r];
    		
    		while(nums[l] < pivot && l< r)
    		{
    			l++;
    		}
    		nums[r] = nums[l];
    	}
    	nums[l] = pivot;
    	return l;
    }
    
}
