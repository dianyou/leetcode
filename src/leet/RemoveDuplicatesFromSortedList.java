package leet;

/**
	https://leetcode.com/problems/remove-duplicates-from-sorted-list/
	Gavin
	2016-06-05
*/
public class RemoveDuplicatesFromSortedList {
    static class ListNode{
      int val;
      ListNode next;
      ListNode(int x)
      {
        val = x;
      }
    }
    public ListNode deleteDuplicates(ListNode head) {
      ListNode pre=null,cur=head; //å?ŒæŒ‡é’ˆ
      if(head ==null||head.next == null)
        return head;
      while(cur !=null)
      {
        if(pre ==null)
        {
          pre = cur;
          cur = cur.next;
          continue;
        }
        if(cur.val == pre.val)
        {
          pre.next = cur.next;
          cur = cur.next;
        }
        else
        {
        	pre = cur;
        	cur = cur.next;
        }

      }
      return head;
    }
    public static void main(String args[])
    {
    	ListNode head = new ListNode(1);
    	ListNode next = new ListNode(2);
    	next.next = new ListNode(2);
    	head.next = next;
    	ListNode cur = head;
    	while(cur!=null)
    	{
    		System.out.println(cur.val);
    		cur = cur.next;
    	}
    	RemoveDuplicatesFromSortedList test = new RemoveDuplicatesFromSortedList();
    	test.deleteDuplicates(head);
    	System.out.println("-----------------------");
    	cur = head;
    	while(cur!=null)
    	{
    		System.out.println(cur.val);
    		cur = cur.next;
    	}


    }
}
