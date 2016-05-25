
public class MergeSortedArray88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pos=m+n-1;
        int i=m-1;//nums1
        int j=n-1;//nums2
        
        for(pos = m+n-1;pos>=0;pos--)
        {
        	if(j<0)
        		break;
        	if(i<0)
        	{
        		while(j>=0)
        		{
        			nums1[pos]=nums2[j];
        			j--;
        			pos--;
        		}
        		break;
        	}
        	
        	
        	if(nums1[i]>=nums2[j])
        	{
        		nums1[pos] = nums1[i];
        		i--;
        	}
        	else
        	{
        		nums1[pos] = nums2[j];
        		j--;
        	}
        }
        
    	
    }

}
