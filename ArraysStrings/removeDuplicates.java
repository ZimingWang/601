package ArraysStrings;

/**
 * Created by lipingxiong on 10/23/15.
 */
public class removeDuplicates {
    public int removeDuplicates2(int[] A) {
        int count=1;
        int l=1;
        for(int i=1;i<A.length;i++){
            if(A[i]==A[i-1]){
                count++;
                if(count > 2){
                    continue;
                }
            }
            else{
                count=1;
            }
            A[l++] = A[i];
        }
        return l;
    }
    // [1,1,2],
    public int removeDuplicates(int[] A) {
        int l=1;
        for(int i=0;i<A.length;i++){
            if(A[i]==A[i-1]){
                continue;
            }
            else A[l++] =A[i];
        }
        return l;
    }
}
