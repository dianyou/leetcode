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
	 * 若果按照k是否减到0，代码会简洁
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
        if(max >= n-i)//剪枝
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
    up = target<up? target:up; //剪枝
    
    for(int i = up;i>0;i--)
    {
    	if(target == i)
    		continue;
    	List<Integer> temp = new LinkedList<Integer>(list);
       if(i<k)
        	return;
        temp.add(i);
        
        int max = (k-1)*i-(k-1)*k/2;
        if(max >= target-i)//剪枝
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
