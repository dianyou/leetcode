	/**
	 * https://leetcode.com/problems/integer-to-roman/
	 * Gavin
	 * 2016-6-2
	 */
public class IntegerToRoman {
	/**
	 * 罗马数的计数规则：   
	 * 	1.相同的数字连写、所表示的数等于这些数字相加得到的数、如：Ⅲ=3；
   	   	2.小的数字在大的数字的右边、所表示的数等于这些数字相加得到的数、 如：Ⅷ=8、Ⅻ=12；
    	3.小的数字、（限于 Ⅰ、X 和 C）在大的数字的左边、所表示的数等于大数减小数得到的数、如：Ⅳ=4、Ⅸ=9；
    	4.正常使用时、连写的数字重复不得超过三次；
    	5.在一个数的上面画一条横线、表示这个数扩大 1000 倍。
	 * @param num 只转换1-3999的数字
	 * @return
	 */
    public String intToRoman(int num) {
    	if(num>3999 || num <1)
    		return null;
    	/**
    	 * 先初始化一个二维数组，代码会简洁不少
    	 */
    	StringBuilder sb = new StringBuilder("");
        //千位数字
    	int k = num /1000;
    	if(k==3)
    	{
    		sb.append("MMM");
    	}else if(k==2)
    	{
    		sb.append("MM");
    	}
    	else if(k==1)
    	{
    		sb.append("M");
    	}
    	num = num % 1000;
    	//处理百位
    	k = num /100;
    	switch(k)
    	{
	    	case 9:
	    		sb.append("CM");
	    		break;
	    	case 8:
	    		sb.append("DCCC");
	    		break;
	    	case 7:
	    		sb.append("DCC");
	    		break;
	    	case 6:
	    		sb.append("DC");
	    		break;
	    	case 5:
	    		sb.append("D");
	    		break;
	    	case 4:
	    		sb.append("CD");
	    		break;
	    	case 3:
	    		sb.append("CCC");
	    		break;
	    	case 2:
	    		sb.append("CC");
	    		break;
	    	case 1:
	    		sb.append("C");
	    		break;
	    	default:
	    			break;
    	}
    	//处理十位
    	num = num % 100;
    	k = num/10;
    	switch(k)
    	{
	    	case 9:
	    		sb.append("XC");
	    		break;
	    	case 8:
	    		sb.append("LXXX");
	    		break;
	    	case 7:
	    		sb.append("LXX");
	    		break;
	    	case 6:
	    		sb.append("LX");
	    		break;
	    	case 5:
	    		sb.append("L");
	    		break;
	    	case 4:
	    		sb.append("XL");
	    		break;
	    	case 3:
	    		sb.append("XXX");
	    		break;
	    	case 2:
	    		sb.append("XX");
	    		break;
	    	case 1:
	    		sb.append("X");
	    		break;
	    	default:
	    			break;
    	}
    	//处理个位
    	num = num % 10;
    	k = num;
    	switch(k)
    	{
	    	case 9:
	    		sb.append("IX");
	    		break;
	    	case 8:
	    		sb.append("VIII");
	    		break;
	    	case 7:
	    		sb.append("VII");
	    		break;
	    	case 6:
	    		sb.append("VI");
	    		break;
	    	case 5:
	    		sb.append("V");
	    		break;
	    	case 4:
	    		sb.append("IV");
	    		break;
	    	case 3:
	    		sb.append("III");
	    		break;
	    	case 2:
	    		sb.append("II");
	    		break;
	    	case 1:
	    		sb.append("I");
	    		break;
	    	default:
	    			break;
    	}
    	return sb.toString();
    }
    public static void main(String args[])
    {
    	IntegerToRoman test = new IntegerToRoman();
    	String s = test.intToRoman(1);
    	System.out.println(s);
    }
	

}
