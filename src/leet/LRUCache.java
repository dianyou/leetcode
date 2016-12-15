package leet;

import java.util.HashMap;
//import java.util.Map.Entry;

/**
 * https://leetcode.com/problems/lru-cache/
 * @author I301431
 * 2016-10-18
 * @param <K>
 * @param <V>
 */

public class LRUCache {
	
	private static class Node{
		int key;
		int value;
		Node before, after;
		Node(int key, int value)
		{
			this.key = key;
			this.value = value;
			before = after = null;
		}
	}
	
	private HashMap<Integer, Node> cache;
	private Node head;
	public int capacity;
	
	public LRUCache(int capacity)
	{
		this.capacity = capacity;
		cache = new HashMap<Integer,Node>();
		head =  null;
	}
	
	public int get(int key)
	{
		if(cache.containsKey(key))
		{
			if(head.key == key)
			{
				return head.value;
			}
			Node node = cache.get(key);
			node.before.after = node.after;
			node.after.before = node.before;
			
			if(head.after.key == head.key)
			{
				node.before = head;
				node.after = head;
				head.before = node;
				head.after = node;
			}
			else
			{
				node.after = head;
				node.before = head.before;
				head.before.after = node;
				head.before = node;
			}
			
			
			head = node;
			
			
			return node.value;
		}
		else
		{
			return -1;
		}
		
	}
	
	public void set(int key,int value)
	{
		if(head == null)
		{
			head = new Node(key,value);
			head.before = head;
			head.after = head;
			cache.put(key, head);
			return;
		}
		
		if(cache.containsKey(key))
		{
			Node node = cache.get(key);
			node.value = value;
			
			node.before.after = node.after;
			node.after.before = node.before;
			
			if(head.after.key == head.key)
			{
				node.before = head;
				node.after = head;
				head.before = node;
				head.after = node;
			}
			else
			{
				node.after = head;
				node.before = head.before;
				head.before.after = node;
				head.before = node;
			}
			head = node;
			
			cache.put(key, node);
		}
		else
		{
			Node node = new Node(key,value);
			int size = cache.size();
			if(size < capacity)
			{
				
				if(head.key == head.after.key)
				{
					node.before = head;
					node.after = head;
					head.before = node;
					head.after = node;
				}
				else
				{
					node.after = head;
					node.before = head.before;
					head.before.after = node;
					head.before = node;
				}
				head = node;
				cache.put(key, node);
				
			}
			else
			{
				//remove the tail
				int removeKey = head.before.key;
				System.out.println("head:"+head.key);
				System.out.println("Remove key:"+removeKey);
				System.out.println("head.before:"+head.before.key);
				head.before.before.after = head;
				head.before = head.before.before;
				//add the new node
				node.after = head;
				node.before = head.before;
				head.before.after = node;
				head.before = node;
				head = node;
				
				cache.remove(removeKey);
				cache.put(key, node);
				
			}
		}
		
	}
	
