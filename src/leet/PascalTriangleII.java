package leet;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
	/**
	 * recurison fomula
	 * @param rowIndex
	 * @return
	 */
    public List<Integer> getRow(int rowIndex) {
    	List<Integer> res = new ArrayList<Integer>();
    	if(rowIndex<0)
    		return res;
    	if(rowIndex==0)
    	{
    		res.add(1);
    		return res;
    	}
    	long per =1; //avoid outing of the Maxium with int
    	for(int i=0;i<=rowIndex;i++)
    	{
    		res.add((int) per);
    		per = per*(rowIndex-i)/(i+1);
    	}
    	return res;
        
    }
    public static void main(String args[])
    {
    	PascalTriangleII test = new PascalTriangleII();
    	List<Integer> res = test.getRow(30);
    	System.out.println(res.toString());
    }
}
