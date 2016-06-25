package leet;

import leet.SwapNodesInPairs.ListNode;
/**
 * https://leetcode.com/problems/palindrome-linked-list/
 * @author Gavin
 *	2016-06-22
 */
public class PalindromeLinkedList
{
	/**
	 *先遍历找到中间节点，然后将后半段反转
	 * @param head
	 * @return
	 */
  public boolean isPalindrome(ListNode head) {
    if(head ==null )
      return true;
    ListNode half = head;
    ListNode cur = head;
    int len=1;
    while(cur.next !=null)
    {
      cur = cur.next;
      len++;
      if(cur.next !=null)
      {
    	  cur = cur.next;
    	  len++;
      }
        
      half = half.next;
    }
//    System.out.println("half::"+half.val);
//    System.out.println("len::"+len);
    ListNode helper = new ListNode(0);
    if(len%2 ==1)
    {
        helper.next = half.next;
    }
    else
    {
        helper.next = half;
    }
    cur = helper.next;
//    System.out.println("new cur::"+cur.val);
    
    while(cur !=null)
    {
      ListNode temp = cur.next;
      cur.next = helper.next;
      helper.next = cur;
      cur = temp;
    }
    cur = helper.next;
    int counter = len/2;
    while(counter>0)
    {
    	counter--;
//      System.out.println("cur::"+cur.val);
//      System.out.println("head::"+head.val);
      if(head.val != cur.val)
        return false;
      cur = cur.next;
      head = head.next;
    }
    return true;

}
  public static void main(String args[])
  {
	  ListNode head = new ListNode(2);
//	  head.next = new ListNode(3);
//	  head.next.next = new ListNode(3);
//	  head.next.next.next = new ListNode(3);
//	  head.next.next.next.next = new ListNode(1);
	  PalindromeLinkedList test = new PalindromeLinkedList();
	  boolean res = test.isPalindrome(head);
	  System.out.println(res);
  }
}
