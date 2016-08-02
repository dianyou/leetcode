package leet;

public class SearchA2DMatrix {
	
	public boolean searchMatrix2(int[][] matrix, int target)
	{
    	if(matrix ==null || matrix.length==0)
    		return false;
    	int m = matrix.length;
    	int n = matrix[0].length;
    	int left=0,right=m*n-1;
    	while(left <=right)
    	{
    		int middle = left + (right -left)/2;
    		int val = matrix[middle/n][middle%n];
    		if(val==target)
    			return true;
    		if(val < target)
    		{
    			left = middle +1;
    		}
    		else
    		{
    			right = middle-1;
    		}
    	}
    	return false;
	}
    public static void main(String ars[])
    {
    	int[][] matrix = {{1,3}};
    	SearchA2DMatrix test = new SearchA2DMatrix();
    	boolean res = test.searchMatrix(matrix, 3);
    	System.out.println(res);
    }
	
	
  //	binary search.... more effctive
    public boolean searchMatrix(int[][] matrix, int target) 
    {
    	if(matrix ==null || matrix.length==0)
    		return false;
    	int m = matrix.length;
    	int n = matrix[0].length;
    	return binarySearch(matrix,0,0,m-1,n-1,target);
    }
    private boolean binarySearch(int[][] matrix,int leftRow, int leftCol,
    				int rightRow,int rightCol,int target)
    {
    	
    	if(target>=matrix[leftRow][leftCol] && target <= matrix[rightRow][rightCol])
    	{
    		while(leftRow<=rightRow)
    		{
   				int middleRow = leftRow +(rightRow - leftRow)/2;
    			int middle = matrix[middleRow][0];
    			if(middle == target)
    				return true;
    			if(middle>target)
    			{
    				rightRow = middleRow-1;
    			}
    			else
    			{
    				int middleRight = matrix[middleRow][matrix[0].length-1];
    				if(middleRight == target)
    					return true;
    				else if(middleRight > target)
    				{
    					rightRow = middleRow;
    					leftRow = middleRow;
    					break;
    				}
    				else
    					leftRow = middleRow+1;
    			}
    				
    		}
    		
			while(leftCol<=rightCol)
			{
					int middleCol = leftCol+(rightCol-leftCol)/2;;
					int middle = matrix[leftRow][middleCol];
					if(middle == target)
						return true;
					if(middle<target)
					{
						leftCol = middleCol+1;
					}
					else
					{
						rightCol = middleCol-1;
					}
			}
			return false;
					
    	}
    	else
    		return false;
    }

}
