package DP;

/**
 * Created by lipingxiong on 9/17/15.
 */
public class paintFence {
    public int paintFence(int n,int k){
        if(n==1) return k;
        int same = k;
        int diff = k*(k-1);

        for(int i=2;i<n;i++){
            int tmp = diff;
            diff= (same+diff) * (n-1);
            same = tmp;
        }
        return same + diff;
    }
}
