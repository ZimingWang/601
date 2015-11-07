package DP;

import java.util.ArrayList;

/**
 * Created by lipingxiong on 10/14/15.
 * 可以走1，2，4， 要到达5，总共有几种方法。就是staircase 问题

 https://www.youtube.com/watch?v=CFQk7OQO_xM&index=16&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr

 A={1,2,4} 可以走1步，2步，4步

 要到1， 从0开始，能用的step只有1，因为满足i > A[j]的只有j=0, A[j]=1,所 T[1]=T[1-A[0]] = T[0]
 要到2， 从0开始，能用的step只有1,2，因为满足i > A[j]的只有j=0,j=1,
 所以 T[2]=T[2-A[0]] + T[2-A[1]] = T[1] + T[0] = 2; 也就是要到达2，可以从0开始走2步，或者从1开始走1步。
 方法总数就是 T[1] + T[0]


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
//        能走的步骤数
        int[] A = new int[]{1,2,4};
//        分别到0,1,2,3,4,5 有多少种方法
        long[] res = cp.countPaths(A,new int[]{0,1,2,3,4,5}) ;
        com.com.ptrArrLong(res);
//        System.out.println( res[0] + " "+res[1] + " "+ res[2] + " "+res[3]);

    }

}
