package leet;

/**
 * 2016-08-02
 * @author Gavin
 *
 */
 
public class SearchA2DMatrixII {
	
	/**
	 * O(m*logN)
	 * binary search
	 * @param matrix
	 * @param target
	 * @return
	 */
    public boolean searchMatrixIII(int[][] matrix, int target) {
        if(matrix ==null || matrix.length==0)
        	return false;
        //search from top right corner
        int m = matrix.length,n=matrix[0].length;
        if(n==0)
        	return false;
        for(int i=0;i<m;i++)
        {
        	if(target == matrix[i][n-1])
        		return true;
        	if(target > matrix[i][n-1])
        		continue;
        	boolean flag = binarySearch(matrix[i],target);
        	if(flag)
        		return true;
        }
        return false;
        
    }
    
    private boolean binarySearch(int[] arr,int target)
    {
    	int left=0,right=arr.length-2;
    	while(left <=right)
    	{
    		int middle = left+(right-left)/2;
    		if(arr[middle]==target)
    			return true;
    		if(arr[middle]>target)
    			right = middle-1;
    		else
    			left = middle+1;
    	}
    	return false;
    }
    
    /**
     * O(m+n)
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrixII(int[][] matrix, int target) {
        if(matrix ==null || matrix.length==0)
        	return false;
        //search from top right corner
        //go left, and go down
        int m = matrix.length,n=matrix[0].length;
        if(n==0)
        	return false;
        for(int i=0;i<m;i++)
        {
        	if(target == matrix[i][n-1])
        		return true;
        	for(int j=0;j<n;j--)
        	{
        		if(n<=0)
            		return false;
        		if(target ==matrix[i][n-1])
        			return true;
        		if(target <matrix[i][n-1])
        			n--;
        		else
        			break;
        	}
        
        	
        }
        return false;
        
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix ==null || matrix.length==0)
        	return false;
        //search from top right corner
        //go left, and go down
        int m = matrix.length,n=matrix[0].length;
        if(n==0)
        	return false;
        int left=0,top=0;
        int right =n-1,down=m-1;
        return helper(matrix,target,left,right,top,down);
        
    }
    //not accepted yet!!!!
    private boolean helper(int[][] matrix,int target,int left,int right,
    		int top,int down)
    {
    	if(left>right || top >down)
    		return false;
    	if(left ==right && top==down)
    	{
    		return matrix[left][top]==target;
    	}
    	//horizontal
        int Hmiddle=left+(right-left)/2;
        //vertical
        int Vmiddle = top+(down-top)/2;
        
        
        System.out.println("left::"+left);
        System.out.println("right::"+right);
        System.out.println("top::"+top);
        System.out.println("down::"+down);
        System.out.println("Hmiddle::"+Hmiddle);
        System.out.println("Vmiddle::"+Vmiddle);
        if(matrix[Hmiddle][Vmiddle]>target)
        {
        	return 
        		(helper(matrix,target,left,Hmiddle-1,top,Vmiddle-1)
        		|| helper(matrix,target,left,Hmiddle-1,Vmiddle,down)		
        		|| helper(matrix,target,Hmiddle,right,top,Vmiddle-1)	
        		);
        }
        else if(matrix[Hmiddle][Vmiddle]<target)
        {
        	return ( helper(matrix,target,Hmiddle+1,right,Vmiddle+1,down)
        		|| helper(matrix,target,left,Hmiddle,Vmiddle+1,down)		
            	|| helper(matrix,target,Hmiddle+1,right,top,Vmiddle)
        			);
        }
    	return false;
        
    }
    
    public static void main(String args[])
    {
    	int[][] matrix = {{1,1}};
    	int target = 2;
    	SearchA2DMatrixII test = new SearchA2DMatrixII();
    	boolean flag =test.searchMatrix(matrix, target);
    	System.out.println(flag);
    	
    	
    }
    

}
