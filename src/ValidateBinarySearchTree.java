/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 * @author Gavin
 *	2016-06-10
 */
public class ValidateBinarySearchTree
{
    static class TreeNode {
       int val;
       TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    /**
     * DFS递归判断，注意：左节点的右子节点不止要比左节点的值大，还要比父节点的值小，因此在每次判断时要增加上界和下界
     * 为了防止超出int值得范围，因此加入boolean类型的判断
     * @param root
     * @return
     */
    public boolean isValidBST_(TreeNode root) {
      if(root == null)
        return true;
      int value = root.val;
      boolean flag = true;
      if(root.left != null)
      {
        if(root.left.val>=value )
          return false;
         flag = validBST(root.left,false,true,0,value);
         if(!flag)
          return false;
      }
      if(root.right !=null)
      {
        if(root.right.val<=value)
          return false;
        flag = validBST(root.right,true,false,value,0);
        if(!flag)
         return false;
      }
        return true;
    }

    private boolean validBST(TreeNode node,boolean isDown,boolean isUp,
      int down,int up)
    {
      boolean flag;
      int value = node.val;
      if(node.left!=null)
      {
        if(node.left.val>= value)
          return false;
        if(isDown)
          if(node.left.val<=down)
            return false;
        // if(isUp)
        //   if(node.left.val >=up)
        //     return false;
        flag = validBST(node.left,isDown,true,down,value);
        if(!flag)
         return false;
      }
      if(node.right !=null)
      {
        if(node.right.val<=value)
          return false;
        // if(isDown)
        //   if(node.right.val <=down)
        //     return false;
        if(isUp)
          if(node.right.val >=up)
            return false;
        flag = validBST(node.right,true,isUp,value,up);
        if(!flag)
         return false;
      }
       return true;
    }
    /**
     * 中序遍历，获取到一个无重复的递增序列即可
     * @param root
     * @return
     */
    TreeNode pre = null;  //遍历时的前一个节点
      
    public boolean isValidBST(TreeNode root) {  
        if (root != null) {  
            if (!isValidBST(root.left)) 
            	return false;  
              
            if (pre != null && root.val <= pre.val) 
            	return false;  
              
            pre = root;  
              
            return isValidBST(root.right);  
        }  
        return true;  
     } 

    public static void main(String args[])
    {
    	TreeNode root = new TreeNode(3);
    	root.left = new TreeNode(1);
    	root.left.left = new TreeNode(0);
    	root.left.right = new TreeNode(2);
    	root.right = new TreeNode(5);
    	root.right.left = new TreeNode(4);
    	root.right.right = new TreeNode(6);
    	root.right.left.left = new TreeNode(3);
    	ValidateBinarySearchTree test = new ValidateBinarySearchTree();
    	boolean flag =  test.isValidBST(root);
    	System.out.println(flag);
    }
}
