package backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lipingxiong on 9/13/15.
 */
public class combination {
    public static void main(String[] args){
        System.out.println( combine(4,2));
    }
    public static List<ArrayList<Integer>> combine(int n,int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int[] A=new int[n];
        for(int i=0;i<n;i++){
            A[i]=i+1;
        }
        if(A==null || A.length ==0) return res;
        Arrays.sort(A);
        domysubsets(A,0, new ArrayList<Integer>(), res,k);
        return res;
    }
    public static void domysubsets(int[] A, int start,ArrayList<Integer> item, ArrayList<ArrayList<Integer>> res,int k){
//        if(item.size()>k) return;

        if(k<1){
            res.add(new ArrayList<Integer>(item));
            return;
        }
        for(int i=start;i<A.length;i++){
            item.add(A[i]);

                domysubsets(A, i + 1, item, res, k - 1);
                item.remove(item.size() - 1);
        }
    }
}
