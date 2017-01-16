package leet;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 * @author gavin
 * 2017-01-15
 */
public class BinaryTreeInorderTraversal {
	
	  public List<Integer> inorderTraversal(TreeNode root) {
		  
		  List<Integer> list = new LinkedList<Integer>();
		  Stack<TreeNode> stack = new Stack<TreeNode>();
		  TreeNode cur = root;
		  
		  while(cur != null || !stack.isEmpty())
		  {
			  while(cur != null)
			  {
				  stack.push(cur);
				  cur = cur.left;
			  }
			  cur = stack.pop();
			  list.add(cur.val);
			  cur = cur.right;
			  
		  }
		  
		  return list;
	  }
	
	
    public List<Integer> inorderTraversalRecurison(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        dfs(root,list);
        
        return list;
    }

    private void dfs(TreeNode root,List<Integer> list)
    {
    	if(root == null)
    		return;
    	dfs(root.left,list);
     	list.add(root.val);
    	dfs(root.right,list);
    }
}
