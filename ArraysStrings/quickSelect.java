package ArraysStrings;

import java.util.Random;

/**
 */
public class quickSelect {

    // 从l到r随机pick一个数字，将该数字和末尾的数字swap，然后在用常规的partition，就是把末尾的数字当做pivot。
//    产生随机数，random.nextInt（rang） 产生0-range-1 的数字，因为是要在l-r中产生随机数，就要用random.nextInt(range) + l;

//    public int kthSmalle(){

//    }
    public int randomPartition(int[] arr,int l,int r){
        Random random = new Random();
        int range = r-l+1;

        int pivot = random.nextInt(range) + l;
        swap(arr,pivot,r);
        return partition(arr,l,r);
    }
    public int partition( int[] arr,int l, int r){
        int pivot = l;
        int lastValue = arr[r];

        for(int i=l;i<r;i++){
            if(arr[i] < lastValue){
                swap(arr,i,pivot);
//                int tmp = arr[i];
//                arr[i] = arr[pivot];
//                arr[pivot] = tmp;
                pivot++;
            }
        }
        swap(arr,pivot,r);
//        int tmp = arr[r];
//        arr[r] = arr[pivot];
//        arr[pivot] = tmp;
        return pivot;
    }

    public void swap(int[] arr,int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
