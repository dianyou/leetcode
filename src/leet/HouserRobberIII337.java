package leet;

public class HouserRobberIII337 {
	
    static class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x)
		{
			val = x;
		}
	}
    
    public int rob(TreeNode root) {
    	int[] nums = dfs(root);
    	return nums[0]>nums[1]?nums[0]:nums[1];
    }
    
    /**
     * 返回值：max[0]:没有偷这个节点；max[1]:偷了这个节点
     * @param root
     * @return
     */
    public int[] dfs(TreeNode root)
    {
    	if(null == root)
    		return new int[2];
    	int x = root.val;
    	int[] left = dfs(root.left);
    	int[] right = dfs(root.right); 
    	int leftTemp = left[0]>left[1]?left[0]:left[1];
    	int rightTemp = right[0]>right[1]?right[0]:right[1];
    	
    	int[] max = {leftTemp+rightTemp,left[0]+right[0]+x};
    	return max;
    }

}
