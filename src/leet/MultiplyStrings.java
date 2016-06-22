
package leet;
/**
 * https://leetcode.com/problems/multiply-strings/
 * @author Gavin
 *	2016-06-13
 *	不要直接把字符串转换成整数，不要使用大数类型
 */
public class MultiplyStrings {
	/**
	 * 模拟手算的办法太笨了，观察运算过程可以发现
	 * 结果第i+j位的数值是（n1[i]*n2[j]+n1[i-1]*n2[j+1]+....）
	 * @param num1
	 * @param num2
	 * @return
	 */
    public String multiply(String num1, String num2) {
    	if(num1==null ||num2 ==null)
    		return null;
    	if(num1.length()==0 || num2.length() == 0)
    		return null;
    	
        char[] c1= new StringBuilder(num1).reverse().toString().toCharArray();
        char[] c2 = new StringBuilder(num2).reverse().toString().toCharArray();
        int[] results = new int[c1.length + c2.length+1];
        for(int i=0;i<c1.length;i++)
        {
			int carry = 0;
        	for(int j=0;j<c2.length;j++)
        	{
        	//	System.out.println("Before::"+(i+j)+","+results[i+j]);
				//carry携带上一位运算的进位
				int product = results[i+j]+(c1[i]-'0')*(c2[j]-'0') +carry;
				//System.out.println(product);
				carry = product /10;
				results[i+j] = product %10;
		//		System.out.println("After::"+(i+j)+","+results[i+j]);
        	}
			results[i+c2.length] = carry;
		//	System.out.println("Last carry::"+carry);
        }
		StringBuilder sb = new StringBuilder();
		int index = results.length-1;
		while(index >=0 &&results[index]==0 )
			index--;
		if(index<0)
			return "0";
		for(int i=0;i<=index;i++)
			sb.append(results[i]);
			

		return sb.reverse().toString();
    }
    public static void main(String args[])
    {
    	MultiplyStrings test = new MultiplyStrings();
    	String results = test.multiply("0","0" );
    	System.out.println(results);
    }

}
