package leet;

import java.util.LinkedList;
import java.util.List;

public class Subsets {
	
	
	//DFS
	public List<List<Integer>> subsets(int[] nums)
	{
    	List<List<Integer>> res = new LinkedList<List<Integer>>();
    	if(nums == null || nums.length==0)
    		return res;
    	dfs(nums,0,new LinkedList<Integer>(),res);
    	return res;
	}
	
	private void dfs(int[] nums,int position,
			List<Integer> path,List<List<Integer>> res)
	{
		res.add(path);
		for(int i=position;i<nums.length;i++)
		{
			List<Integer> list = new LinkedList<Integer>(path);
			list.add(nums[i]);
		//	res.add(list);
			dfs(nums,i+1,list,res);
		}
	}
	
	//DP
	public List<List<Integer>> subsetsII(int[] nums)
	{
    	List<List<Integer>> res = new LinkedList<List<Integer>>();
    	if(nums == null || nums.length==0)
    		return res;
    	res = helper(nums,nums.length-1);
    	return res;
    	
	}
	
	private List<List<Integer>> helper(int[] nums,int end)
	{
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		
		if(end < 0)
		{
			List<Integer> list = new LinkedList<Integer>();
			res.add(list);
			return res;
		}
			
		List<List<Integer>> temp = new LinkedList<List<Integer>>(helper(nums,end-1));
		for(List<Integer> list: temp)
		{
			List<Integer> addList = new LinkedList<Integer>(list);
			addList.add(nums[end]);
			res.add(list);
			res.add(addList);
		}
		return res;
	}
	
	
	//bit map
    public List<List<Integer>> subsetsI(int[] nums) {
    	List<List<Integer>> res = new LinkedList<List<Integer>>();
    	if(nums == null || nums.length==0)
    		return res;
    	
    	long n = (long) Math.pow(2, nums.length);
    	for(int i=0;i<n;i++)
    	{
    		LinkedList<Integer> list = new LinkedList<Integer>();
    		int k=i;
    		int counter =0;
    		while(k>0)
    		{
    			if((k&1)==1)
    				list.add(nums[counter]);
    			k= k>>1;
    			counter++;
    		}
    		res.add(list);
    	}
    	return res;
        
    }
    public static void main(String[] args)
    {
    	int[] nums = {1,2,3};
    	Subsets test = new Subsets();
    	List<List<Integer>> res  = test.subsets(nums);
//    	for(List<Integer> list:res)
//    		System.out.println(list);
    	
    }
}
