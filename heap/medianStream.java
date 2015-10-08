package heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by lipingxiong on 9/18/15.

If size is even:
    if num < maxHeap.peek:
        先到大堆
        把大堆的顶部移到小堆
    else: minHeap.offer(num)
else：
    if num > minHeap.peek:
        先到小堆
        把小堆顶部移动大堆
    else：maxHeap.offer(num)
*/

public class medianStream {
    /**
     * 降序比较器
     */
    private static class DescComparator implements Comparator<Double> {
        @Override
        public int compare(Double o1, Double o2) {
            if(o2 > o1) return 1;
            else if(o2 < o1) return -1;
            else return 0;
        }
    }

    public static double medianStream(double[] nums ){
        PriorityQueue<Double> minHeap = new PriorityQueue<>();// store large numbers
        PriorityQueue<Double> maxHeap = new PriorityQueue<Double>(1,new DescComparator());
//        Heap<Double> maxHeap = new Heap<>(new DescComparator());
        for(int i=0;i<nums.length;i++){
            if( (minHeap.size() + maxHeap.size())%2 == 0){//even,go to minHeap
                System.out.println("even "+nums[i]);
                if(maxHeap.size()>0 && nums[i] < maxHeap.peek()){
                    System.out.println("move maxHeap.peek() to minHeap");
                    maxHeap.offer(nums[i]);
                    double num = maxHeap.poll();
//                    System.out.println("maxHeap peek"+num);
                    minHeap.offer(num);
//                    ptrHeap(minHeap);
//                    ptrHeap(maxHeap);
                }
                else{

                    minHeap.offer(nums[i]);
                }
            }
            else{
                System.out.println("odd,go to maxHeap,nums[i]= "+nums[i]);
                if(nums[i] > minHeap.peek()){
                    minHeap.offer(nums[i]);
                    maxHeap.offer( minHeap.poll());
                }
                else{
                    maxHeap.offer(nums[i]);
                }
            }
        }
        double res = 0.;
        if( (minHeap.size()+maxHeap.size()) %2 !=0 ){
             res = minHeap.peek(); //假设现在已经有偶数个的时候，再加入一个，就是odd个数，而不管num是<maxHeap.peek OR else;
            //最后总是小堆比大堆多出来一个元素，所以medain 总是在minHeap.peek . t
        }
        else{
            res = (minHeap.peek()+maxHeap.peek() ) /2.0;
        }
        ptrHeap(minHeap);
        ptrHeap(maxHeap);
        return res;
    }
    public static void ptrHeap(PriorityQueue<Double> heap){
        if(heap.size() == 0) System.out.print("empty heap");
        ArrayList<Double> arr = new ArrayList<>();
        while (heap.size() >0){
            double num = heap.poll();
            System.out.print(num + " ");
            arr.add(num);
        }
        System.out.println();
        for(double num:arr){
            heap.offer(num);
        }
    }
    public static void main(String[] args){
        double[] nums = new double[]{3.,2.,1.,7.};
        System.out.println( "res="+ medianStream(nums) );
    }


}
