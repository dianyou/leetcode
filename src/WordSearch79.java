
public class WordSearch79 {
	  public boolean exist(char[][] board, String word) {
	        if(word.length()==0)
	        	return false;
	        if(board == null)
	        	return false;
	        int y = board.length;
	        if(y == 0)
	        	return false;
	        int x = board[0].length;
	        if(x == 0)
	        	return false;
	        boolean flag = false;
	        //寻找所有递归的起点
	        for(int i=0;i<y;i++)
	        	for(int j = 0;j<x;j++)
	        	{
	        		if(word.charAt(0)== board[i][j])
	        		{
	        		    boolean[][] memo = new boolean[y][x];
	        		    flag = search(memo,board,i,j,word,0);
	        		}
	        		if(flag == true)
	        			return true;
	        	}
	        return false;
	    }
	    
	    public boolean search(boolean[][] memo,char[][] board, int y,int x, String word,int pos)
	    {
	    
	 //   	System.out.println("Search::"+word.charAt(pos));
	    	if(board[y][x] != word.charAt(pos))
	    		return false;    	
	    	else if(pos == word.length()-1)
	    			return true; 
	    	pos++;
	    	memo[y][x] = true;
	    	if(y+1<board.length && memo[y+1][x]==false){
	    		if( search(memo,board,y+1,x,word,pos))
	    			return true;
	    //		memo[y][x] = false;
	    	}
	    	if(x+1<board[0].length && memo[y][x+1] == false){
	    		if( search(memo,board,y,x+1,word,pos))
	    			return true;
	    //		memo[y][x] = false;
	    	}
	    	if(x-1>=0 && memo[y][x-1] == false){
	    		if( search(memo,board,y,x-1,word,pos))
	    			return true;
	   // 		memo[y][x] = false;
	    	}
	     	if(y-1>=0 && memo[y-1][x] == false){
	    		if( search(memo,board,y-1,x,word,pos))
	    			return true;
	    	
	    	}
	    		memo[y][x] = false;
			return false;
	    }
    
    public static void main(String[] args)
    {
//    	char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//    	String word = "ABCCED";
    	
    	char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
    	String word = "ABCB";
    	
    	WordSearch79 test = new WordSearch79();
    	System.out.println("Result::"+test.exist(board, word));
    	
    	
//        int y = board.length;
//        int x = board[0].length;
//    	for(int i = 0;i<y;i++)
//    		for(int j=0;j<x;j++)
//    			System.out.println(board[i][j]);
    }
    
}
