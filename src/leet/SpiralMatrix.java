package leet;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix{

    public List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> list = new LinkedList<Integer>(); 
    	if(matrix==null || matrix.length==0)
    		return list;
    	int endRow = matrix.length-1;
    	int endCol = matrix[0].length-1;
    	int startRow = 0,startCol=0;
        while(startRow<=endRow && startCol<=endCol)
        {
        	for(int i=startCol;i<=endCol;i++)
        	{
        		list.add(matrix[startRow][i]);
                System.out.println("here1::"+matrix[startRow][i]);
        	}
        	for(int i=startRow+1;i<=endRow;i++)
        	{
        		list.add(matrix[i][endCol]);
                 System.out.println("here2::"+ matrix[i][endCol]);
        	}
            //in case one column or one row
            if(startRow==endRow || startCol == endCol)
                break;
        	for(int i=endCol-1;i>=startCol;i--)
        	{
        		list.add(matrix[endRow][i]);
                System.out.println("here3::"+ matrix[endRow][i]);
        	}
        	for(int i=endRow-1;i>startRow;i--)
        	{
        		list.add(matrix[i][startCol]);
                System.out.println("here4::"+ matrix[i][startCol]);
        	}
        	startRow++;
        	startCol++;
        	endRow--;
        	endCol--;
        }
        return list;
    }
    public static void main(String args[])
    {
    	int[][] matrix = {{2,3}};
    	SpiralMatrix test = new SpiralMatrix();
    	test.spiralOrder(matrix);
    }

}