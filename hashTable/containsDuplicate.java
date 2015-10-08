package hashTable;

import java.util.TreeSet;

/**
 * Created by lipingxiong on 8/23/15.
 */
public class containsDuplicate {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) { // t can be 0
            return false;
        }
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            Integer floor = set.floor(nums[i]+t); // find x<=nums[i]+t ,
            Integer ceil = set.ceiling(nums[i] - t); // find x >=nums[i]-t
            // nums[i]=<x<=nums[i]+t ;    nums[i] >=x > = nums[i]-t
            if(floor!=null && floor>=nums[i]
                    || ceil!=null && ceil<=nums[i]){
                return true;
            }
            set.add(nums[i]);
            if(i>=k){ //set size is k
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
