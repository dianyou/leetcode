import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class P347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
	        
        Map<Integer, Integer> map = new HashMap<>();  
        for(int num:nums) {  
            Integer cnt = map.get(num);  
            if(cnt == null) {  
                cnt = 0;  
            }  
            map.put(num, cnt+1);  
        }  
        Queue<Integer> pq = new PriorityQueue<Integer>(k+1,  new Comparator<Integer>(){  
            @Override  
            public int compare(Integer o1, Integer o2) {  
                return map.get(o1) - map.get(o2);  
            }  
        });  
          
        for(Integer key:map.keySet()) {  
            pq.offer(key);  
            if(pq.size() > k) {  
                pq.poll();  
            }  
        }  
          
        int size = Math.min(k, pq.size());  
        List<Integer> items = new ArrayList<Integer>();  
        
        
        for(int i=size-1; i>=0; i--) {  
            items.add( pq.poll());  
        }  
        return items;  
    	
    	
    }
    
    public static void main(String[] args)
    {
    	Scanner sc = new Scanner(System.in);
    	String s = sc.nextLine();
    	s = s.substring(1, s.length()-1);
    	
    	String[] ss = s.split(",");
    	
    	System.out.println(s);
    	System.out.println(ss.length);
    	
    	//初始化数组
    	int[] nums=new int[ss.length];
    	
    	for(int i=0;i<ss.length;i++)
    	{
    		nums[i]=Integer.parseInt(ss[i]);
    	}
    	
    	int k = Integer.parseInt(sc.nextLine());
    	
    	P347 test = new P347();
    	List<Integer> list = test.topKFrequent(nums, 2);
    	System.out.println(list.toString());
    }
	

}
