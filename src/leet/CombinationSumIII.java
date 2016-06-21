package leet;
import java.util.LinkedList;
import java.util.List;
/**
 * 
 * @author Gavin
 * 2016-06-14
 *
 */
public class CombinationSumIII
{
	/**
	 * è‹¥æžœæŒ‰ç…§kæ˜¯å?¦å‡?åˆ°0ï¼Œä»£ç ?ä¼šç®€æ´?
	 * @param k
	 * @param n
	 * @return
	 */
  public List<List<Integer>> combinationSum3(int k, int n)
  {
	List<List<Integer>> res = new LinkedList<List<Integer>>();
    if(k<=0 || k>9 || n<=0 || n>45)
      return res;
    int max = (19-k)*k/2;
    if(n >max)
      return res;
    if( k==1)
    {
    	 List<Integer> list = new LinkedList<Integer>();
         list.add(n);
         res.add(list);
         return res;
    }
    int up = n<9? n:9;
    for(int i = up;i>0;i--)
    {
        if(n == i)
          continue;
        if(i<k)
        	break;
        List<Integer> list = new LinkedList<Integer>();
        list.add(i);
        max = (k-1)*i-(k-1)*k/2;
        if(max >= n-i)//å‰ªæž?
        	combination(k-1,i-1,n-i,list,res);
    }
    return res;
  }

  private void combination(int k,int up,int target,List<Integer> list,List<List<Integer>> res)
  {
	  if(k ==1)
      {
        if(target<=up)
        {
          List<Integer> temp = new LinkedList<Integer>(list);
          temp.add(target);
          res.add(temp);
        }
          return;
      }
    up = target<up? target:up; //å‰ªæž?
    
    for(int i = up;i>0;i--)
    {
    	if(target == i)
    		continue;
    	List<Integer> temp = new LinkedList<Integer>(list);
       if(i<k)
        	return;
        temp.add(i);
        
        int max = (k-1)*i-(k-1)*k/2;
        if(max >= target-i)//å‰ªæž?
        	combination(k-1,i-1,target-i,temp,res);
    }
  }
  public static void main(String args[])
  {
	  CombinationSumIII test = new CombinationSumIII();
	  List<List<Integer>> res = test.combinationSum3(3, 7);
	  System.out.println(res.toString());
  }
}
