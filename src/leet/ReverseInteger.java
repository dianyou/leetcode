package leet;

/**
 * https://leetcode.com/problems/reverse-integer/
 *
 */
public class ReverseInteger {

    public int reverse(int x) {
        int reversed_n = 0;
        
        while (x != 0) {
            int temp = reversed_n * 10 + x % 10;
            x = x / 10;
            if (temp / 10 != reversed_n) {//处理越界
                reversed_n = 0;
                break;
            }
            reversed_n = temp;
        }
        return reversed_n;
    }
    
    public static void main(String args[])
    {
    	int x = 1534236469;
    	ReverseInteger test = new ReverseInteger();
    	int result = test.reverse(x);
    	System.out.println(result);
    
    }
}
