package others;

import java.util.LinkedList;

/**
 * Created by lipingxiong on 10/20/15.
 */
public class exam_601 {
    public static class LinkedListNode {
        int val;
        LinkedListNode next;
        LinkedListNode(int x){
            val = x;
        }
    };
    public static void main(String args){
//        LinkedListNode head = new LinkedListNode(1);
        createList(new int[]{1,2,3,4});
    }
    public static LinkedListNode createList(int[] nums){
        LinkedListNode head = new LinkedListNode(nums[0]);
        LinkedListNode cur = head;
        for(int i=0;i<nums.length;i++){
            LinkedListNode node = new LinkedListNode(nums[i]);
            cur.next = node;
            cur=node;
        }
        ptrList(head);
        return head;
    }
    public static void ptrList(LinkedListNode head){
        LinkedListNode cur = head;
        while(cur!=null){
            System.out.println(cur.val);
            cur=cur.next;
        }
    }
    static LinkedListNode reorderList(LinkedListNode head) {
        LinkedListNode walker = head;
        LinkedListNode runner = head;
        while(runner.next!=null){
            walker=walker.next;
            runner=runner.next.next;
        }
        LinkedListNode last=walker;
        //reverse
        LinkedListNode dummy = new LinkedListNode(0);
        dummy.next = last;
        LinkedListNode cur = last.next;
        while(cur!=null){
            last.next=cur.next;
            cur.next = last;
            dummy.next = cur;
            cur=last.next;
        }

        LinkedListNode p1=head;
        LinkedListNode p2=dummy.next;
        while(p1!=null&&p1.next!=dummy.next){
            LinkedListNode n1=p1.next;
            LinkedListNode n2=p2.next;
            p2.next=n1;
            p1.next=p2;
            p1=n1;
            p2=n2;
        }
        return head;
    }

}
