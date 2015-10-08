package DP;

/**
 * Created by lipingxiong on 8/26/15.
 Question:
 Find the contiguous subarray within an array (containing at least one number) that has the largest sum.
 For example, given the array [2, 1, –3, 4, –1, 2, 1, –5, 4], The contiguous array [4, –1, 2, 1] has the largest sum = 6.
 */
public class maxSumArray {
    public int maxSubArray(int[] A) {
        int maxEndingHere=A[0],maxSoFar=A[0];
        int n = A.length;
//        int[] T= new int[n];
//        T[0] = A[0];
        for(int i=1;i<n;i++){
            maxEndingHere = Math.max( maxEndingHere+A[i], A[i]);
        }
        return 0;
    }
}
