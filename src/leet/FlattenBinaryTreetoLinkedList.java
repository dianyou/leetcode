package leet;

/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * @author gavin
 * 2017-02-13
 */
public class FlattenBinaryTreetoLinkedList {
	
	//loop and better
	public void flatten(TreeNode root)
	{
		if(root == null)
			return;
		while(root != null)
		{
			if(root.left != null)
			{
				TreeNode pre = root.left;
				while(pre.right != null)
					pre = pre.right;
				pre.right = root.right;
				root.right = root.left;
				root.left = null;
			}
			root = root.right;
		}
	}
	
	
	////////////////////cut-off/////////////////////
	//recursion
    public void flattenII(TreeNode root) {
    	if(root == null)
    		return;
    	flattenHelper(root);
    }

    
    private TreeNode flattenHelper(TreeNode root)
    {
        if(root == null)
        	return null;
        if(root.left == null && root.right == null)
        	return root;
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        
        if(left != null)
        {
        	TreeNode last = flattenHelper(left);
        	root.right = left;
        	last.left = null;
        	if(right !=null)
        	{
        		last.right = right;
        	}
        	else
        	{
        		return last;
        	}
        	
        }
        return flattenHelper(right);
    }
}
