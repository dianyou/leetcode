package leet;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
	
	public boolean isSymmetricII(TreeNode root) 
	{
		if(root == null )
			return true;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root.left);
		queue.add(root.right);
		while(queue.size()>1)
		{
			TreeNode left = queue.poll();
			TreeNode right = queue.poll();
			if(left == null && right == null)
				continue;
			if(left ==null ^ right == null)
				return false;
			if(left.val != right.val)
				return false;
			queue.add(left.left);
			queue.add(right.right);
			queue.add(left.right);
			queue.add(right.left);
		}
		
	    return true;    
	}
	
	//recursion
	public boolean isSymmetric(TreeNode root)
	{
		if(root == null)
			return true;
		
		return isSymmetric(root.left, root.right);
	}
	
	public boolean isSymmetric(TreeNode left,TreeNode right)
	{
		if(left == null && right == null)
		{
			return true;
		}
		if(left == null ^ right == null)
			return false;
		if(left.val != right.val)
			return false;
		return (isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left));
		
	}
	
	
	
	private boolean equalsToTreeNode(TreeNode node1,TreeNode node2)
	{
		if(node1 == null && node2 == null)
			return true;
		if(node1 != null && node2 != null)
		{
			return (node1.val == node2.val);
		}
		return false;
	}
	
}
