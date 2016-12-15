package leet;

public class ConstructBinaryTreefromInorderandPostorderTraversal {

	 public TreeNode buildTree(int[] inorder, int[] postorder) {
		 if(inorder ==null || postorder == null
				 ||inorder.length ==0 || postorder.length ==0
				 ||inorder.length != postorder.length )
			 return null;
		 int len = inorder.length;
		 int rootValue = postorder[len-1];
		 TreeNode root = new TreeNode(rootValue);
		 
		 int inMiddle = -1;
		 
		 for(int i=0;i<len;i++)
		 {
			 if(inorder[i] == rootValue)
			 {
				 inMiddle = i;
				 break;
			 }
		 }
		 //no needs here
//		 if(inMiddle ==-1)
//			 return null;
		 
		 
		 root.left =  helper(inorder,postorder,0,inMiddle-1,0,inMiddle-1);
		 root.right = helper(inorder,postorder,inMiddle+1,len-1,inMiddle,len-2);
	        
		 return root;
	 }
	 
	 private TreeNode helper(int[] inorder,int[] postorder,
			 int inStart,int inEnd, int postStart, int postEnd
			 )
	 {
		 if(inStart > inEnd || postStart > postEnd)
			 return null;
		 
		 int rootValue = postorder[postEnd];
		 
		 TreeNode root = new TreeNode(rootValue);
		 
		 int inMiddle = -1;
		 for(int i=inStart;i<=inEnd;i++)
		 {
			 if(inorder[i] == rootValue)
			 {
				 inMiddle = i;
				 break;
			 }
		 }
		 
		 int leftCount = inMiddle - inStart;
		 
		 root.left = helper(inorder,postorder,inStart,inMiddle-1, postStart, postStart + leftCount -1);
		 root.right = helper(inorder,postorder, inMiddle+1,inEnd,postStart+leftCount,postEnd-1);
		 		 
		 return root;
	 }
	 
	 public static void main(String args[])
	 {
//		 int[] inorder = {3,2,0,5,4};
//		 int[] postorder = {3,2,5,4,0};
		 int[] inorder = {2,1,3,0,5,4,6};
		 int[] postorder = {2,3,1,5,6,4,0};
		 ConstructBinaryTreefromInorderandPostorderTraversal ctt 
		 = new ConstructBinaryTreefromInorderandPostorderTraversal();
		 TreeNode root = ctt.buildTree(inorder, postorder);
		 
		 System.out.println("root:"+ root.val);
		 System.out.println("left:"+ root.left.val);
		 System.out.println("right:"+ root.right.val);
		 
		 
		 
	 }
	
}
