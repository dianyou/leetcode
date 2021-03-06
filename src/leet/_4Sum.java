package leet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/**
 * https://leetcode.com/problems/4sum/
 * @author I301431
 *	2016-06-15
 */
public class _4Sum
{
	/**
	 * 注释中代码超时，改动之处在于前者初始化一个记录的List，这个版本是在将索引传进去，再初始化List
	 * @param nums
	 * @param target
	 * @return
	 */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if(nums ==null || nums.length <4)
          return res;
        Arrays.sort(nums);
        int i=0;
        while(i<nums.length-3)
        {
          int j=i+1;
          while(j<nums.length-2)
          {
//              List<Integer> list = new LinkedList<Integer>();
//              list.add(nums[i]);
//              list.add(nums[j]);
              find2Sum(i,j,nums,target-nums[j]-nums[i],j+1,res);
              while(j<nums.length-2 &&nums[j+1] == nums[j])
                j++;
              j++;
          }
          while(i<nums.length-3 && nums[i+1] == nums[i])
            i++;
          i++;
        }
        return res;
    }
      private void find2Sum(int first,int second,int nums[],int target,int start,List<List<Integer>> res)
      {
        int left=start;
        int right = nums.length-1;
        while(left<right)
        {
     //     System.out.println("3::"+nums[left]);
     //     System.out.println("4::"+nums[right]);
          
          
          int sum = nums[left]+nums[right];
        //  List<Integer> temp = new LinkedList<Integer>();
          List<Integer> temp = new ArrayList<Integer>();
          if(sum == target)
          {
        	   
          	temp.add(nums[first]);
          	temp.add(nums[second]);
             temp.add(nums[left]);
             temp.add(nums[right]);
             res.add(temp);
             while(left<nums.length-1 &&nums[left+1] == nums[left])
            	 left++;
             while(right>0 && nums[right-1] == nums[right])
            	 right--;
             left++;
             right--;
             continue;
          }
          if(sum<target)
            left++;
          else
            right--;
        }
      }

	/**
    public List<List<Integer>> fourSum(int[] nums, int target) {
      List<List<Integer>> res = new LinkedList<List<Integer>>();
      if(nums ==null || nums.length <4)
        return res;
      Arrays.sort(nums);
      int i=0;
      while(i<nums.length-3)
      {
        if(nums[i]>target && nums[i]>=0)
          break;
        find3Sum(nums,target-nums[i],i+1,res);
        while(i<nums.length-3 && nums[i+1] == nums[i])
          i++;
        i++;
      }
      return res;
  }

  private void find3Sum(int nums[],int target,int start,List<List<Integer>> res)
  {

    int i=start;
 //   System.out.println("1::"+nums[i-1]);
    while(i<nums.length-2)
    {
        List<Integer> list = new LinkedList<Integer>();
        list.add(nums[start-1]);
        if(nums[i]>target && nums[i]>=0)
          return;
//        System.out.println("2::"+nums[i]);

        list.add(nums[i]);
        find2Sum(nums,target-nums[i],i+1,res,list);
        while(i<nums.length-2 &&nums[i+1] == nums[i])
          i++;
        i++;
    }
  }
  private void find2Sum(int nums[],int target,int start,List<List<Integer>> res,List<Integer> list)
  {
    int left=start;
    int right = nums.length-1;
    while(left<right)
    {
 //     System.out.println("3::"+nums[left]);
 //     System.out.println("4::"+nums[right]);
      
      List<Integer> temp = new LinkedList<Integer>(list);
      if((nums[left]+nums[right]) == target)
      {
    	  
         temp.add(nums[left]);
         temp.add(nums[right]);
         res.add(temp);
         while(left<nums.length-1 &&nums[left+1] == nums[left])
        	 left++;
         while(right>0 && nums[right-1] == nums[right])
        	 right--;
         left++;
         right--;
         continue;
      }
      if((nums[left]+nums[right])<target)
        left++;
      else
        right--;
    }
  }
  */
  public static void main(String args[])
  {
	  long start = System.currentTimeMillis();
	  _4Sum test = new _4Sum();
	  int[] nums = {91277418,66271374,38763793,4092006,11415077,60468277,1122637,72398035,-62267800,22082642,60359529,-16540633,92671879,-64462734,-55855043,-40899846,88007957,-57387813,-49552230,-96789394,18318594,-3246760,-44346548,-21370279,42493875,25185969,83216261,-70078020,-53687927,-76072023,-65863359,-61708176,-29175835,85675811,-80575807,-92211746,44755622,-23368379,23619674,-749263,-40707953,-68966953,72694581,-52328726,-78618474,40958224,-2921736,-55902268,-74278762,63342010,29076029,58781716,56045007,-67966567,-79405127,-45778231,-47167435,1586413,-58822903,-51277270,87348634,-86955956,-47418266,74884315,-36952674,-29067969,-98812826,-44893101,-22516153,-34522513,34091871,-79583480,47562301,6154068,87601405,-48859327,-2183204,17736781,31189878,-23814871,-35880166,39204002,93248899,-42067196,-49473145,-75235452,-61923200,64824322,-88505198,20903451,-80926102,56089387,-58094433,37743524,-71480010,-14975982,19473982,47085913,-90793462,-33520678,70775566,-76347995,-16091435,94700640,17183454,85735982,90399615,-86251609,-68167910,-95327478,90586275,-99524469,16999817,27815883,-88279865,53092631,75125438,44270568,-23129316,-846252,-59608044,90938699,80923976,3534451,6218186,41256179,-9165388,-11897463,92423776,-38991231,-6082654,92275443,74040861,77457712,-80549965,-42515693,69918944,-95198414,15677446,-52451179,-50111167,-23732840,39520751,-90474508,-27860023,65164540,26582346,-20183515,99018741,-2826130,-28461563,-24759460,-83828963,-1739800,71207113,26434787,52931083,-33111208,38314304,-29429107,-5567826,-5149750,9582750,85289753,75490866,-93202942,-85974081,7365682,-42953023,21825824,68329208,-87994788,3460985,18744871,-49724457,-12982362,-47800372,39958829,-95981751,-71017359,-18397211,27941418,-34699076,74174334,96928957,44328607,49293516,-39034828,5945763,-47046163,10986423,63478877,30677010,-21202664,-86235407,3164123,8956697,-9003909,-18929014,-73824245};
	  List<List<Integer>> res = test.fourSum(nums, -236727523);
	  System.out.println(res.toString());
	  long end = System.currentTimeMillis();
	  System.out.println(end - start);
  }
}
