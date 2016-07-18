package leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
	2016-07-08
	Gavin
*/
public class Permutations {
	/**
	 * DFS+swap
	 * @param nums
	 * @return
	 */
	List<List<Integer>> results = new LinkedList<List<Integer>>();
	public List<List<Integer>> permute(int[] nums) 
	{
		
		if(nums==null || nums.length==0)
			return results;

		dfs(nums,0);
		return results;
	}

	private void dfs(int[] nums,int start)
	{
		for(int i=start;i<nums.length;i++)
		{
			int temp[] = Arrays.copyOf(nums,nums.length);
			swap(temp,start,i);
			
			if(start!=i || start ==0)
			{
				List<Integer> list = new LinkedList<Integer>();
				for(int val: temp)
				{
					list.add(val);
					
				}
				results.add(list);
			}	
			if(start<nums.length-1)
				dfs(temp,start+1);
		}
	}

	private void swap(int nums[],int p,int q)
	{
		if(p==q)
			return;
		int temp = nums[p];
		nums[p] = nums[q];
		nums[q] = temp; 
	}
	
	/**
	 * DP，before the permutation of i. just permute i-1
	 * @param args
	 */
	public List<List<Integer>> permute2(int[] nums) {
		List<List<Integer>> res = new LinkedList<List<Integer>>();
    	if(nums==null|| nums.length==0)
				return res;
    	int len = nums.length;
    	return helper(nums,len);
    }
	private List<List<Integer>> helper(int[] nums,int n)
	{
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		if(n==1)
		{
			List<Integer> list = new LinkedList<Integer>();
			list.add(nums[0]);
			res.add(list);
			return res;
		}
		List<List<Integer>> temp = helper(nums,n-1);
		
		for(List<Integer> list:temp)
		{					
			for(int i=0;i<n;i++)
			{
				LinkedList<Integer> newList = new LinkedList<Integer>();
				for(int j=0;j<n;j++)
				{
					if(j<i)
						newList.add(list.get(j));
					if(j>i)
						newList.add(list.get(j-1));
					if(j==i)
						newList.add(nums[n-1]);
				}
				res.add(newList);
			}
		}
		return res;
	}
	public static void main(String args[])
	{
		int[] nums = {1};
		Permutations test = new Permutations();
		List<List<Integer>> res = test.permute(nums);
		System.out.println(res.size());
		for(List<Integer> list: res)
		{
			System.out.println(list);
		}
	}
}
