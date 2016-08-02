package leet;

public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
    	if(n<0)
    		return null;
        int start =0,end=n-1;
        int matrix[][] = new int[n][n];
        if(n==0)
        	return matrix;
        int k=1;
        while(start<=end)
        {
        	// first horizontal
        	for(int i=start;i<=end;i++)
        		matrix[start][i]= k++;
        	//last vertical
        	for(int i=start+1;i<=end;i++)
        		matrix[i][end] = k++;
        	if(start == end)
        		return matrix;
        	//last horizontal
        	for(int i=end-1;i>=start;i--)
        		matrix[end][i] = k++;
        	//first vertical
        	for(int i=end-1;i>start;i--)
        		matrix[i][start]=k++;
        	start++;
        	end--;
        	
        }
        return matrix;
        
    }
    public static void main(String args[])
    {
    	SpiralMatrixII test = new SpiralMatrixII();
    	int n=0;
    	int[][] matrix = test.generateMatrix(n);
    	for(int i=0;i<n;i++)
    	{
    		for(int j=0;j<n;j++)
    			System.out.print(matrix[i][j]+" ");
    		System.out.println();
    	}
    		
    }
}
