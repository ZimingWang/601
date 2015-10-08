package sort;

/**
 * Created by lipingxiong on 9/11/15.
 */
public class quickSort {
    public void quickSort(int[] A, int start, int end){
        if(start>end) return;
        int pIndex = partition(A,0, A.length-1);
        quickSort(A,start,pIndex-1);
        quickSort(A,  pIndex+1, end);

    }
    public int partition(int[] A, int start, int end){
        int pivot = A[end];
        int pIndex = start;
        int tmp;
        for(int i=0;i<A.length;i++){
            if(A[i]<=pivot){
                tmp = A[i];
                A[i]= A[pIndex];
                A[pIndex]=tmp;
                pIndex++;
            }
        }
        tmp = A[pIndex];
        A[pIndex] = A[end];
        A[pIndex] = tmp;
        return pIndex;
    }

}

