package LinkedList;

import java.util.*;

/**
 * Created by lipingxiong on 10/29/15.
 */
public class LinkedLists {
    public static class ListNode{
        ListNode next;
        int val;
        ListNode(int e){
            this.val = e;
            this.next = null;
        }
    }
    public static void main(String[] args){
        LinkedLists ls = new LinkedLists();
//        int[] res = ls.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
//        int[] res = ls.maxSlidingWindow(new int[]{1,-1},1);
        int[] res = ls.maxSlidingWindow(new int[]{1,3,1,2,0,5},3);
        com.com.ptrArr(res);
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0 || nums.length ==0 ) {
             return new int[]{};
         }
//        Queue<Integer> q = new LinkedList<>();
        Deque<Integer> q = new ArrayDeque<>();

        int[] res = new int[nums.length-k+1];
        int idx =0;

        for(int i=0; i<nums.length; i++){
            while(!q.isEmpty() && q.peek() < i-k+1){
                q.poll();
            }
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i] ){
                q.pollLast();
            }
            q.offer(i); //save the index
            if(i>=k-1) {
                res[idx++] = nums[q.peek()];
            }

        }
        return res;
    }
}
