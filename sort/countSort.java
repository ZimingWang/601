package sort;

/**
 * Created by lipingxiong on 10/17/15.
 */
public class countSort {
    public static void main(String[] args){
//        sortColors(new int[]{1,2,1,2,0,0,0});
        countSort(new int[]{8,7,10,13});
    }
    public static void sortColors(int[] A){
        int[] C = new int[3];
        int[] res= new int[A.length];
        for(int i=0;i<A.length;i++){
            C[A[i]]++;
        }
        for(int i=1;i<3;i++){
            C[i] = C[i]+C[i-1];
        }
        for(int i=A.length-1;i>=0;i--){
            res[C[A[i]] -1] = A[i];
            C[A[i]]--;
        }
        com.com.ptrArr(res);
        return ;
    }

    // C[] 的大小是 数组中最大-最小+1.
    public static void countSort(int[] A){
        int[] res= new int[A.length];
        int min=A[0],max=A[0];
        for(int i=0;i<A.length;i++){
            min=Math.min(min,A[i]);
            max=Math.max(max,A[i]);
        }
        int range = max-min+1;
        int[] C = new int[range];

        for(int i=0;i<A.length;i++){
            C[A[i]-min]++;
        }
        for(int i=1;i<range;i++){
            C[i] = C[i]+C[i-1];
        }
//        取C数组中元素时候记得减去min
        for(int i=A.length-1;i>=0;i--){
            res[C[A[i]-min] -1] = A[i];
            C[A[i]-min]--;
        }
        com.com.ptrArr(res);
        return ;
    }
}
