package leet;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _3sum {
	
	private static List<List<Integer>> results;
	
    public List<List<Integer>> threeSum(int[] nums) {
    	Arrays.sort(nums);
    	find3sum(nums,0);
    //	System.out.println(results.toString());
    //	System.out.println("Results::::"+results.toString());
    	return results;
    	
    }
	
	public static void find3sum(int[] nums, int target)
	{
		results = new ArrayList<List<Integer>>();

		for(int i =0;i<nums.length-2;i++)
		{
			
			find2sum(nums,target,i);
			while(i<nums.length-2 && nums[i] == nums[i+1])
				i++;
	
		}
	}
	
	public static void find2sum(int[] nums,int target,int p)
	{
		//首尾两个指针
		int start = p +1, end = nums.length-1;
	
		while(start < end)
		{
			if(nums[start] + nums[end] + nums[p]== target)
			{
				//System.out.println("(" + nums[p] + ","+ nums[start] + "," + nums[end] +")");
				List<Integer> list = new ArrayList<Integer>();
				list.add(nums[p]);
				list.add(nums[start]);
				list.add(nums[end]);
				results.add(list);
				System.out.println(list.toString());
				while (start < end && nums[start] == nums[start+1]) start++;  
	            while (start < end && nums[end] == nums[end-1]) end--;  
	            start++;
	            end--;
			}
			else if (nums[start] + nums[end] + nums[p] < target)
				start++;
			else 
				end--;
		}
	}

	public static void main(String[] args)
	{
    	Scanner sc = new Scanner(System.in);
    	String s = sc.nextLine();
    	s = s.substring(1, s.length()-1);
    	
    	String[] ss = s.split(",");
    	
    	
    	//初始化数组
    	int[] nums=new int[ss.length];
    	
    	for(int i=0;i<ss.length;i++)
    	{
    		nums[i]=Integer.parseInt(ss[i]);
    	}
    	_3sum test = new _3sum();
    	test.threeSum(nums);
    //	find3sum(nums,0);
	}
}
