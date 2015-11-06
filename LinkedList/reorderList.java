package LinkedList;

/**
 * AndrewID: lipingx
 */
    public class reorderList {
        public static class ListNode {
            int val;
            ListNode next;
            ListNode(int x){
                val = x;
            }
        };
        public static void main(String[] args){
//        ListNode head = new ListNode(1);
            ListNode head = createList(new int[]{1,2,3,4});
            long t0 = System.currentTimeMillis();
            reorderList(head);
            System.out.println(System.currentTimeMillis() - t0);
            ptrList(head);
        }

        public static ListNode reorderList(ListNode head) {
            if(head==null||head.next==null) return head;
            //Find the middle of the list
            ListNode walker = head;
            ListNode runner = head;
            while(runner.next!=null && runner.next.next!=null){
                walker=walker.next;
                runner=runner.next.next;
            }
            //reverse
            ListNode dummy =walker;
            ListNode last=walker.next;
            while(last.next!=null){
                ListNode cur = last.next;
                last.next = cur.next;
                cur.next = dummy.next;
                dummy.next =  cur;
            }
            ListNode p1=head;
            ListNode p2=dummy.next;

            while(p1!=dummy){
                dummy.next = p2.next;
                p2.next = p1.next;
                p1.next = p2;
                p1 = p2.next;
                p2 = dummy.next;
            }

            return head;
        }

        public static ListNode createList(int[] nums){
            ListNode head = new ListNode(nums[0]);
            ListNode cur = head;
            for(int i=1;i<nums.length;i++){
                ListNode node = new ListNode(nums[i]);
                cur.next = node;
                cur=node;
            }
            ptrList(head);
            return head;
        }
        public static void ptrList(ListNode head){
            ListNode cur = head;
            while(cur!=null){
                System.out.print(cur.val);
                cur=cur.next;
            }
            System.out.println();
        }
}
