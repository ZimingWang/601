package DP;

/**
 * Created by lipingxiong on 9/17/15.
 */
public class paintFence {
//    public int paintFence(int n,int k){
//        if(n==1) return k;
//        int same = k;
//        int diff = k*(k-1);
//
//        for(int i=2;i<n;i++){
//            int tmp = diff;
//            diff= (same+diff) * (n-1);
//            same = tmp;
//        }
//        return same + diff;
//    }

    public static int paintFence(int n,int k){
        if(n==0)return 0;
        if(n==1) return 1;
        // n==2
        int diffLastTwoCount = k * (k-1);
        int sameLastTwoCount = k;
        for(int i=3;i<=n;i++){
            int tmp = diffLastTwoCount;
            diffLastTwoCount = (sameLastTwoCount + diffLastTwoCount) * (k-1);
            sameLastTwoCount = tmp;
        }
        return sameLastTwoCount+diffLastTwoCount;
    }


}
