/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 * @author Gavin
 * 2016-06-10
 */
public class ReverseNodeInKGroup {

  public ListNode reverseKGroup(ListNode head, int k) {
    if(head ==null || head.next == null)
      return head;
    if(k<=1)
      return head;
    ListNode ln = head;
    int len = 0;
    while(ln !=null)
    {
      len++;
      ln = ln.next;
    }
    if(len <k)
      return head;
    ListNode root = new ListNode(0);
    root.next = head;
    ListNode reverseStart = head,cur = head,reverseEnd = head;
    ListNode pre = new ListNode(0); //记录翻转后的最后一个元素
    for(int j=0;j<len/k;j++)
    {	
    //	System.out.println("cur::"+cur.val);
    	pre = reverseEnd;
    	reverseStart = cur;
    	reverseEnd = cur;
        for(int i=0;i<k;i++)
        { //swap
          ListNode temp = cur.next;
          cur.next = reverseStart;
          reverseEnd.next = temp;
          reverseStart = cur;
          if(j ==0 && i==k-1)//记录头指针
              root.next = cur;
          cur = temp;
 
        }
        if(len/k==1) //在只翻转一次时，会形成循环链表
        	break;
        pre.next = reverseStart; //连接两端翻转链表
       
    }
    return root.next;
}
	public static void main(String args[])
	{
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
//		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(4);
//		head.next.next.next.next = new ListNode(5);
		ReverseNodeInKGroup test = new ReverseNodeInKGroup();
		ListNode r = test.reverseKGroup(head, 2);
		while(r !=null)
		{
			System.out.println(r.val);
			r = r.next;
		}
		
	}

}
