package leet;

public class SingleNumberIII {
    /**
    *what an surprised roblem.....
    * split nums[] into two group based on the result of XOR for 
    * the whole nums
    */
    public int[] singleNumber(int[] nums) 
    {
    	int temp=0;
    	for(int i=0;i<nums.length;i++)
    	{
    		temp = temp ^ nums[i];
    	}
    	//split nums into A and B, based on the 1 of temp
    	int k=0;
    	while(true)
    	{
    		k++;
    		if(((temp>>k)&1) ==1)
    			break;
    		
    	}
        // find the right most '1'
        //  int lowbit = xor & ~(xor-1);
        //  int diff &= -diff;
    	int resA = 0, resB=0;
    	for(int i=0;i<nums.length;i++)
    	{
    		if(((nums[i]>>k)&1)==1)
    			resA ^= nums[i];
    		else
    			resB ^= nums[i];
    	}
    	
    	int[] res = {resA,resB};
    	return res;
    }
}
