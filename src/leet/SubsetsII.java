package leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsII {
    //DFS
	public List<List<Integer>> subsetsWithDupI(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(nums==null || nums.length ==0)
        	return null;
		Arrays.sort(nums);
		dfs(nums,0,new LinkedList<Integer>(),result);
		return result;
    }
	
	private void dfs(int[] nums,int pos,List<Integer> path,List<List<Integer>> result)
	{
		result.add(path);
		int dupCnt =1;
		for(int i = pos;i<nums.length;i++)
		{
			if((i<(nums.length-1))&&(nums[i]==nums[i+1]))
			{
				dupCnt++;
				continue;
			}
			
			//bundle all duplicate records
			for(;dupCnt>0;dupCnt--)
			{
				List<Integer> list = new LinkedList<Integer>(path);
				for(int j=0;j<dupCnt;j++)
					list.add(nums[i]);
				dfs(nums,i+1,list,result);
			}
			dupCnt=1;
				
		}
	}
	
	//DP
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(nums==null || nums.length ==0)
        	return null;
		Arrays.sort(nums);
		return dp(nums,nums.length-1);
	}
	private List<List<Integer>> dp(int[] nums,int end)
	{
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		if(end < 0)
		{
			List<Integer> list = new LinkedList<Integer>();
			res.add(list);
			return res;
		}
		int dupCnt =1;
		while(end>0)
		{
			if(nums[end] == nums[end-1])
			{
				dupCnt++;
				end--;
			}
			else
				break;
		}
		List<List<Integer>> temp = dp(nums,end-1);
		res = new LinkedList<List<Integer>>(temp);
		
		for(int i=0;i<temp.size();i++)
		{
			
			for(int k=1;k<=dupCnt;k++)
			{
				List<Integer> list = new LinkedList<Integer>(temp.get(i));
				for(int j=0;j<k;j++)
				{
					list.add(nums[end]);
				}
				res.add(list);
			}
		}
		return res;
	}
	
	public static void main(String args[])
	{
		SubsetsII test = new SubsetsII();
		int[] nums = {1,2,2};
		List<List<Integer>> res = test.subsetsWithDup(nums);
		
		for(int i=0;i<res.size();i++)
		{
			System.out.println(res.get(i));
		}
		
		
		
	}
}
