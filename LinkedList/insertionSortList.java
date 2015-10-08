package LinkedList;

/**
 * Created by lipingxiong on 8/24/15.
 */
public class insertionSortList {
    public static class ListNode{
        ListNode next;
        int val;
        ListNode(int e){
            this.val = e;
            this.next = null;
        }
    }
    // pre, pre.next
    // 0-> 1 ->10->2
    public ListNode insertionSortList(ListNode head) {

        ListNode helper = new ListNode(0);
        ListNode pre = helper;
        ListNode cur = head;
        while(cur!=null) {

            while(pre.next.val < cur.val){ //keep looking until find right place
                ;
            }
        }
        return null;
    }

}
