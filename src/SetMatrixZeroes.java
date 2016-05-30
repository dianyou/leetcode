
/**
 * https://leetcode.com/problems/set-matrix-zeroes/
 * @author Gavin
 *	2016-5-30
 *	只使用O（1）的空间！遍历数组，当找到第一个matrix[i][j]=0时，使用第i行第j列存储置换信息
 */
public class SetMatrixZeroes {
	
    public void setZeroes(int[][] matrix) {
    	if(matrix == null)
    		return ;
    	if(matrix[0] == null)
    		return ;
    	if(matrix.length ==0 || matrix[0].length == 0)
    		return;
    	
    	int a=0,b=0;//第一个"0"的位置
    	boolean flag=false; //标识是否有0
    	for(int i=0;i<matrix.length;i++)//标识行
    		for(int j=0;j<matrix[0].length;j++)//标识列
    		{
    			if(matrix[i][j]!=0)
    				continue;
    			if(!flag)
    			{
    				flag = true;
    				a = i;
    				b = j;
    			}
    			else
    			{
    				matrix[a][j] = 0;
    				matrix[i][b] = 0;
    			}
    		}
    	if(!flag)//没有0
    		return;

//    	System.out.println(a+","+b);
//    	for(int i=0;i<matrix.length;i++)
//    	{
//    		for(int j = 0;j<matrix[0].length;j++)
//    		{
//    			System.out.print(matrix[i][j]+",");
//    		}
//    		System.out.println();
//    	}
//    	System.out.println();
    	
        //遍历matrix[a],置换目标列
    	for(int j =0;j<matrix[a].length;j++)
    	{
    		if(matrix[a][j] != 0)
    			continue;
    		if(b==j)
    			continue;
    		for(int i = 0;i<matrix.length;i++)
    		{
    			matrix[i][j] = 0;
    		}
    	}
    	//遍历matrix[][b]
    	for(int i=0;i<matrix.length;i++)
    	{
    		if(i==a)
    			continue;
    		if(matrix[i][b]!=0)
    			continue;
    		for(int j=0;j<matrix[0].length;j++)
    		{
    			matrix[i][j] = 0;
    		}
    	}
    	//将第a行，第b列置换为0
    	for(int i=0;i<matrix.length;i++)
    	{
    		matrix[i][b] = 0;
    	}
    	for(int j=0;j<matrix[0].length;j++)
    	{
    		matrix[a][j] = 0;
    	} 
    	
    }
    public static void main(String args[])
    {
    	int matrix[][]={{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
    	SetMatrixZeroes test = new SetMatrixZeroes();
    	test.setZeroes(matrix);
    	for(int i=0;i<matrix.length;i++)
    	{
    		for(int j = 0;j<matrix[0].length;j++)
    		{
    			System.out.print(matrix[i][j]+",");
    		}
    		System.out.println();
    	}
    	
    }

}
