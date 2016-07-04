package leet;

/**
 * 2016-07-04
 * @author I301431
 *	
 */
public class HIndexII {
	
    public int hIndex(int[] citations) {
    	//citations是排好序的
	    if(citations==null || citations.length <1)
	        return 0;
    	int len = citations.length;
    	int left =0,right = len-1;
    	while(left <=right)
    	{
    		int mid = (left+right)/2;
    		if(citations[mid]==(len-mid))
    		{
    			return citations[mid];
    		}
    		else if(citations[mid]<(len-mid))
    		{
    			left = mid+1;
    			
    		}
    		else
    		{
    			right = mid-1;
    		}
    		System.out.println("left::"+citations[left]);
    		System.out.println("right::"+citations[right]);
    		
    	}
    	return len-left;
    }
    public static void main(String args[])
    {
    	int[] citations = {0,0,1,2,3,4,8,9,10,11,13};
    	HIndexII test = new HIndexII();
    	int res = test.hIndex(citations);
    	System.out.println(res);
    }

}
