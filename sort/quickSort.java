package sort;

/**
 * Created by lipingxiong on 9/11/15.
 */
public class quickSort {
//    private static int[] A;
    public static void main(String[] args){
        int[] A={7,2,1,6,8,5,3,4};
//        int[] A={2,1,3};
        ptrArr(A);
        quickSort qs= new quickSort();
        qs.quickSort(A, 0, A.length - 1);
        ptrArr(A);
    }
    public void quickSort(int[] A, int start, int end){
//        注意这里是>=, 光用大于会死循环
        if(start>=end) return;
        int pIndex = partition(A,start, end);
        quickSort(A, start, pIndex - 1);
        quickSort(A, pIndex + 1, end);
    }
    public static int partition(int[] A, int start, int end){
        int pv=A[end];
        int idx = start;
        for(int i=start;i<end;i++){
            if(A[i]<=pv){
                int tmp=A[i];
                A[i]=A[idx];
                A[idx++]=tmp;
            }
            ptrArr(A);
        }
        int tmp = A[idx];
        A[idx]=A[end];
        A[end]=tmp;
        ptrArr(A);

        System.out.printf("start=%d,end=%d,pivote idx=%d, A[idx]=%d\n",start,end,idx, A[idx]);
        return idx;
    }

    public static void ptrArr(int[] num){
        for(int k=0;k<num.length;k++){
            System.out.print(num[k]+",");
        }
        System.out.println();
    }

}

