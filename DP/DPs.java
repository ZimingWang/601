package DP;

/**
 * Created by lipingxiong on 9/8/15.
 */
public class DPs {
    public int rob(int[] nums) {
        int incl;
        int excl;
        incl = nums[0];
        excl = 0;
        for(int i=1;i<nums.length;i++){
            int tmp = incl;
            incl = Math.max(excl + nums[i], tmp);
            excl = incl;
        }
        return Math.max(excl,incl);
    }
}
