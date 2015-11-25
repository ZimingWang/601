package ArraysStrings;

/**
 * Created by lipingxiong on 11/18/15.
 */
public class mergeRemoveDuplicate {

    public static void main(String[] args) {
        mergeRemoveDuplicate s = new mergeRemoveDuplicate();
        ListNode l1 = s.createList(new int[]{0,0,1,1,1, 2, 4, 4, 5});
        ListNode l2 = s.createList(new int[]{1,1,2, 3, 4, 6, 6});
        ListNode l3 = s.merge(l1, l2);
        s.ptrList(l3);
    }

    private ListNode createList(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode pre = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode nnode = new ListNode(arr[i]);
            pre.next = nnode;
            pre = nnode;
        }
        ptrList(head);
        return head;
    }

    private void ptrList(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + ",");
            cur = cur.next;
        }
        System.out.println();
    }

    //     第一题， merge two sorted lists into one list 这个题有个新的限制，就是在merge的过程中要去除duplicate.鏈枃鍘熷垱鑷�1point3acres璁哄潧
// input (1,1, 2, 4, 4, 5) (2, 3, 4, 6, 6)
// output (1, 2, 3, 4, 5, 6).
/*
1,
  |
  pre
1-2-
*/
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
/*
用一个pre指针，以l1 为主线，把l2的元素apppend上来，因为要去重，中间会有很多check操作。
但因为有pre这个指针，判断重复，就是拿当前打算要append的元素跟pre相比，如果相同，则不能append
该元素，就应该到下一个。
 */
    public ListNode merge(ListNode l1, ListNode l2) {
        // mkae sure dummy node is not same with l1's head
        ListNode h = new ListNode(l1.val -1);
        h.next = l1;
        ListNode pre = h;

        while (l1 != null && l2 != null) {

            if (l2.val < l1.val) {
                ListNode next = l2.next; // save l2.next, bec it can be changed
                // insert l2 to between pre and l1,
                if (l2.val != pre.val) {
                    pre.next = l2;
                    l2.next = l1;
                    pre = l2;
                }
                l2 = next; // l2 move on

            // need to check if l1 is same as pre, need to remove l1
            } else if (l2.val > l1.val) {
                // System.out.println(l2.val+ " " + pre.val );
                if (l1.val == pre.val) {
                    pre.next = pre.next.next; // remove l1
                    l1 = pre.next; // let l1 point to next node
                } else {
                    l1 = l1.next;
                    pre = pre.next;
                }

            // l2==l1, just move on l2,don't append to pre
            } else {
                l2 = l2.next;
            }

        }

        while (l2 != null) {
            System.out.println(l2.val + " " + pre.val);
            if (l2.val == pre.val) {
                pre.next = pre.next.next;// remove this l2,and update l2 to next node
                l2 = pre.next;
            } else {
                pre.next = l2;
                pre = pre.next;
                l2 = l2.next;
            }
        }
        return h.next;
    }
}
