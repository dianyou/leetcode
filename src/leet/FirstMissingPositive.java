package leet;
/**
 * 有O(n)的时间�?�?�度�?求， 一次�??历，将nums[i]放到nums[i]-1这个�?置
 * 第二次�??历输出�?�?�法的�?置
 * 边界�?�件特多，[]输入1，[3]输出1，[2,3]输出1
 * [1,1]输出2
 * @author Gavin
 *	2016-06-10
 */
public class FirstMissingPositive
{
  public int firstMissingPositive(int[] nums)
  {
	 if(nums == null || nums.length ==0)
		 return 1;

    for(int j=0;j<nums.length;j++)
    {
      if(nums[j] <=0||nums[j]>nums.length ||nums[j] ==j+1)
      {
        continue;
      }
      if(nums[j] > 0)
      {
        // swap();
    	if(nums[nums[j]-1] == nums[j])//有�?�?时，防止死循环
    		continue;
        int temp = nums[nums[j]-1];
        nums[nums[j]-1] = nums[j];
        nums[j] = temp;
        j--;
      }
    }

    for(int i=0;i<nums.length;i++)
    {
    	if(nums[i] != i+1)
    	  return i+1;
    }
    return nums.length+1;
  }

  public static void main(String args[])
  {
	  int nums[] = {1,1};
	  FirstMissingPositive test = new FirstMissingPositive();
	  int k = test.firstMissingPositive(nums);
	  for(int i=0;i<nums.length;i++)
	  System.out.println(nums[i]);
	  System.out.println(k);
  }
}
