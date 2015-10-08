package DP;

/**
 * Created by lipingxiong on 8/28/15.
 */
public class LIS {
    //longest increasing subsequence
//    T[n]={1}
    public int LIS(int[] A){
        int n = A.length;
        if(n==0) return 0;
        int[] T = new int[n-1];
        for(int i=0;i<n;i++){
            T[i]=1;
        }
        for (int i = 1; i < n; i++) {
            for(int j=0;j<i;j++){
                if(j<i){
                    if(A[j]<A[i]){ //
                        T[i]=Math.max(T[i],T[j]+1);
                    }
                }
            }
        }
        return T[n-1];
    }
//    public void
}
