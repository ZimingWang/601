package ArraysStrings;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by lipingxiong on 10/9/15.
 * 用一heap，each elem is a arrNode, need to implement comparator
 * arr k*n
 */
public class mergeKsortedArr {
    public static void main(String[] args){
        mergeKsortedArr o = new mergeKsortedArr();
//        int[] a = new int[];
        int[][] arr={ {1, 3, 5, 7},
                {2, 4, 6, 9},
                {0, 8, 10, 11}};
        o.mergeKsorted(arr);
    }
    public class arrNode{
        int val;
        int i;
        int j;
        public arrNode(int x, int row, int col){
            val=x;
            i=row;
            j=col;
        }
    }
    public static class comp implements Comparator<arrNode> {
        @Override
        public int compare(arrNode o1, arrNode o2) {
            return o1.val-o2.val;
        }
    }
    public int[] mergeKsorted(int[][] arr){
        int k = arr.length;
        PriorityQueue<arrNode> heap = new PriorityQueue<arrNode>(k,new Comparator<arrNode>(){
            @Override
            public int compare(arrNode o1, arrNode o2) {
                return o1.val-o2.val;
            }
        });
        for(int i=0;i<k;i++){
            arrNode node = new arrNode(arr[i][0],i,0);
            heap.offer(node);
        }
        int n = arr[0].length;
        int[] res = new int[n*k];
        for(int c=0;c<n*k;c++){
            arrNode node = heap.poll();
            res[c]=node.val;
            int i = node.i;
            int j = node.j;
            System.out.println(res[c]+" "+i+" "+ j);
            //remember to check j,otehrwise will overflow,and remember to update j to j+1
            if(j<n-1)heap.offer(new arrNode(arr[i][j+1],i,j+1));
        }
//        System.out.println(res);
        return res;
    }

}
