package  sort;
/**
 * Created by lipingxiong on 8/13/15.
 */
public class selectionSort {
    public static void main(String[] args){
        int[] A = {11,8,3,4,1};
        selectionSort(A);
        for(int e : A){
            System.out.print(e+" ");
        }

    }
    public static void selectionSort(int[] A) {
        for (int i = 0; i < A.length - 1 ; i++) {
            int iMin = i;
            for (int j = i+1; j < A.length; j++) {
                if (A[j] < A[iMin]) {
                    iMin = j;
                }
            }
            // swap with min elem,
            int temp = A[i];
            A[i] = A[iMin];
            A[iMin] = temp;
        }
    }

}
