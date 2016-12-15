package leet;

/**
 * https://leetcode.com/problems/add-two-numbers/
 * @author I301431
 * 2016-12-08
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null)
        	return null;
        
        ListNode head = new ListNode(0);
        ListNode cursor = head;
        
        int carry = 0;
        while(l1 != null || l2 != null || carry !=0) 
        {
        	int val1 = 0;
        	if(l1 != null)
        	{
        		val1 = l1.val;
        		l1= l1.next;
        	}
        	int val2 = 0;
        	
        	if(l2 != null)
        	{
        		val2 = l2.val;
        		l2 = l2.next;
        	}
        	
        	int sum = val1 + val2 + carry;
        	carry = sum/10;
        	sum = sum %10;
        	
        	cursor = cursor.next = new ListNode(sum);
        	
        }
        
        return head.next;
        
    }
}
