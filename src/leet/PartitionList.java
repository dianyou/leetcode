package leet;

/**
 * https://leetcode.com/problems/partition-list/
 * @author I301431
 * 2017-01-03
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if(head==null)
        	return null;
        ListNode smaller = new ListNode(-1);
        ListNode smallerCur = new ListNode(0);
        smaller.next = smallerCur;
        ListNode greater = new ListNode(-1);
        ListNode greaterCur = new ListNode(0);
        greater.next = greaterCur;
        while(head != null)
        {
        	int val = head.val;
        	if(val >= x)
        	{
        		greaterCur.next = new ListNode(val);
        		greaterCur = greaterCur.next;
        	}
        	else
        	{
        		smallerCur.next = new ListNode(val);
        		smallerCur = smallerCur.next;
        	}
        	head = head.next;
        }
        smallerCur.next = greater.next.next;
        return smaller.next.next;
        	
    }
}
