package leet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
/**
 * 八皇后问题
 * @author Gavin
 *	2016-06-20
 */
public class NQueens
{
	/**
	 * 方法是，从第一行开始，逐层遍历，判断
	 * 判断方法有banlist
	 * @param n
	 * @return
	 */
  public List<List<String>> solveNQueens(int n)
  {
    List<List<String>> res = new LinkedList<List<String>>();
    if(n==1)
    {
      List<String> list = new LinkedList<String>();
      list.add("Q");
      res.add(list);
      return res;
    }
    if(n<4)
      return res;

    //根据第一行迭代
    for(int i=0;i<n;i++)
    {
      StringBuilder sb = new StringBuilder("");
      for(int j=0;j<n;j++)
      {
        if(j==i)
          sb.append("Q");
        else
          sb.append(".");
      }
      ArrayList<String> list = new ArrayList<String>();
      // System.out.println("row::"+0);
      // System.out.println(sb.toString());
      list.add(sb.toString());
      Set<Integer> banSetCol = new HashSet<Integer>();//for column
      Set<Integer> banSetK1 = new HashSet<Integer>();//row = col + k1
      Set<Integer> banSetK2 = new HashSet<Integer>();//row = -col + k2
      banSetCol.add(i);
      banSetK1.add(-i);
      banSetK2.add(i);
      helpSolver(1,i,list,banSetCol,banSetK1,banSetK2,res);
    }
    return res;
  }


  private void helpSolver(int row,int col,ArrayList<String> list,
	  Set<Integer> banSetCol,Set<Integer> banSetK1,
	  Set<Integer> banSetK2,List<List<String>> res)
  {
    int n=list.get(0).length();
    if(row == n)
    {
    	/**
    	 * 此处有个奇怪的地方，一开始使用res.add(list)，然而结果只返回了第一行的值
    	 * 说明在添加时只是添加了list的地址，后续对list一系列remove操作也会影响list的值！！！
    	 * list是指针地址......
    	 */
         System.out.println("n::"+n);
         System.out.println(list.toString());
        ArrayList<String> temp = new ArrayList<String>(list);
        //res.add(list);
        res.add(temp);
        return;
    }

  //  System.out.println("row::"+row);
    for(int i=0;i<n;i++)
    {
        //isvalid?
        if(banSetCol.contains(i) ||banSetK1.contains(row-i)||banSetK2.contains(row+i))
          continue;
        StringBuilder sb = new StringBuilder("");
        for(int j=0;j<n;j++)
        {
          if(j==i)
            sb.append("Q");
          else
            sb.append(".");
        }
        list.add(sb.toString());
    //    System.out.println(list.toString());
        banSetCol.add(i);
        banSetK1.add(row-i);
        banSetK2.add(row+i);
        helpSolver(row+1,i,list,banSetCol,banSetK1,banSetK2,res);
        banSetCol.remove(i);
        banSetK1.remove(row-i);
        banSetK2.remove(row+i);
        list.remove(row);
    }
  }
  public static void main(String args[])
  {
	  NQueens test = new NQueens();
	  List<List<String>> res = test.solveNQueens(4);
	  System.out.println(res.size());
	  System.out.println(res.toString());

  }
}
