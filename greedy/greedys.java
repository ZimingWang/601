package greedy;

import DP.DPs;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by lipingxiong on 10/11/15.
 * cur opt + subp(n-i)
 */
public class greedys {
    int bestTimeBuy(int[] p) {
        int sum = 0;
        for (int i = 1; i < p.length; i++) {
            if (p[i] > p[i - 1]) {
                sum += p[i] - p[i - 1];
            }
        }
        return sum;
    }
/*

    A = [2,3,1,1,4], return true.

    A = [3,2,1,0,4], return false.
    */
    boolean f(int[] nums){
        int max=0;
        for(int i=0;i<=max && i<nums.length;i++){
            int cur = i+nums[i];
            max=Math.max(max,cur);
            if(max>=nums.length-1) return true;
        }
        return  false;
    }
    public static void main(String[] args){
        greedys gd= new greedys();
        int[] coins = new int[]{ 5, 10, 20, 50};
        gd.minCoin(coins,70);
    }

    public  int minCoin(int[] coins,int v){
        int[][] dp = new int[coins.length+1][v+1];
        for(int i=0;i<=coins.length;i++) {
            for (int j = 0; j <= v; j++) {
                if(i==0) dp[i][j] = v;
                else if (j == 0) dp[i][j] = 0;
                else {
                    if (j >= coins[i-1]) {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]]) + 1;
                    } else dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[coins.length][v]);
        return dp[coins.length][v];
    }

}
