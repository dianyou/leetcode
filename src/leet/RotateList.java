package leet;

/**
 * https://leetcode.com/problems/rotate-list/
 * @author I301431
 * 2016-12-22
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
    	if(head == null || k<0)
    		return null;
    	if(k==0)
    		return head;
    	ListNode slow = head,fast = head;
    	
    	for(int i=0;i<k;i++)
    	{
    		if(fast == null)
    		{
    			//size = i;
    			k = k % i;
    			i = -1;
    			fast = head;
    			continue;
    		}
    		fast = fast.next;
    	}
    	if(fast == null) //k is the length of list
    		return head;
    		
    	while(fast.next != null)
    	{
    		slow = slow.next;
    		fast = fast.next;
    	}
    	
    	//rotate
    	fast.next = head;
    	head = slow.next;
    	slow.next = null;
    	return head;
    }
    
    public static void main(String args[])
    {
    	ListNode head = new ListNode(1);
    	head.next = new ListNode(2);
//    	head.next.next = new ListNode(3);
//    	head.next.next.next = new ListNode(4);
//    	head.next.next.next.next = new ListNode(5);
    	
    	
    	RotateList rl = new RotateList();
    	
    	ListNode result = rl.rotateRight(head, 3);
    	System.out.println(result.val);
    	
    }
    
}
