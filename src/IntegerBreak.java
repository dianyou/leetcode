
public class IntegerBreak {
	/**
	 * 数学规律：当差分成多个3时，乘积最大
	 * @param n
	 * @return
	 */
	public int integerBreak(int n)
	{
		if(n<2)
			return 0;
		if(n == 2)
			return 1;
		if(n==3)
			return 2;
		if(n==4)
			return 4;
		
		int splitdata = n;
		int product = 1;;
		while(splitdata > 3)
		{	
			splitdata = splitdata-3;
			product = product *3;
			if(splitdata ==4)
			{
				product *= splitdata;
				return product;
			}
			
			if(splitdata <=3 && splitdata !=0)
			{
				product = product*splitdata;
				break;
			}
		}
		return product;
	}
	
	public static void main(String args[])
	{
		IntegerBreak test = new IntegerBreak();
		System.out.println(test.integerBreak(5));
	}

}
