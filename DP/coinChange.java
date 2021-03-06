package DP;

import java.util.Scanner;

/**
 * Created by lipingxiong on 10/13/15.
 */
public class coinChange{
//    N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}.
//For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}

    public static void main(String args[] ) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
//        Scanner in = new Scanner(System.in);
//        String[] split = in.nextLine().split(" ");// first line
//        int[] A = new int[split.length];
//        for(int i=0; i<split.length; i++)
//            A[i] = Integer.parseInt(split[i]);
//        int N = Integer.parseInt(in.nextLine().trim()); // 2nd line
//        int[] T = new int[N];
//        for(int i=0; i<N; i++) {
//            T[i] = Integer.parseInt(in.nextLine().trim());
//        }
//        long[] numWays = numWays(A, T);
//
//        for(long c : numWays)
//            System.out.println(c);
//        in.close();


    }

/*
    https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/CoinChanging.java
    http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
    */
    private static long[][] countWays(int[] coins,int c){
        int m = coins.length;
        long[][] dp = new long[m+1][c+1];
        // row 0 is 0,no coins, no way to get any value
        //col 0 is 1,c==0时候，只有一种方法，就是一个coin都不用，所以第一列都是1
        for(int i=0;i<=m;i++){
            dp[i][0]=1;
        }
        // use mod to avoid overflow
        long mod = (long)(Math.pow(10,9)+7);

        for(int i=1;i<=m;i++){
            for(int j=1;j<=c;j++){
//                只有当c大于当前coin的值的时候，才有可能用该coin
                if (j >= coins[i-1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i-1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
                dp[i][j] = dp[i][j] % mod ;
            }
        }
        return dp;
    }

    public int minCoinNum(int[] coins, int c){
        int m = coins.length;
        int[][] t = new int[m+1][c+1];
        //col 0 is 0: need 0 coins to get val 0
        for(int i=0;i<=m;i++){
            t[i][0] = 0;
        }
        //row 0 is MAX, used for simplisity
        for(int i=0;i<=c;i++){
            t[0][i] = Integer.MAX_VALUE;
        }
        //j>coins[i-1],we can use coins[i-1],the update t[i][j],
        for(int i=1;i<=m;i++){
            for(int j=1;j<=c;j++){
                if(j >= coins[i-1]){
                    t[i][j] = Math.min(t[i-1][j],t[i][j-coins[i-1]] + 1 );
                }
                else t[i][j] = t[i-1][j];
            }
        }
        return t[m][c];
    }


    private static long[] numWays(int[] A, int[] T){
        int j=0;
        int max=0;

        for(int i=0;i<T.length;i++){
            max = Math.max(max, T[i]);
        }
        long[][] ways = countWays(A, max);
        long[] res = new long[T.length];
        for(int i=0;i<T.length;i++){
            res[i] = ways[A.length][T[i]];
        }
        return res;

    }

//    int count( int S[], int m, int n )
//    {
//        // table[i] will be storing the number of solutions for
//        // value i. We need n+1 rows as the table is consturcted
//        // in bottom up manner using the base case (n = 0)
//        int table[n+1];  //S = { S1, S2, .. , Sm} ,val N
//
//        // Initialize all table values as 0
//        memset(table, 0, sizeof(table));
//
//        // Base case (If given value is 0)
//        table[0] = 1;
//
//        // Pick all coins one by one and update the table[] values
//        // after the index greater than or equal to the value of the
//        // picked coin
//        for(int i=0; i<m; i++)
//            for(int j=S[i]; j<=n; j++)
//                table[j] += table[j-S[i]];
//
//        return table[n];
//    }
//    private static long[] countWays(int[] coins,int n){
//        int m = coins.length;
//        long[] T = new long[n+1];
//        T[0] =1;
//        for(int i=0;i<m;i++){
//            for(int j=coins[i];j<=n;j++) {
//                T[i] += T[j - coins[i]];
//            }
//        }
//        return T;
//    }
}
