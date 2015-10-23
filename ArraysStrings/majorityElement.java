package ArraysStrings;

/**
 * Created by lipingxiong on 10/22/15.
 */
public class majorityElement {
    public static int majorityElement(int[] nums) {
        int cand = nums[0];
        int count=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                count++;
            }
            else {
                count--;
                if(count==0){
                    cand = nums[i];
                    count=1;
                }
            }
        }
        count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==cand) count++;
        }
        if(count>nums.length/2) return cand;
        return -1;
    }

}
