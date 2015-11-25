package DP;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by lipingxiong on 9/8/15.
 */
public class DPs {
    /*
    1,2,-1,0,5,
    * */
    public static void main(String[] args){
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(0, 5));
    }
    public static class NumArray {
        int[] t ;
        public NumArray(int[] nums) {
            int n = nums.length;
            t = new int[n];
            t[0] = nums[0];
            for(int i=1;i<n;i++){
                t[i] = t[i-1] + nums[i];
            }

        }

        public int sumRange(int i, int j) {
            if(i==0) return t[j];
            return t[j] - t[i-1];
        }
    }

    void knapSack(int[] wgt,int[] vals, int wt){
        int n = wgt.length;
        int[][] t = new int[n][n];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=wt;j++){
                if(j >= wgt[i]) {
                    t[i][j] = Math.max(t[i-1][j], t[i-1][j - wgt[i-1]] + vals[i-1]);
                }
                else t[i][j] =t[i-1][j];
            }
        }
    }

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

    int cut_ord(int[] p,int n) {
        int m  = p.length;
        int[][] dp = new int[m+1][n+1];
        for(int i=1;i<=m;i++) {
            for (int j = 0; j <= n; j++) {
                System.out.println(i+" "+j);
                if(i==0 || j==0)dp[i][0]=0;

                if(j>=i) dp[i][j] = Math.max(dp[i][j-i] + p[i-1], dp[i-1][j]);
                else dp[i][j]=dp[i-1][j];
            }
        }
        System.out.println(dp[m][n]);
        return dp[m][n];
    }

}
