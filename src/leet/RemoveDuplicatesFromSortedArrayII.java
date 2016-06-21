package leet;
/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 * @author Gavin
 * 2016-06-06
 *
 */
public class RemoveDuplicatesFromSortedArrayII
{
	/**
	 * �?许�?�?，间隔判断；
	 * 由于是间隔判断，需�?在下一次判断时�?为nums[count]赋值
	 * 如果�??�?赋值，会存在nums[i-2]就是nums[count]
	 * @param nums
	 * @return
	 */
  public int removeDuplicates(int[] nums) {
	if(nums ==null || nums.length ==0)
		return 0;
	if(nums.length<=2)
		return nums.length;
    int count=1,temp = nums[1];
    for(int i=2;i<nums.length;i++)//隔一个�?�判断
    {
      if(nums[i] == nums[i-2])
      {
          continue;
      }
      else
      {
          nums[count] = temp;
          count++;
          temp= nums[i];
      }
    }
    nums[count] = temp;
    return count+1;
  }
  public static void main(String args[])
  {
	  int nums[]={1,1,2,2,3};
	  RemoveDuplicatesFromSortedArrayII test
	  = new RemoveDuplicatesFromSortedArrayII();
	  int len = test.removeDuplicates(nums);
    for(int i=0;i<len;i++)
    {
      System.out.println(nums[i]);
    }
	  System.out.println("Length::"+len);
  }
}
