package leet;

import java.util.LinkedList;
import java.util.List;

/**
 * 2016-07-04
 * @author I301431
 *
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
    	if(root == null)
        	return res;    
    	LinkedList<Integer> ll = new LinkedList<Integer>();
    	ll.add(root.val);
    	if(root.left==null && root.right==null && root.val==sum)
    	{
    		res.add(ll);
    		return res;
    	}
    
    	helper(root.left,sum-root.val,ll,res);
    	helper(root.right,sum-root.val,ll,res);
    	
    	return res;
    	
    }
    private void helper(TreeNode root,int sum,LinkedList<Integer> ll,List<List<Integer>> res)
    {
    	
    	if(root ==null)
    	{
    		return;
    	}
    	LinkedList<Integer> helperList = new LinkedList<Integer>(ll);
    	helperList.add(root.val);
    	if(root.left==null && root.right==null && root.val==sum)
    	{
    		res.add(helperList);
    		return;
    	}
    	
    	//LinkedList<Integer> helperList = new LinkedList<Integer>(ll);
    	helper(root.left,sum-root.val,helperList,res);
    	helper(root.right,sum-root.val,helperList,res);
    }

}