    //2,[set(2,1),set(1,1),set(2,3),set(4,1),get(1),get(2)]
    //[1,3]
    //expected: [-1,3]
    public static void main(String args[])
    {
    	Node node = null;
    	LRUCache lc = new LRUCache(3);
    	lc.set(1, 1);
    	
    	lc.set(2,2);
    	node = lc.head;
    	do
    	{
    		System.out.println(node.key+"=("+node.key+","+node.value+")");
    		node = node.before;
    	}while(node.key != lc.head.key);
    	
    	System.out.println(lc.cache);
    	
    	lc.set(3,3);
    	node = lc.head;
    	do
    	{
    		System.out.println(node.key+"=("+node.key+","+node.value+")");
    		node = node.before;
    	}while(node.key != lc.head.key);
    	System.out.println(lc.cache);
    	
    	lc.set(4,4);
    	node = lc.head;
    	do
    	{
    		System.out.println(node.key+"=("+node.key+","+node.value+")");
    		node = node.before;
    	}while(node.key != lc.head.key);
    	System.out.println(lc.cache);
    	
    	System.out.println(lc.get(1));
    	System.out.println(lc.get(2));
//    	
//    	System.out.println();
//    	System.out.println("head:"+lc.head.key);
//    	System.out.println("tail:"+lc.tail.key);
//    	for(Integer key:lc.cache.keySet())
//    	{
//    		System.out.println(key+"=("+key+","+lc.cache.get(key).value+")");
//    	}
//    	System.out.println(lc.get(3));
//    	
//    	System.out.println();
//    	System.out.println("head:"+lc.head.key);
//    	System.out.println("tail:"+lc.tail.key);
//    	for(Integer key:lc.cache.keySet())
//    	{
//    		System.out.println(key+"=("+key+","+lc.cache.get(key).value+")");
//    	}
//    	
//    	System.out.println(lc.get(4));
//    	
//    	System.out.println();
//    	System.out.println("head:"+lc.head.key);
//    	System.out.println("tail:"+lc.tail.key);
//    	for(Integer key:lc.cache.keySet())
//    	{
//    		System.out.println(key+"=("+key+","+lc.cache.get(key).value+")");
//    	}
    	
    	
//    	LRUCache lc = new LRUCache(2);
//    	lc.set(2, 1);
//    	System.out.println("cache::");
//    	for(Integer key:lc.cache.keySet())
//    	{
//    		System.out.println(key+"=("+key+","+lc.cache.get(key).value+")");
//    	}
//    	
//    	lc.set(1,1);
//    	System.out.println("cache::");
//    	for(Integer key:lc.cache.keySet())
//    	{
//    		System.out.println(key+"=("+key+","+lc.cache.get(key).value+")");
//    	}
//    	
//    	lc.set(2,3);
//    	System.out.println("cache::");
//    	for(Integer key:lc.cache.keySet())
//    	{
//    		System.out.println(key+"=("+key+","+lc.cache.get(key).value+")");
//    	}
//    	
//    	lc.set(4, 1);
//    	System.out.println("cache::");
//    	for(Integer key:lc.cache.keySet())
//    	{
//    		System.out.println(key+"=("+key+","+lc.cache.get(key).value+")");
//    	}
//    	
//    	System.out.println(lc.get(1));
//    	System.out.println(lc.get(2));
    	
    }

}

/* TLE
public class LRUCache {
	private Map<Integer,Integer> cache;
	private List<Integer> list;
	private int capacity;
	
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
    	list = new LinkedList<Integer>();
    	cache = new HashMap<Integer,Integer>();
        
    }
	
    public int get(int key) {
    	
    	if(cache.containsKey(key))
    	{
    		//meaning key is used, it should adjust the order of List
    		int k = Math.min(capacity, list.size());
    		for(int i=0;i<k;i++)
    		{
    			if(list.get(i) == key)
    			{
    				list.remove(i);
    				break;
    			}
    		}
        	list.add(0, key);
        	
    		return cache.get(key);
    	}
    		
    	else
    		return -1;
    }
    
    public void set(int key, int value) {
    	
    	cache.put(key, value);
    	int k = list.size();
    	if(k ==0)
    	{
    		list.add(key);
    		return;
    	}
    	if(list.get(0) == key)
			return;
    	
    	if(k<capacity)
    	{
    		
    		for(int i=0;i<k;i++)
    		{
    			Integer node = list.get(i);
    			if(node.intValue() == key)
    			{
    				list.remove(i);
    				break;
    			}
    		}
        	list.add(0, key);
    	}
    	else
    	{
    		boolean hit = false;
    		for(int i=0;i<capacity;i++)
    		{
    			if(list.get(i) == key)
    			{
    				hit = true;
    				list.remove(i);
    				break;
    			}
    		}
    		if(!hit)
    		{
    			cache.remove(new Integer(list.get(capacity-1)));
    		}
    		list.add(0,key);
    		
    	}
    }
    
    //2,[set(2,1),set(1,1),set(2,3),set(4,1),get(1),get(2)]
    //[1,3]
    //expected: [-1,3]
    
    public static void main(String args[])
    {
//    	LRUCache lc = new LRUCache(2);
//    	lc.set(2, 1);
//    	System.out.println(lc.list);
//    	lc.set(1,1);
//    	System.out.println(lc.list);
//    	lc.set(2,3);
//    	System.out.println(lc.list);
//    	lc.set(4, 1);
//    	System.out.println(lc.list);
//    	System.out.println(lc.get(1));
//    	System.out.println(lc.list);
//    	System.out.println(lc.get(2));
//    	System.out.println(lc.list);
    	
    	Integer in = new Integer(109);
    	System.out.println(in==109);
    }
    
}*/
