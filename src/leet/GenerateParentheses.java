package leet;
import java.util.ArrayList;
import java.util.List;
/**
 * https://leetcode.com/problems/generate-parentheses/
 * @author Gavin
 *	2016-06-03
 */
public class GenerateParentheses {
	/**
	 * 采用两个指针计数，left：左括�?�的个数；right：�?�括�?�的个数，�?�?left>=right
	 * @param n
	 * @return
	 */
    public List<String> generateParenthesis(int n) {
    	if(n==0)
    		return null;
    	String s = "";//记录字符串
    	int left =0,right=0;
    	List<String> results = new ArrayList<String>();
    	generate(n,left,right,s,results);
    	return results;
    }
    private void generate(int n,int left,int right,String s,List<String> list)
    {
    	if(left==n && right==n)
    	{
    		list.add(s);
    		return;
    	}
        if(left>right)//add ")"
        {
        	generate(n,left,right+1,s +")",list);//�?�?�?�更right的值（right++），会影�?下一个if中的值
        }
        if(left<n)//添加左括�?�"("
        {
        	generate(n,left+1,right, s+"(",list);
        }


    }
    public static void main(String args[])
    {
    	GenerateParentheses test = new GenerateParentheses();
    	List<String> list = test.generateParenthesis(2);
    	System.out.println(list.toString());
    }

}
