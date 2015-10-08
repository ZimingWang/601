package LinkedList;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * Created by lipingxiong on 8/17/15.
 */
public class addTwoNumbers {
    public static class ListNode<E>{
        ListNode next;
        E data;
        ListNode(E e){
            this.data = e;
            this.next = null;
        }
    }
    /*
    2.5 You have two numbers represented by a linked list, where each node contains a single digit. Thedigits are stored in reverse order,
    such that the 1'sdigit isat the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.
     */
    public static ListNode<Integer> addTwoNumbers(ListNode<Integer> l1, ListNode<Integer> l2){
        int carry=0;
        int temp=0;
        ListNode<Integer> h1=l1;
        ListNode<Integer> h2=l2;
        ListNode<Integer> pre1=h1;
        while(h1!=null && h2!=null){
            temp =(h1.data+h2.data+carry);
            h1.data = temp % 10;
           carry = temp / 10;
            if(h1.next == null) pre1=h1;
            h1=h1.next;
            h2=h2.next;
        }
        if(h1==null) {
            pre1.next=h2;
            h1=h2;
        }
        while(h1 !=null){
            temp=h1.data+carry;
            carry=temp / 10;
            h1.data=temp%10;
            if(h1.next==null) pre1=h1;
            h1=h1.next;
        }
        if(carry!=0) {
            ListNode<Integer> extNode = new ListNode<>(carry);
            pre1.next = extNode;
        }
        return l1;
    }
    public static ListNode<Integer> createList(int[] nums){
        ListNode<Integer> res=new ListNode<>(0);
        ListNode<Integer> cur = res;
        for(int n:nums){
            cur.next=new ListNode<Integer>( n );
            cur=cur.next;
        }
        return res.next;
    }
    public static void ptrList(ListNode<Integer> head){
        ListNode<Integer> cur = head;
        while(cur!=null){
            System.out.print(cur.data);
            cur=cur.next;
        }
        System.out.println();
    }
    public static void main(String[] args){
        ListNode<Integer> l1= createList(new int[]{8,2,9});
        ptrList(l1);
        ListNode<Integer> l2= createList(new int[]{6,9});
        ptrList(l2);
        ListNode<Integer> res=addTwoNumbers(l1,l2);
        ptrList(res);
/*
        l1= createList(new int[]{8,2,9});
        l2= createList(new int[]{6,9});
        res=addTwoNumbers(l1,l2);
        ptrList(res);
        */

    }

}
