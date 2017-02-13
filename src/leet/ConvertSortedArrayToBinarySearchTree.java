package leet;

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null || nums.length == 0)
        	return null;
        return buildBST(nums,0,nums.length-1);

        
        
    }
    
    private TreeNode buildBST(int nums[],int left,int right)
    {
    	if(left > right)
    		return null;
        
        int mid = left + (right - left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        
        TreeNode rightBST = buildBST(nums, 0,mid-1);
        TreeNode leftBST = buildBST(nums,mid+1,right);
        
        root.left = leftBST;
        root.right = rightBST;
    	return root;
    }
    
    
}
