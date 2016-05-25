
public class MergeTwoSortedLists21 {
	  public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
       
        ListNode head = new ListNode(0);
        ListNode results = head;
        if(l1==null)
        	return l2;
        if(l2 == null)
        	return l1;
        
        while(l1!=null && l2 != null){ 
            if(l1.val<=l2.val)
            {
            	results.next=new ListNode(l1.val);
            	l1 = l1.next;
            }
            else
            {
            	results.next = new ListNode(l2.val);
            	l2 = l2.next;
            }
            results = results.next;
        }
        if(l2 !=null)
        {
        	results.next = l2;
        }
        if(l1 !=null)
        {
        	results.next = l1;
        }
        return head.next;
        
    }
}
