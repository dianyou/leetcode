
public class CountingBits338 {
	
//	public int[] countBits(int num){
//		int[] a = {0,1,1,2};
//		int[] result = new int[num+1];
//		int rest = num/4;
//		int remainder = num%4;
//		
//		for(int i=0;i<=num;i++)
//		{
//			rest = i/4;
//			remainder = i%4;
//			result[i] = a[remainder];
//			while(rest>0)
//			{
//				remainder = rest %4;
//				result[i] += a[remainder];
//				rest = rest/4;
//			}
//			
//			
//		}
//		return result;
//	}
	
	public int[] countBits(int num)
	{
		int[] result = new int[num+1];
		for(int i=0;i<=num;i++)
		{
			if(i%2 == 0)
				result[i] = result[i/2];
			else
				result[i] = result[i/2]+1;
		}
		
		return result;
	}
	
	public static void main(String args[])
	{
		CountingBits338 test = new CountingBits338();
		int[] result = test.countBits(5);
		for(int i=0;i<result.length;i++)
			System.out.print(result[i]+",");
	}

}
