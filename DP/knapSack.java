package DP;

/**
 * Created by lipingxiong on 11/7/15.
 *  * 0/1 Knapsack Problem - Given items of certain weights/values and maximum allowed weight
 * how to pick items to pick items from this set to maximize sum of value of items such that
 * sum of weights is less than or equal to maximum allowed weight.
 *
 * Time complexity - O(W*total items)
 *
 * References -
 * http://www.geeksforgeeks.org/dynamic-programming-set-10-0-1-knapsack-problem/
 * https://en.wikipedia.org/wiki/Knapsack_problem
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/Knapsack01.java
 *
 */
public class knapSack {
    public static void main(String[] args){
        System.out.println(knapSack(new int[]{1, 3, 4, 5}, new int[]{1, 4, 5, 7}, 7));
    }
    //bottom up
    public static int  knapSack(int[] wgt, int[] val, int c){
        int n = wgt.length;
        //n+1, c+1 , row 0 and col 0 is added for simplisity
        int[][] t = new int[n+1][c+1];

        //when row is i, the wgt and val is wgt[i-1],val[i-1],because row 0 is used for
        // simplisity,so row 1 <-> wgt[0], row number start from 1, but index of wgt[] is from 0.
        //
        for(int i=0;i<=n;i++){
            for(int j=0;j<=c;j++){
                if(j==0 || i==0) t[i][j] = 0;
                else{
                    if(j<wgt[i-1]){
                        t[i][j] = t[i-1][j];
                    }
                    else{
                        t[i][j] = Math.max(t[i-1][j-wgt[i-1]] + val[i-1], t[i-1][j]);
                    }
                }
            }
        }
        return t[n][c];
    }
}
