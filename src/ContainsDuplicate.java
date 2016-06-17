import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/**
 * 
 * @author Gavin
 * 2016-06-17
 */
public class ContainsDuplicate
{
/**
 * 先排序，时间复杂度该是O(nlgn)，但是在LeetCode的testcase下反而比Hash快
 * @param nums
 * @return
 */
  public boolean containsDuplicate2(int[] nums)
  {
    Arrays.sort(nums);
    for(int i=1;i<nums.length;i++)
    {
      if(nums[i]==nums[i-1])
        return true;
    }
    return false;
  }
 /**
  * 使用HashSet
  * @param nums
  * @return
  */
  public boolean containsDuplicate(int[] nums)
  {
    Set<Integer> hs = new HashSet<Integer>();
    for(int i=0;i<nums.length;i++)
    {
      if(hs.contains(nums[i]))
        return true;
      hs.add(nums[i]);
    }
    return false;
  }
}
