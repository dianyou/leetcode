package leet;

import java.util.LinkedList;
import java.util.List;

public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
    	if(n<=0)
    		return new LinkedList<TreeNode>();
    	return helper(1,n);
    	
    }
    
    private List<TreeNode> helper(int l,int r)
    {
    	List<TreeNode> list = new LinkedList<TreeNode>();
    	if(l > r)
    	{
    		list.add(null);
    		return list;
    	}
    	
    	for(int i=l;i<=r;i++)
    	{
    		List<TreeNode> lList = helper(l,i-1);
    		List<TreeNode> rList = helper(i+1,r);
    		
    		for(TreeNode lt:lList)
    			for(TreeNode rt:rList)
    			{
    				TreeNode root = new TreeNode(i);
    				root.left = lt;
    				root.right = rt;
    				list.add(root);
    			}
    	}
    	return list;
    }
}
