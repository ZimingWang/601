package DP;

import java.util.ArrayList;

/**
 * Created by lipingxiong on 10/14/15.
 */
public class countPaths {

    static long[] countPaths(int[] A, int[] T) {
        int max = 0;
        for(int i=0;i<T.length;i++){
            max = Math.max(max,T[i]);
        }
        long[] ways = countWays(A, max);
        long[] res = new long[T.length];
        for(int i=0;i<T.length;i++){
            res[i] = ways[T[i]];
        }
        return res;
    }
    public static long[] countWays(int[] A, int target){
        long[] T = new long[target+1];
        T[0] = 1;
        long mod = (long)(Math.pow(10,9) + 7);
        for(int i=0;i<=target;i++){
            for(int j=0;j<A.length;j++){
                if(i>=A[j]){
                    T[i] += T[i - A[j]];
                    T[i] = T[i] % mod;
                }
            }
        }
        return T;
    }

    public static void main(String args[]){
        countPaths cp = new countPaths();
        int[] A = new int[]{1,2,4};
//        int[] T=new int[]{0,10};
        long[] res = cp.countPaths(A,new int[]{0,3,5}) ;
        System.out.println( res[0] + " "+res[1] + " "+ res[2]);

    }
}
