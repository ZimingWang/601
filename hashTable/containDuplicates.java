package hashTable;

import java.util.HashMap;

/**
 * Created by lipingxiong on 8/15/15.
 */
public class containDuplicates {
    public static void main(String[] args){
//        System.out.println(containsDuplicate(new int[]{1, 2, 3}));
//        System.out.println(containsDuplicate(new int[]{1, 2, 3, 3}));
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 6));
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 1}, 0));
    }
    public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int e:nums){
            if(map.containsKey(e)) return true;
            else{
                map.put(e,1);
            }
        }
        return false;
    }
    public static boolean containsNearbyDuplicate(int[] nums, int k){
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
           Integer res = hmap.put(nums[i], i);
            if(res != null && (i-res)<=k){
                return true;
            }
        }
        return false;
    }
}
