
public class HouseRobberII213 {
    public int rob(int[] nums) {
    	int len = nums.length;
    	if(len ==0)
    		return 0;
    	if(len ==1)
    		return nums[0];
    	
    	int[] max1 = new int[len];//记录第1个至n-1个房屋的最好规划
    	max1[1] = nums[0];
    	for(int i=2;i<len;i++)
    	{
    		max1[i] = ((max1[i-2]+nums[i-1])>max1[i-1])?(max1[i-2]+nums[i-1]):max1[i-1];
    	}
    	
    	
    	int[] max2 = new int[len+1];//记录第2个至第n个房屋的最好规划
    	max2[2] = nums[1];
    	for(int i=3;i<=len;i++)
    	{
    		max2[i] = ((max2[i-2]+nums[i-1])>max2[i-1])?(max2[i-2]+nums[i-1]):max2[i-1];
    	}
    	
    	return (max1[len-1]>max2[len])? max1[len-1]:max2[len];
    }
}
