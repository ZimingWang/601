package LinkedList;

import java.util.HashMap;

/**
 * Created by lipingxiong on 8/16/15.
 */
public class removeDuplicates {
    //2->3->2->4
    //2- 3-4
    public static class ListNode<E>{
        ListNode next;
        E data;
        ListNode(E e){
            this.data = e;
            this.next = null;
        }
    }
    public static void main(String[] args){
        ListNode head = new ListNode<Integer>(2);
        head.next = new ListNode<Integer>(7);
        head.next.next = new ListNode<Integer>(2);
        head.next.next.next = new ListNode<Integer>(4);
        head.next.next.next.next= new ListNode<Integer>(5);
        head.next.next.next.next.next = null;

        ListNode cur = head;
        while(cur!=null){
            System.out.print(cur.data);
            cur= cur.next;
        }
        System.out.println();
        /*2.1 test
//        removeDuplicates(head);
        delDuplicates(head);
        cur = head;
        while(cur!=null){
            System.out.print(cur.data);
            cur= cur.next;
        }
        */
        /*2.2 kthLast
        int[] counter= new int[1];
        counter[0]=0;
        ListNode res = kthLast(head,5,counter);
        System.out.println(res.data);
        */
//        2.4
        //ListNode<Integer>
        cur=split(head,5);
        while(cur!=null) {
            System.out.print(cur.data);
            cur = cur.next;
        }

    }
    //2.4 Write code to partition a linked list around a value x, such that all nodes less than x come before
    // alt nodes greater than or equal to x.
    public static ListNode split(ListNode<Integer> head, int x){
        ListNode<Integer> h1= new ListNode(0);
        ListNode<Integer> h2= new ListNode(0);
        ListNode<Integer> cur=head;
        ListNode<Integer> p1=h1;
        ListNode<Integer> p2=h2;

        while(cur!=null){
            if(cur.data < x){
                p1.next = cur;
                p1=p1.next;
            }
            else{
                p2.next = cur;
                p2=p2.next;

            }
            cur=cur.next;
        }
        //merge
        /*
        h1->..->p1->null;
            \
        h2->..->p2->null;
        */
        p1.next=h2.next;
        return h1.next;
    }

    //2.3Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node.
    public static void delMidNode(ListNode mid){
        mid.data = mid.next.data;
        mid.next=mid.next.next;
    }

    //2.2Implement an algorithm to find the kth to last element of a singly linked list.
    /*
    1...n-k...n
    ...->n-1->n ->null
    1->2->null
    2->null
    */

    public static ListNode kthLast(ListNode head,int k,int[] counter){
        if(head==null) return null;
        ListNode res = kthLast(head.next,k,counter);
        if(res!=null) return res;
        counter[0]+=1;
        if(counter[0]==k) return head;
        return null;
    }

    /*
    cur: 2,pre: 2, hmap={2:},
    cur:3,pre:3,hmap={2: true,3: true}
    cur:2,pre:3, remove 2nd 2
    cur:3, pre:3,remove 2nd 3
    cur 3,pre:3,
    pre points to the last unique digit, when encounter digit that's in hmap,use pre.next=cur.next
     to del this digit. In this way, all duplicates will be del.
     */
    public static void removeDuplicates(ListNode head){
        HashMap hmap = new HashMap();
        ListNode pre = null;
        ListNode cur = head;
        while(cur!=null){
            if(hmap.containsKey(cur.data)){
                //remove cur
                pre.next = cur.next;
            }
            else{
                hmap.put(cur.data,true);
                pre = cur;
            }
            cur= cur.next;
        }
    }
    /*2-3-2-3-3
    cur:2,
    r:2, r.next != ;
    r:3, r.next ==; r.next =r.next.next; remove 2nd 2.
    cur:3
    r:3

    cur:,r:3,r.next == ,  23-33
    cur:3,r:3, r.next==, 23- -3
    233
    cur:3,r:3, r.next==null
    */
    public static void delDuplicates(ListNode head){
        ListNode cur=head;

        while(cur!=null){
            ListNode runner=cur;
            while(runner!=null){
                if(runner.next != null && runner.next.data == cur.data){
                    //2-3-2-4
                    runner.next = runner.next.next;
                    // 2-3-4
                }
                else {
                    runner = runner.next;
                }
            }
            cur = cur.next;
        }
    }


}
