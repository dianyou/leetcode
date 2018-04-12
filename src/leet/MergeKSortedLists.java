package leet;

public class MergeKSortedLists {
	
	//divide & merge
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length ==0)
        	return null;
        int len = lists.length;
        if(len == 1)
        	return lists[0];
        int m = (len-1)/2;
        ListNode left = mergeLists(lists,0, m);
        ListNode right = mergeLists(lists, m+1, len-1);
    }
    
    private ListNode mergeLists(ListNode[] lists,int l,int r)
    {
    	if(l==r)
    		return lists[l];
    }

}
