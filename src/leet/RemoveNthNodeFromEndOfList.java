package leet;

/**
 * 2016-07-19
 * @author I301431
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head ==null)
        	return null;
        if(n<=0)
        	return null;
        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode preRemovedNode = helper;
        int i=1;
        
        while(head !=null)
        {
        	if(i>n)
        		preRemovedNode = preRemovedNode.next;
        	i++;
        	head = head.next;

        	
        }
        preRemovedNode.next = preRemovedNode.next.next;
        return helper.next;
        
    }
    
    public static void main(String args[])
    {
    	RemoveNthNodeFromEndOfList test = new RemoveNthNodeFromEndOfList();
    	ListNode head = new ListNode(1);
    //	head.next = new ListNode(2);
    	ListNode res = test.removeNthFromEnd(head, 1);
    	while(res !=null)
    	{
    		System.out.println(res.val);
    		res = res.next;
    	}
    }

}
