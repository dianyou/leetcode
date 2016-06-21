package leet;
import java.util.HashSet;
import java.util.Set;

public class ValidSudoku36 {
	/**
	 * 网上有解法用�??历行，�??历列，�??历�?宫格的方法；这�?解法会有大�?的�?�?访问节点的情况
	 * 根�?�规则，�?�一个数字出现的�?置�?能在�?�一行，�?�一列，所以为1-9这些数字�?始化9个Node，
	 * �?�个Node都有三个属性，分别为“行�?，“列�?，“宫�? 记录他们的�?置，使用HashSet
	 * @param board
	 * @return
	 * 2016-5-24
	 * Gavin
	 */
	private static class Node{
		/**
		 * 无须使用内部类的，�?始化三个数组就好了
		 */
		private int num;
		private Set<Integer> row;
		private Set<Integer> col;
		private Set<Integer> gong;
		
		public Node(int num)
		{
			this.num = num;
			row = new HashSet<Integer>();
			col = new HashSet<Integer>();
			gong = new HashSet<Integer>();
		}
		
	}
	
    public boolean isValidSudoku(char[][] board) {
    	if(board == null || board.length ==0)
    		return false;
    	if(board.length != 9 && board[0].length !=9)
    		return false;
    	Node[] nodes = new Node[10];
    	//�?始化数字节点
    	for(int i=1;i<10;i++)
    	{
    		nodes[i] = new Node(i);
    	}
    	for(int i=0;i<9;i++)
    		for(int j=0;j<9;j++)
    		{
    			if(board[i][j] == '.')
    				continue;
    			int num = board[i][j] - '0';
    			/**
    			 * 为“宫�?编�?�：(i/3)*3 + (j/3)
    			 */
    			int gNum = (i/3)*3 + (j/3);
    			if( nodes[num].row.contains(i) || nodes[num].col.contains(j)
    					|| nodes[num].gong.contains(gNum))
    					return false;
    			
    			nodes[num].row.add(i);
    			nodes[num].col.add(j);
    			nodes[num].gong.add(gNum);
    		}
        return true;
    }
    public static void main(String args[])
    {
    	Node[] nodes = new Node[10];
    	for(int i=1;i<10;i++)
    	{
    		nodes[i] = new Node(i);
    		System.out.println(nodes[i].num);
    	}
    	
    }

}
