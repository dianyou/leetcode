package leet;

/**
 * https://leetcode.com/problems/add-binary/
 * @author I301431
 * 2016-12-27
 */
public class AddBinary {
    public String addBinary(String a, String b) {
    	if(a == null || b==null)
    		return null;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i=a.length()-1, j=b.length()-1;
        while(i>=0 || j>=0)
        {
        	int sum = carry;
        	if(i>=0)
        		sum +=(a.charAt(i)-'0');
        	if(j>=0)
        		sum += (b.charAt(j) - '0');
        	sb.append(sum%2);
        	carry = sum/2;
        	i--;
        	j--;
        }
        if(carry != 0)
        	sb.append(carry);
        return sb.reverse().toString();
        
    }
}
