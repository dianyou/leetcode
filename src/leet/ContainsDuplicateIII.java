package leet;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
/**
 * https://leetcode.com/problems/contains-duplicate-iii/
 * @author Gavin
 * 	2016-06-17
 * 我觉得这三道题目有点无聊。。。。
 *
 */
public class ContainsDuplicateIII {

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) 
    {
    	if(nums==null || nums.length ==0)
    		return false;
    	Set<Integer> winK = new HashSet<Integer>();
    	for(int i=0;i<nums.length;i++)
    	{
    		if(i==0)
    		{
    			winK.add(nums[i]);
    			continue;
    		}
    		if(i>k)
    			winK.remove(nums[i-k-1]);

    		if(k>=t)//取k和t中较小的值迭代判断
    		{
        		for(int j=-t;j<=t;j++)
        		{
        			if(nums[i]+j-Integer.MAX_VALUE >0)
        				continue;
        			if(winK.contains(nums[i]+j))
        			{
        				return true;
        			}
        		}   
    		}
    		else
    		{
        		for(int temp: winK)
        		{
        			if(temp >=nums[i])
        			{
        				if(temp -nums[i]-Integer.MAX_VALUE >0)
        				{
        					continue;
        				}
        				if(temp - nums[i]<=t)
        					return true;
        			}
        			if(temp<=nums[i])
        			{
        				if(nums[i]-temp-Integer.MAX_VALUE >0)
        				{
        					continue;
        				}
        				if(nums[i]-temp<=t)
        					return true;
        			}
        		}
    		}
    		winK.add(nums[i]);
    	}
    	return false;
    }
    /**
     * 使用TreeSet,使用Long类型防止越界
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t)
    {
    	if(nums==null || nums.length ==0)
    		return false;
    	if(k<=0)
    		return false;
    	if(t<0)
    		return false;
    	SortedSet<Long> ss = new TreeSet<Long>();
    	for(int i=0;i<nums.length;i++)
    	{
    		if(i==0)
    		{
    			ss.add((long)nums[i]);
    			continue;
    		}
    		if(i>k)
    		{
    			ss.remove((long)nums[i-k-1]);
    		}
    		

    		//subset取[left,right);高值不取，因此使用nums[i]+t+1;
    		System.out.println(ss.toString());
    		SortedSet<Long> sub = ss.subSet((long)nums[i]-t, (long)nums[i]+t+1);
    		if(!sub.isEmpty())
    		{
//        		System.out.println((long)nums[i]-t);
//        		System.out.println((long)nums[i]+t+1);
//        		System.out.println((long)nums[i]);
    			return true;
    		}
    		ss.add((long)nums[i]);	
    			
    	}
    	return false;
    	
    }
    public static void main(String args[])
    {
    	ContainsDuplicateIII test = new ContainsDuplicateIII();
    	//int[] nums = {-1,2147483647};
  //  	int[] nums = {-1,-1};
//      	int[] nums = {7,1,3};
 //   	int nums[] = {0};
    	int nums[] = {-3,3};
    	boolean flag = test.containsNearbyAlmostDuplicate(nums,2,4);
    	System.out.println(flag);
    }
}
