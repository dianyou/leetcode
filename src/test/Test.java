package test;


public class Test
{
   int Test(int[] A, int[] B,int M, int X ,int Y)
   {
	   int aLength =A.length;
	   int bLength = B.length;
	   int weightMaxium = 0;
	   
	   int aIndex = 0;	//aIndex指示遍历A数组的起始位置
	   int bIndex = 0;	//bIndex指示遍历B数组的起始位置
	   int result = 0;
	   int count = 0;
	   while(aIndex < aLength-1)
	   {
		   weightMaxium = 0;
		   int aSum = 0;
		   //一次不超过X个人
		   int tempCount = 0;
		   while(aIndex<aLength)
		   {
			   if(aSum+A[aIndex] <= Y && tempCount+1<=X)
			   {
				   aSum += A[aIndex];
				   tempCount++;
				   aIndex ++;
			   }
			   else
				   break;
		   }
		   //根据目标楼层数 计数
		   int oneStepResult = 0;
		   for(int j =1;j<=M;j++)
		   {
			   
			   for(int i=bIndex;i<aIndex;i++)
			   {
				   if(B[i] ==j)
				   {
					   oneStepResult++;
					   break;
				   }
			   }
		   }
		   
		   //一次电梯结束，再加上最后落地的一次
		   result = result + oneStepResult +1;
		   bIndex = aIndex;
	   }
	   return result;
   }
	  
   
   public static void main(String[] args)
   {
	//   int m =15;
	   int n=-1;
	   int nums[] = {1,2,3};
	   System.out.println(nums[n]);
   }
}