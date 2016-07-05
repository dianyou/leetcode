package leet;

/**
 * 2016-07-04
 * @author I301431
 *
 */
public class PathSum {
	public boolean hasPathSum(TreeNode root,int sum)
	{
		if(root==null)
			return false;
		//从root到leaf
		if(root.val == sum && root.left==null&&root.right==null)
			return true;
//		if(root.val>sum)
//			return false;
		if(hasPathSum(root.left,sum-root.val))
			return true;
		if(hasPathSum(root.right,sum-root.val))
			return true;
		return false;
	}

}
