package leet;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 * @author I301431
 *	2016-12-05
 */
public class LongestCommonPrefix {
	
	public String longestCommonPrefix(String[] strs) {
		if(strs == null || strs.length == 0)
			return "";
		
		StringBuilder result = new StringBuilder();
		//the shortest length is no longer than strs[0]
		int n = strs[0].length();
		for(int i=0;i<n;i++)
		{
			char c= strs[0].charAt(i);
			boolean flag = false;
			for(int j=1;j<strs.length;j++)
			{
				if(strs[j].length()<(i+1) || strs[j].charAt(i) != c)
				{
					flag = true;
					break;
				}
					
				
			}
			if(flag)
				break;
			result.append(c);
		}
		
		return result.toString();
	}

	public static void main(String args[])
	{
		StringBuilder result = new StringBuilder("");
		System.out.println(result.toString());
	}
}
