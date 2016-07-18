package leet;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/**
	2016-07-08
	Gavin
*/
public class PermutationsII
{

	/**
	对于重复数据，不能单纯的只是与起始数字相等的就跳过，在swap操作时，
	两个数字之间不要有和目标数字相等的值，否则直接跳过

	*/
	List<List<Integer>> results = new LinkedList<List<Integer>>();
	int visitedLen=0;

	// HashMap<Integer,Boolean> hm = new HashMap<Integer,Boolean>();
	public List<List<Integer>> permuteUnique(int[] nums) 
	{
		
		if(nums==null || nums.length==0)
			return results;
		Arrays.sort(nums);
		visitedLen = nums[nums.length-1]+1;
		System.out.println(visitedLen);
		dfs(nums,0);
		return results;
	}

	


	private void dfs(int[] nums,int start)
	{
		for(int i=start;i<nums.length;i++)
		{
			int temp[] = Arrays.copyOf(nums,nums.length);
			if(i!=start && nums[i] ==nums[start])
				continue;
			boolean repeated = false;
			for(int j=start;j<i;j++)
			{

				if(temp[j]==temp[i])
				{
					repeated = true;
					break;
				}
			}
			if(repeated)
				continue;
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

	public static void main(String args[])
	{
		//[-1,2,0,-1,1,0,1]
		int nums[] = {-1,2,0,-1,1,0,1};
		PermutationsII test = new PermutationsII();
		List<List<Integer>> res = test.permuteUnique(nums);
		System.out.println(res.size());
		for(List list: res)
		{
			System.out.println(list.toString());
		}
	}

}