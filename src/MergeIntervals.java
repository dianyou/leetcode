import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
/**
 * https://leetcode.com/problems/merge-intervals/
 * @author Gavin
 * 2016-5-30
 * 先把所有区间按照起始位置排序，然后再依次合并区间
 */
public class MergeIntervals {

	 public static class Interval {
	      int start;
	      int end;
	      Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
	 }
	 
	 public List<Interval> merge(List<Interval> intervals) {
		 Collections.sort(intervals,new Comparator<Interval>()
		 {
		 		public int compare(Interval in1,Interval in2)
		 		{
		 			return in1.start - in2.start;
		 		}
			 }); ////根据各区间的起始点排序
//		 Queue<Interval> queue = new PriorityQueue<Interval>(new Comparator<Interval>()
//				 {
//			 		public int compare(Interval in1,Interval in2)
//			 		{
//			 			return in1.start - in2.start;
//			 		}
//				 } );
//		 queue.addAll(intervals);//根据各区间的起始点排序
		 LinkedList<Interval> mergeList = new LinkedList<Interval>();//用于合并的队列
		 for(Interval in:intervals)
		 {
			 //merge
			 if(mergeList.size()>0){
					Interval merged =  mergeList.getFirst();
					if(merged.end < in.start)
					{
						mergeList.addFirst(in);
					}
					else
					{
						if(merged.end > in.end)//新来的区间包在已存在的区间的内部
							continue;
						merged = new Interval(merged.start,in.end);
						mergeList.removeFirst();
						mergeList.addFirst(merged);
					}
			 }
			 else
				 mergeList.add(in);
		 }
		 return mergeList;
	        
	 }
	 public static void main(String args[])
	 {
		 
		 MergeIntervals test = new MergeIntervals();
		 Interval in4 = new Interval(0,4);
		 Interval in1 = new Interval(1,3);
		 Interval in3 = new Interval(8,10);
		 Interval in2 = new Interval(2,6);
		 List<Interval> list = new LinkedList<Interval>();
		 list.add(in1);
		 list.add(in2);
		 list.add(in3);
		 list.add(in4);
		 List<Interval> results = test.merge(list);
		 for(Interval in:results)
			 System.out.println("["+in.start+","+in.end+"]");
		 
//		 Queue<Interval> queue = new PriorityQueue<Interval>(new Comparator<Interval>()
//		 {
//	 		public int compare(Interval in1,Interval in2)
//	 		{
//	 			return in1.start - in2.start;
//	 		}
//		 } );
//			

//

//		 while(!queue.isEmpty())
//		 {
//			 System.out.println(queue.poll().start);
//		 }
		 
	 }
}
