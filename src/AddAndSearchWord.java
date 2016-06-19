import java.util.LinkedList;



public class AddAndSearchWord {
	TrieNode root;
	
	  public AddAndSearchWord() {
		    root = new TrieNode();
		  }

	
	//定义树节点结构
	static class TrieNode
	{
		LinkedList<TrieNode> childNode;
		char letter;
		boolean isEnd;
		
		public TrieNode()
		{
			this.letter = 0;
			this.isEnd = false;
			this.childNode = new LinkedList<TrieNode>();
		}
		
		public TrieNode(char c)
		{
			this.letter = c;
			this.isEnd = false;
			this.childNode = new LinkedList<TrieNode>();
		}

	
		public TrieNode subNode(char c)
		{
			for(TrieNode tn : childNode)
			{
				if(tn.letter == c){
					return tn;
				}
			}
			return null;
		}
	}
	
    // Adds a word into the data structure.
    public void addWord(String word) {
    	TrieNode tn = root;
    	for(int i=0;i<word.length();i++)
    	{	
    		TrieNode temp = tn.subNode(word.charAt(i));
    		if(temp!=null)
    		{
    			tn = temp;
    			continue;
    		}
    		else
    		{
    		
    			for(int j = i;j<word.length();j++)
    			{
    				TrieNode addedTrie = new TrieNode(word.charAt(j));
    				if(j == word.length()-1)
        				addedTrie.isEnd = true;
    				tn.childNode.add(addedTrie);
    				tn = addedTrie;
    			}
    			break;
    			//tn.childNode.add(addedTrie);
    			//tn = tn.subNode(word.charAt(i));
    			
    		}
    	}
        
    }
	
    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
   public boolean search(String word) {
    	
    	return dfs(word,0,root);
    }
    
    public boolean dfs(String word,int pos,TrieNode start)
    {
    	char c = word.charAt(pos);
    	int len = word.length();    
//		System.out.println("haha");
//		System.out.println(c);
//		System.out.println("hehe");
//		System.out.println(start.letter);
    	if(start.childNode.size() ==0)
    		return false;
    	if(c == '.')
    	{
    		if(pos == len-1)//最后一个字符
    		{
    			 for (TrieNode next : start.childNode) {
                  	  if(true == next.isEnd)
                  		  return true;
                    }
    			
    			return false;
    		}
    		else
    		{
    			 for (TrieNode next : start.childNode) {
               	  if(true == dfs(word, pos + 1,next))
               		  return true;
                 }
               return false;
    		}
    	}
    	else
    	{
    		if( pos == len-1)
    		{
    			 for (TrieNode next : start.childNode) {
                 	  if(true == next.isEnd && next.letter == c)
                 		  return true;
                   }
    			 return false;
    		}
    		else
    		{
    			TrieNode temp = start.subNode(c);
            	if(temp==null)
            	{
            		return false;
            	}
            	else
            	{
            		return dfs(word,pos+1,temp);
            	}
    		}
    		
    	}
    	
    }

	public void BFSTraverse()
	{
		int level = 0;
		if(root.childNode.size()==0)
			return;
		LinkedList<TrieNode> currentList = new LinkedList<TrieNode>();//当前层级的节点
		currentList.add(root);
		LinkedList<TrieNode> nextList;
		
		while(currentList.size()>0)
		{
			level++;
	//		System.out.println("Level::" + level);
			nextList = new LinkedList(); //将要遍历的节点
			for(TrieNode tn : currentList)
			{
	//			System.out.println(tn.letter+"("+tn.isEnd+")");
				if(tn.childNode.size()>0)
				{
					nextList.addAll(tn.childNode);
				}
			}
			currentList = nextList;
		}
		
	}

    
    
    public static void main(String args[])
    {
    	AddAndSearchWord test = new AddAndSearchWord();
//    	String s = "a";
//    	System.out.println(s.charAt(1));
    	test.addWord("at");
    	test.addWord("and");
    	test.addWord("an");
    	test.addWord("add");
    	test.addWord("bat");
    	test.BFSTraverse();
    	
//      	System.out.println(test.search("a"));
//    	System.out.println(test.search("a."));
//    	System.out.println(test.search("ab"));
//    	System.out.println(test.search(".a"));
//    	System.out.println(test.search(".b"));
//    	System.out.println(test.search("ab."));
//    	System.out.println(test.search("."));
//    	System.out.println(test.search(".."));
//    	System.out.println(test.search(".at"));
    	
    }
		
}
    

    
    
    
 
