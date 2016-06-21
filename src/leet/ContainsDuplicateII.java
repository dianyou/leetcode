package leet;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
/**
 * 
 * @author Gavin
 * 2016-06-17
 *
 */
public class ContainsDuplicateII
{
	/**
	 * Solution1
	 * 使用HashMap
	 * @param nums
	 * @param k
	 * @return
	 * 效率低
	 */
  public boolean containsNearbyDuplicate2(int[] nums, int k) {
	  if(nums==null || nums.length ==0)
		  return false;
	  Map<Integer,Integer> hm = new HashMap<Integer,Integer>();
      for(int i=0;i<nums.length;i++)
      {
        if(hm.containsKey(nums[i]))
        {
          int j = hm.get(nums[i]);
          if(i-j<=k)
        	  return true;


        }
          hm.put(nums[i],i);
      }
      return false;
  }
/**
 * Solution2
 * @param nums
 * @param k
 * @return
 * 使用HashSet�?�?一个长度为k的滑动窗�?�，中间是用HashSet判断�?�?
 * 效率很高
 */
  public boolean containsNearbyDuplicate(int[] nums, int k) {

    if (nums.length <= 1) {
        return false;
    }

    HashSet<Integer> hashSet = new HashSet<Integer>();
    for (int i = 0; i < nums.length; i++) {
        if (i > k) {//移动窗�?�
            hashSet.remove(nums[i - k - 1]);
        }
        if (!hashSet.add(nums[i])) {
            return true;
        }
    }

    return false;
}

  public static void main(String args[])
  {
	  int nums[] = {1,2,1};
	  int k=0;
	  ContainsDuplicateII test = new ContainsDuplicateII();
	  boolean flag = test.containsNearbyDuplicate(nums, k);
	  System.out.println(flag);
  }
}
