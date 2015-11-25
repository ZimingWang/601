package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by lipingxiong on 11/2/15.
 */
public class heaps {
    public int findKthLargest(int[] nums, int k) {
        if(nums==null || k>nums.length) return -1;
        final PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k,
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2 - o1;
                    }
                });

        for (int i = 0; i < k; i++) {
            heap.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > heap.peek()) {
                heap.offer(nums[i]);
            }
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }

}

