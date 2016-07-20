package leet;

/**
 * 2016-07-20
 * @author I301431
 *
 */
public class SingleNumberII {

	/**
	 * logic operation
	 * @param nums
	 * @return
	 */
	public int singleNumber2(int[] nums) {
		
		int bits[] = new int[32];
		for(int i=0;i<nums.length;i++)
		{
			int num = nums[i];
			for(int j=0;j<32;j++)
			{
				
				bits[j] += (num>>j)&1;
			}
		}
		int res=0;
		for(int i=0;i<32;i++)
		{
			res |= ((bits[i]%3)%2)<<i; //in case it appears twice
		}
		return res;
        
    }
	
	public int singleNumber(int[] nums) {
		int bits[] = new int[32];
		int res =0;
	    for(int i=0; i<32; i++){  
	        for(int j=0; j<nums.length; j++){  
	            bits[i]+=(nums[j]>>i)&1;  
	        }  
	        res|=((bits[i]%3)%2)<<i;  
	    }  
	    return res; 
	}
 
	public static void main(String args[])
	{
		int[] nums = {43,16,45,89,45,-2147483648,45,2147483646,
		               -2147483647,-2147483648,43,2147483647,-2147483646,
		               -2147483648,89,-2147483646,89,-2147483646,-2147483647,
		               2147483646,-2147483647,16,16,2147483646,43};
		SingleNumberII test = new SingleNumberII();
		int res = test.singleNumber(nums);

		System.out.println(res);
		
	}

}
