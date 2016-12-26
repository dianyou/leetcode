package leet;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 * @author I301431
 * 2016-12-15
 * boring....
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
    	if(s == null || s.length() <=1||numRows <=1)
    	{
    		return s;
    	}
    	StringBuilder sb = new StringBuilder();
    	int offset = 2*numRows -2;
    	for(int i=0;i<numRows;i++){
    		for(int j=i;j<s.length();j+=offset)
    		{
    			sb.append(s.charAt(j));
    			//the z path
    			if(i != 0 && i!= numRows-1)
    			{
    				int temp = j + offset -2*i;
    				if(temp < s.length())
    					sb.append(s.charAt(temp));
    			}
    		}
    	}
    	return sb.toString();
        
    }
    
    public static void main(String args[])
    {
    	ZigZagConversion test = new ZigZagConversion();
    	String s = "PAYPALISHIRING";
    	String result = test.convert(s, 3);
    	System.out.println(result);
    }
}
