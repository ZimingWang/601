package ArraysStrings;

import java.util.Random;

/**
 * 用quickSelect方法解决 kthSmallest 问题。
 * 常规的partition，就是把末尾的数字当做pivot。而quick select需要的是randomly 选择pivot。目的是让分开的尽量均衡。
 * 如果总选择最后一个数当pivot，可能就会分的不均衡。
 */
public class quickSelect {
    public static void main(String[] args){
        quickSelect qs = new quickSelect();
        int[] A=new int[]{7,5,3,1,2,6,4};
//        int[] A=new int[]{1,2,3,4};
        System.out.println(qs.kthSmallest(A, 0, A.length-1, 1));
        System.out.println(qs.kthSmallest(A, 0, A.length-1, 2));
        System.out.println(qs.kthSmallest(A, 0, A.length-1, 3));
        System.out.println(qs.kthSmallest(A, 0, A.length-1, 4));
    }
    // 从l到r随机pick一个数字，将该数字和末尾的数字swap，然后在用常规的partition，就是把末尾的数字当做pivot。
//    产生随机数，random.nextInt（rang） 产生0-range-1 的数字，因为是要在l-r中产生随机数，就要用random.nextInt(range) + l;

    public int kthSmallest(int[] arr, int l, int r, int k){
        if(k <= 0 || k > r - l + 1) return Integer.MIN_VALUE;
//        int pos = randomPartition(arr, l, r);
        int pos = partition(arr, l, r);
        if(pos - l == k-1) return arr[pos];
        else if(pos - l > k - 1) {
            return kthSmallest(arr, l, pos - 1, k);
        }
        return kthSmallest(arr, pos + 1, r, k - (pos-l+1));
    }

    public int randomPartition(int[] arr,int l,int r){
        Random random = new Random();
        int range = r-l+1;

        int pivot = random.nextInt(range) + l;
        swap(arr,pivot,r);
        return partition(arr,l,r);
    }

    public int partition( int[] arr,int l, int r){
        int pivot = l;  //枢轴,中心
        // 以lastValue 作为分界点，
        int lastValue = arr[r];
        //把比lastValue 小的都交换到pivot 的前面。注意这里的i是要从l开始的。而不是从l+1，否则会错。
        for(int i=l; i<r; i++){
            if(arr[i] < lastValue){
                swap(arr,i,pivot);
                pivot++;
            }
        }
        //别忘了最后把lastValue换到pivot位置，最终pivot左边的都比lastValue小，右边的都大
        swap(arr, pivot, r);
//        System.out.println(arr[pivot]);
        return pivot;
    }

    public void swap(int[] arr,int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
