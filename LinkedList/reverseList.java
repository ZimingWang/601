package LinkedList;

import java.util.HashSet;

/**
 * Created by lipingxiong on 8/24/15.
 */
public class reverseList {
    public static class ListNode {
        ListNode next;
        int data;

        ListNode(int e) {
            this.data = e;
            this.next = null;
        }
    }

    public ListNode Reverse(ListNode head){
        if(head==null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head.next;
        ListNode last = head;
        while(cur!=null){
            last.next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = last.next;
        }
        return dummy.next;
    }


    //  ... -> n-2 -> n-1 -> n -> null
    private ListNode head = new ListNode(0);
    public void recursiveReverse(ListNode currentNode )
    {
        //check for empty list
        if(currentNode == null)
            return;
// if we are at the TAIL node:
//    recursive base case:

        if(currentNode.next == null)
        {
//set HEAD to current TAIL since we are reversing list
            head = currentNode;
            return; //since this is the base case
        }

        recursiveReverse(currentNode.next);
        currentNode.next.next = currentNode;
        currentNode.next = null; //set "old" next pointer to NULL
    }

}
