
public class Solution345 {
    public String reverseVowels(String s) {
        StringBuilder reverseVowels = new StringBuilder();
        int left = 0,right=s.length()-1;
        char[] str = s.toCharArray();
        while(left<right)
        {
        	while(!chargeVowels(s.charAt(left))&&left<right)
        		left++;
        	while(!chargeVowels(s.charAt(right))&&left<right)
        		right--;
        	if(left<right)
        	{
//        		reverseVowels = new StringBuilder();
//        		for(int i=0;i<s.length();i++)
//        		{
//        			if(i ==right)
//        				reverseVowels.append(s.charAt(left));
//        			else if(i == left)
//        				reverseVowels.append(s.charAt(right));
//        			else
//        				reverseVowels.append(s.charAt(i));
//        		}
//            	s = reverseVowels.toString();
        		char temp;
        		temp = str[left];
        		str[left] = str[right];
        		str[right] = temp;
        		left++;
            	right--;
        	}
        	
        }
      //  System.out.println(s);
    	return String.valueOf(str);
    }
    
    public boolean chargeVowels(char c)
    {
    	//System.out.println(c);
    	if(c=='a'||c =='e'||c=='i'||c=='o'||c=='u')
    		return true;
    	if(c=='A'||c=='E'||c=='I'||c=='O'||c=='U')
    		return true;
    	return false;
    }
    
    public static void main(String args[])
    {
    	Solution345 test = new Solution345();
    	String s = test.reverseVowels("hello");
    	
    	System.out.println(s);
    	//System.out.println(test.reverseVowels("hello"));
    }
}
