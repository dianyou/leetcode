package leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RussianDollEnvelopes {
	
	
	 static class Node{
		 int w;
		 int h;
		 Node(int w,int h)
		 {
			 this.w = w;
			 this.h = h;
		 }
		 public String toString()
		 {
			 return "w:"+w+",h::"+h;
		 }
	 }
	
	  public int maxEnvelopes(int[][] envelopes) {
	        if(envelopes==null ||envelopes.length==0)
	        	return 0;
	        List<Node> list = new ArrayList<Node>();
	        for(int i=0;i<envelopes.length;i++)
	        {
	        	Node node = new Node(envelopes[i][0],envelopes[i][1]);
	        	list.add(node);
	        }
	        Collections.sort(list,new Comparator<Node>(){

				@Override
				public int compare(Node o1, Node o2) {
					// TODO Auto-generated method stub
					return o1.w==o2.w? (o2.h-o1.h) :(o1.w-o2.w);
				}        	
	        });	     
	        
	        int maxium =1;
	        return maxium;
	  
	  }
	  public int maxEnvelopesII(int[][] envelopes) {
	        if(envelopes==null ||envelopes.length==0)
	        	return 0;
	        List<Node> list = new ArrayList<Node>();
	        for(int i=0;i<envelopes.length;i++)
	        {
	        	Node node = new Node(envelopes[i][0],envelopes[i][1]);
	        	list.add(node);
	        }
	        Collections.sort(list,new Comparator<Node>(){

				@Override
				public int compare(Node o1, Node o2) {
					// TODO Auto-generated method stub
					return o1.w==o2.w? (o1.h-o2.h) :(o1.w-o2.w);
				}
	        	
	        });	     
	        for(int i=0;i<list.size();i++)
	        {
	        	System.out.println(list.get(i).toString());
	        }
	        
	        int[] maxLen = new int[list.size()];
	        maxLen[list.size()-1] = 1;
	        int maxium =1;
	        for(int i=list.size()-2;i>=0;i--)
	        {
	        	  Node cur = list.get(i);
	        	  int curMax = 1;
	    		  for(int j=i+1;j<list.size();j++)
	    		  {
	    			  Node temp = list.get(j);
	    			  if(temp.w>cur.w && temp.h>cur.h)
	    			  {
	    				  if((maxLen[j]+1)>curMax)
	    					  curMax = maxLen[j]+1;
	    			  }
	    		  }
	    		  maxLen[i] = curMax;
	    		  if(curMax>maxium)
	    			  maxium =curMax;
	    		  
	        }
	        return maxium;
	  
	  }
	  
	  public static void main(String args[])
	  {
		  RussianDollEnvelopes test = new RussianDollEnvelopes();
		  int[][] arr ={{5,4},{6,4},{6,7},{2,3}};
		  int res = test.maxEnvelopes(arr);
		  System.out.println(res);
	  }

}
