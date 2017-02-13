package leet;
/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * @author gavin
 * 2017-02-13
 */
public class MinimumDepthofBinaryTree {
	
	public int minDepth(TreeNode root)
	{
		if(root == null)
			return 0;
		if(root.left == null)
			return minDepth(root.right) +1;
		if(root.right == null)
			return minDepth(root.left) +1;
		
		return Math.min(minDepth(root.left), minDepth(root.right)) +1;
		
	}
	
    public int minDepthII(TreeNode root) {
        if(root == null)
        	return 0;
    	return dfs(root);
        
    }
    
    private int dfs(TreeNode root)
    {
    	if(root.left == null && root.right == null)
    		return 1;
    	else if(root.left == null)
    		return dfs(root.right)+1;
    	else if(root.right == null)
    		return dfs(root.left)+1;
    	else
    		return Math.min(dfs(root.left), dfs(root.right))+1;
    }
}
