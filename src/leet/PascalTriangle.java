package leet;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) 
    {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if(numRows<=0)
    		return res;
    	
    	List<Integer> ar = new ArrayList<Integer>();
    	ar.add(1);
    	res.add(new ArrayList<Integer>(ar));
    	int num =2;
    	while(num<=numRows)
    	{
    		ar = res.get(num-1-1);
    		List<Integer> list = new ArrayList<Integer>();
    		for(int i=0;i<num;i++)
    		{
    			if(i==0 || i==num-1)
    				list.add(1);
    			else
    				list.add(ar.get(i)+ar.get(i-1));
    		}
    		res.add(list);
    		num++;
    	}
    	return res;    	
    }
    public static void main(String args[])
    {
    	PascalTriangle test = new PascalTriangle();
    	List<List<Integer>> res = test.generate(5);
    	System.out.println(res.toString());
    }
}
