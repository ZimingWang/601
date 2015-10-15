package DP;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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
