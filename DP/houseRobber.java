package DP;

/**
 * Created by lipingxiong on 8/23/15.
 * No, it is similar to dp, you could consider a as previous max num at even, b as previous max num at odd.
 * 我觉得首先理解动态规划之后，可以发现这道题求最优解的过程中本质上只需要两个中间变量，所以便只需要O(1)的空间复杂度O(∩_∩)O。
 * https://leetcode.com/discuss/30079/c-1ms-o-1-space-very-simple-solution
 */
public class houseRobber {
    public int rob(int[] nums) {
        int a=0;
        int b=0;
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                a=Math.max(a+nums[i],b);
            }
            else{
                b=Math.max(b+nums[i],a);
            }
        }
        return Math.max(a,b);
    }
    public  int notAdj(int[] arr){
        int incl=arr[0];// include the first one
        int excl=0; // exlude  the first one
        int n = arr.length;
        for(int i=1;i<n;i++){
            incl = Math.max(excl+arr[i],incl);
            excl = incl;
        }
        return incl;
    }

    public static int hRob(int[] nums){
        int incl = nums[0];
        int excl = 0;
        for(int i=1;i<nums.length;i++){
            int tmp = incl;
            incl = Math.max(incl,excl + nums[i]);
            excl = tmp;
        }
        return Math.max(incl,excl);
    }



}
