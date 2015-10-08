package sort;

/**
 * Created by lipingxiong on 9/11/15.
 */

public class mergeSort {
    private static int[] A; // the array need to be sorted
    private static int[] tmp; //temp array as same size as A's size

    public static void main(String[] args){
//        int[] input = {45,23,11,89,77,98,4,28,65,43};
        int[] input = {7,5};
        //int[] input = {2,1,3};
        ptrArr(input);
        mergeSort ms = new mergeSort();
        ms.mergeSort(input);
        ms.ptrArr(input);
    }

    public static void mergeSort(int[] input){
        A = input;
        tmp = new int[A.length];
        mergeSort(0,A.length-1);
    }
    /* 0 1
    m=(0+1)/2=0;
    mergeSort(0,0) one element,no need to sort,just return
    mergeSort(1,1)  one element, no need to sort
    merge(l,m,r) merge 0 and 1
    */
    public static void mergeSort(int l, int r){
        if(l>=r) return;  // base case,one element,mergeSort can return,and begin to merge
        int m=(l+r)/2; //middle
        mergeSort(l,m); //NOTE: (l,m)
        mergeSort(m+1,r);
        merge(l,m,r);
    }
    //merge two sorted array
    public static void merge(int l, int m, int r){
        //System.out.printf("l=%s,m=%s,r=%s\n",l,m,r);

        for(int i=l;i<=r;i++){
            tmp[i]=A[i]; //copy to temp array
        }
        int i=l;
        int j=m+1;
        int k=l;
        //merge two sorted part
        while(i<=m && j<=r){
            if(tmp[i]<tmp[j]) A[k++]=tmp[i++];
            else A[k++] = tmp[j++];
        }
        //still some left on the first part
        while(i<=m){
            A[k++]=tmp[i++];
        }
        //If j is still < r, no need to move,the elements j~r is already there
    }
    public static void ptrArr(int[] A){
        for(int x : A){
            System.out.print(String.valueOf(x) + ",");
        }
        System.out.println("\n");
    }
}
