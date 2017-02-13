package leet;

/**
 * https://leetcode.com/problems/balanced-binary-tree/
 * @author gavin
 * 2017-02-13
 */
public class BalancedBinaryTree {
	
	
	/**
	 * dfs and better
	 */
	public boolean isBalanced(TreeNode root)
	{
		return dfs(root) >=0;
	}
	
	private int dfs(TreeNode root)
	{
		if(root == null)
			return 0;
		
		int l = dfs(root.left);
		if(l<0) return -1;
		int r = dfs(root.right);
		if(r<0) return -1;
		
		if(Math.abs(l-r)>1)
			return -1;
		else
			return Math.max(l, r) + 1;
	}
	
	
	
	
	/**
	 * two recursion
	 * @param root
	 * @return
	 */
    public boolean isBalancedII(TreeNode root) {
    	calHeight(root);
    	return helper(root);
        
    }
    
    private boolean helper(TreeNode root)
    {
        if(root == null)
        	return true;
        int l =0,r=0;
        if(root.left != null)
        	l = root.left.val;
        if(root.right != null)
        	r = root.right.val;
        return ((Math.abs(l-r) <=1) && helper(root.left) && helper(root.right));
    }
    
    private int calHeight(TreeNode root)
    {
    	if(root == null)
    		return 0;
    	
    	int l=calHeight(root.left);
    	int r = calHeight(root.right);
    	int height = Math.max(l, r)+1;
    	root.val = height;
    	return height;
    }
}
