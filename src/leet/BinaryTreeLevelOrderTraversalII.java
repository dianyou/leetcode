package leet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeLevelOrderTraversalII {

//  public List<List<Integer>> levelOrderBottom(TreeNode root) {
//    	List<List<Integer>> res = new ArrayList<List<Integer>>();
//    	if(root == null)
//    		return res;
//    	//here!!!
//    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
//    	queue.add(root);
//    	
//    	while(!queue.isEmpty())
//    	{
//    		List<Integer> list = new LinkedList<Integer>();
//    		int curSize = queue.size();
//    		for(int i=0;i<curSize;i++)
//    		{
//    			TreeNode node = queue.poll();
//    			list.add(node.val);
//    			if(node.left!=null)
//    				queue.add(node.left);
//    			if(node.right!=null)
//    				queue.add(node.right);
//    		}
//    		res.add(0,list);
//    	}
//    	return res;
//    
//    }
    
    
	/**
	 * DFS
	 * @param root
	 * @return
	 */
	List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if(root ==null)
    		return res;
    	dfs(root,0);
    	Collections.reverse(result);
    	return result;
    }
    private void dfs(TreeNode root,int level)
    {
    	if(root==null)
    		return;
    	int val = root.val;
    	if(result.size()<level+1)
    	{
    		List<Integer> list = new ArrayList<Integer>();
    		list.add(root.val);
    	//	result.set(level, list);
    		result.add(list);
    	}
    	else
    	{
    		List<Integer> list = result.get(level);
    		list.add(val);
    	}
    	if(root.left !=null)
    		dfs(root.left,level+1);
    	if(root.right !=null)
    		dfs(root.right,level+1);
    }

}
