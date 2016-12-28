package leet;

public class PlusOne {
    public int[] plusOneSlow(int[] digits) {
    	if(digits == null || digits.length ==0)
    		return null;
    	int carry = 1;
    	int len = digits.length;
    	int result[] = new int[len];
    	
    	for(int i=len-1;i>=0;i--)
    	{
    		int sum = carry;
    		sum += digits[i];
    		result[i] = sum %10;
    		carry = sum/10;
//    		if(carry == 0) //no carries, just break
//    			break;
    	}
    	
    	if(carry == 0)
    		return result;
    	else
    	{
    		int others[] = new int[len+1];
    		System.arraycopy(result, 0, others, 1,len);
    		others[0] = carry;
    		return others;
    		
    	}
    }
    
    
    //this is great!!!
    public int[] plusOne(int[] digits) {
        
        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            
            digits[i] = 0;
        }
        
        int[] newNumber = new int [n+1];
        newNumber[0] = 1;
        
        return newNumber;
    }
}
