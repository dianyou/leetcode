package leet;
/**
 *
 * @author Gavin
 * 2016-06-10
 *
 */
public class SwapNodesInPairs{
	 static class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	 }
	/*
	 * 直接交�?�值就�?�以了，如果采�?�交�?�节点的方法，需�?是三个指针，分别指�?�第一个节点，第二个节点以�?�第一个节点的�?驱节点
	 */
  public ListNode swapPairs(ListNode head)
  {
    if(head ==null ||head.next==null)
      return head;
    ListNode pre = new ListNode(0);
    pre.next = head;
    ListNode first = head,second = head.next;
    head = second;
    while(second!=null)
    {
    	first.next = second.next;
    	second.next = first;
    	pre.next = second;

    	if(first.next == null)
    		break;
    	pre = first;
    	first = first.next;
    	second = first.next;
    }
    return head;
  }


  public static void main(String args[])
  {
	  ListNode head = new ListNode(1);
//	  head.next = new ListNode(2);
//	  head.next.next = new ListNode(3);
//	  SwapNodesInPairs test = new SwapNodesInPairs();
//	  ListNode results = test.swapPairs(head);
//	  while(results !=null)
//	  {
//		  System.out.println(results.val);
//		  results = results.next;
//	  }
  }


}
