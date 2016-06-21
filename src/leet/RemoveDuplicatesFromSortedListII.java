package leet;
/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 * @author Gavin
 * 2016-06-05
 *
 */
public class RemoveDuplicatesFromSortedListII {
    static class ListNode{
      int val;
      ListNode next;
      ListNode(int x)
      {
        val = x;
      }
    }
    public ListNode deleteDuplicates(ListNode head) {
      if(head ==null||head.next == null)
        return head;
      while(head.val == head.next.val) //剔除1-1-2-2类似情况
      {
        int value = head.val;
        while(head.val == value)
        {
          if(head.next == null)
            return null;
          head = head.next;
        }
        if(head.next ==null)
          return head;
      }
      if(head.next.next ==null)
        return head;
      ListNode cur=head; //�?�个指针，需�?判断head处的数字是�?��?�?节点
   //   System.out.println("Head::"+head.val);
      while(cur !=null && cur.next !=null && cur.next.next !=null)
      {
        if(cur.next.next.val ==cur.next.val)
        {
          ListNode node = cur.next;
          int value = node.val;
          while(node.val == value)
          {
            node = node.next;
            if(node ==null)
            {
              cur.next = null;
              return head;
            }
          }
          cur.next = node;
          continue;
        }
        cur = cur.next;
      }
      return head;
    }
    public static void main(String args[])
    {
    	ListNode head = new ListNode(1);
    	ListNode next = new ListNode(2);
    	next.next = new ListNode(3);
    	head.next = next;
    	ListNode cur = head;
    	while(cur!=null)
    	{
    		System.out.println(cur.val);
    		cur = cur.next;
    	}
    	RemoveDuplicatesFromSortedListII test = new RemoveDuplicatesFromSortedListII();
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
