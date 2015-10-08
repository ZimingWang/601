package sort;
/**
 * Created by lipingxiong on 8/24/15.
 */
/* The idea is to sweep all 0s to the left and all 2s to the right, then all 1s are left in the middle.
01221
01122
    */
public class sortColors {
    public void sortColors(int[] A) {
        int l=0;
        int r=A.length-1;
        for(int i=0;i<=r;i++){
            if(A[i]==2 && i<r){
//                swap(A[i],A[r--]);
            }
            else if(A[i]==0 && i>l){
//                swap(A[l++],A[i]);
            }
        }
    }
}
