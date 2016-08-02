package leet;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> res = new LinkedList<List<Integer>>();
    	if(root == null)
    		return res;
    	//here!!!
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.add(root);
    	
    	while(!queue.isEmpty())
    	{
    		List<Integer> list = new LinkedList<Integer>();
    		int curSize = queue.size();
    		for(int i=0;i<curSize;i++)
    		{
    			TreeNode node = queue.poll();
    			list.add(node.val);
    			if(node.left!=null)
    				queue.add(node.left);
    			if(node.right!=null)
    				queue.add(node.right);
    		}
    		res.add(list);
    	}
    	return res;
    }
    
    public static void main(String args[])
    {
    	
    }
	
}
