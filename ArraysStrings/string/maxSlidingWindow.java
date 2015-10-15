package ArraysStrings.string;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by lipingxiong on 10/13/15.
 */
public class maxSlidingWindow {
    public static void main(String[] args){
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;
        maxSlidingWindow2(nums,k);
//        maxSlidingWindow2(new int[]{},k);
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0 || nums.length ==0 ) {
            return new int[]{};
        }
        int[] res = new int[nums.length - k +1 ];
        PriorityQueue<Integer> heap = new PriorityQueue(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int i=0;i<k;i++){
            heap.offer(nums[i]);
        }
//        System.out.println("peek"+heap.peek());
        int j=0;

        for(int i=k;i<nums.length;i++) {
            res[j] = heap.peek();
//            System.out.println("resj"+res[j]);
            j++;
            heap.remove(nums[i-k]);
            heap.offer(nums[i]);
        }
        res[j] = heap.peek();
//        System.out.println(res);
        // ptrArr(res);
        return res;
    }
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        Queue<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length-k+1];
        int j = 0;
        for(int i=0;i<nums.length;i++) {
            if(queue.isEmpty()) queue.offer(nums[i]);
            else {
                while(!queue.isEmpty() &&  queue.peek() < nums[i]){
                    queue.poll();
                }
                queue.offer(nums[i]);
            }
            while(queue.size()>k){
                queue.poll();
            }
            if(i>=k-1){
                res[j++] = queue.peek();
            }
        }
        ptrArr(res);
        return res;
    }

    public static void ptrArr(int[] nums){
        for(int e:nums){
            System.out.println(e);
        }
    }
}
