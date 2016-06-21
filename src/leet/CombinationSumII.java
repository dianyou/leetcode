package leet;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/**
 * https://leetcode.com/problems/combination-sum-ii/
 * @author Gavin
 *	2016-06-14
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        List<Integer> list = new LinkedList<Integer>();
  	  	if(candidates==null || candidates.length ==0)
		      return res;
  	  	Arrays.sort(candidates);
  	  	int len = candidates.length;

  	  	dfs(candidates,0,target,list,res);
  	  	return res;
    }
    /**
     * DFS�??历，想象�?树，最深的是当�?节点与所有之�?�的节点�?�累加
     * 至于�?�?数�?�问题，最深的就是全部�?�得，最外层�?��?�一个，最里层�?�全部�?�?的数值
     * @param nums
     * @param start
     * @param target
     * @param list
     * @param res
     */
    private void dfs(int[] nums,int start,int target,List<Integer> list,List<List<Integer>> res)
    {
    	if(target ==0)
    	{
    		res.add(list);
    		return;
    	}
    	
      int i = start;
      while(i<nums.length)
      {
        if(target<nums[i])
          return;
        List<Integer> temp = new LinkedList<Integer>(list);
        temp.add(nums[i]);
        dfs(nums,i+1,target-nums[i],temp,res);
        while(i<(nums.length-1) &&nums[i+1] == nums[i])
          i++;
        i++;
      }
    }


    public static void main(String args[])
    {
    	CombinationSumII test = new CombinationSumII();
       	int nums[] ={1,1,1,1,1,2,2,3,4,4};
       	int target = 5;
        List<List<Integer>> res = test.combinationSum2(nums, target);
    	System.out.println(res.toString());
    }
}
