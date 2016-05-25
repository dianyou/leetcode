package test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class HashMapIterator {
	
	private Map<Node,Long> hm ; 
	
	static class Node
	{
		int row, col;
		public Node(int row,int col)
		{
			this.row = row;
			this.col = col;
		}
		public boolean equals(Object obj)
		{
			if(obj instanceof Node)
			{
				if(((Node)obj).row == this.row && ((Node)obj).col == this.col)
					return true;
			}
			return false;
		}
		@Override
		public int hashCode()
		{
			return (3*row+ 4*col);
		}
		
	}
	
	private HashMapIterator()
	{
		this.hm = new HashMap();
	}
	
	public Long get(int row, int col)
	{
//		Iterator it = (Iterator) hm.keySet().iterator();
//		while(it.hasNext())
//		{
//			Map.Entry entry = (Map.Entry)it.next();
//			Node key = (Node)entry.getKey();
//			Long value =(Long)entry.getValue();
//			if(key.row == row && key.col == col)
//			{
//				return value;
//			}
//		}
		Node n = new Node(row,col);
		if(hm.containsKey(n))
			return hm.get(n);
		else
			return new Long(0);
	}
	
	public void set(int row, int col, long value)
	{
		Node newNode = new Node(row,col);
		hm.put(newNode, new Long(value));
	}
	
	public static void main(String args[])
	{
		//hm = new ConcurrentHashMap<Node,Long>();
		Node n1 = new Node(2,3);
		Node n2 = new Node(4,3);
		Map<Node,Long> hm = new HashMap<Node,Long>();
		hm.put(n1, new Long(0));
	//	hm.put(n2, new Long(1));
		hm.put(n1, new Long(0));
		System.out.println("Results::"+hm.get(n2));
//		if(hm.containsKey(n2))
//		{
//		//	hm.replace(n1, (long) 3);
//			System.out.println("Same");
//		}
//		else
//		{
//			System.out.println("Opposite");
//		}
		
//		System.out.println(hm.containsKey(n2));
//		System.out.println(hm.get(n1));
		
	}

}
