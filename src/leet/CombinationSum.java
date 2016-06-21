package leet;
import java.util.LinkedList;
import java.util.List;
/**
 * 
 * @author Gavin
 * 2016-06-14
 *
 */
public class CombinationSum
{
  public List<List<Integer>> combinationSum(int[] candidates, int target)
  {
	  if(candidates==null || candidates.length ==0)
		  return null;
      int len  = candidates.length;
      List<List<Integer>> result = new LinkedList<List<Integer>>();
      for(int i=len-1;i>=0;i--)
      {
    	//  System.out.println("hehe");
        if(candidates[i]>target)
          continue;
        List<Integer> list = new LinkedList<Integer>();
        list.add(candidates[i]);
        if(candidates[i] == target)
        {
        	 result.add(list);
        	// System.out.println("hehe");
        }
         
        else
          findRest(candidates,i,target-candidates[i],list,result);
      }
      return result;
  }
  private void findRest(int[] candidates,int len,int target,List<Integer>list,List<List<Integer>>result)
  {
	  for(int i=len;i>=0;i--)
	  {
	        if(candidates[i]>target)
	            continue;
	        List<Integer> temp = new LinkedList<Integer>(list);
	        temp.add(candidates[i]);
	        if(candidates[i] == target)
	          result.add(temp);
	        else
	          findRest(candidates,i,target-candidates[i],temp,result);
	  }
  }
  public static void main(String[] args)
  {
	  int[] candidates = {2,3,6,7};
	  int target = 7;
	  CombinationSum test = new CombinationSum();
	  List<List<Integer>> result = test.combinationSum(candidates, target);
	  System.out.println(result.toString());
  }
}
