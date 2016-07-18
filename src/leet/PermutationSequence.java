package leet;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 2016-07-18
 * @author I301431
 *
 */
public class PermutationSequence
{
	
    public String getPermutation(int n, int k) {
    	if(n<=0 || k<=0)
    		return null;
    	int factorial[] = new int[n];
    	//initialize the value of factorial for n-1
    	factorial[0]=1;
    	for(int i=1;i<n;i++)
    	{
    		factorial[i] = factorial[i-1]*i;
    	}
    	ArrayList<Integer> ar = new ArrayList<Integer>();
    	for(int i=0;i<n;i++)
    		ar.add(i+1);
    	k--; //make the index start from 0
        StringBuilder sb = new StringBuilder("");
        for(int i=n-1;i>=0;i--)
        {
        	int base = factorial[i];
        	int temp = (k/base);
        	k = k% base;
        	sb.append(ar.get(temp));
        	ar.remove(temp);
        }
        return sb.toString();
    }

    
    public static void main(String[] args)
    {
//    	ArrayList<Integer> ar = new ArrayList<Integer>();
//    	for(int i=0;i<10;i++)
//    	{
//    		ar.add(i);
//    	}
//    	System.out.println(ar.get(0)); //0
    	PermutationSequence test = new PermutationSequence();
    	String s = test.getPermutation(8, 8590);
    	System.out.println(s);
    }
}