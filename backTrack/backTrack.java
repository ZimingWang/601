package backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lipingxiong on 9/10/15.
 */
/*
input: 12
        output:
        [
        [2, 6],
        [2, 2, 3],
        [3, 4]
        ]
        input: 32
        output:
        [
        [2, 16],
        [2, 2, 8],
        [2, 2, 2, 4],
        [2, 2, 2, 2, 2],
        [2, 4, 4],
        [4, 8]
        ]
*/
public class backTrack {
    public static void main(String[] args){
        System.out.println( combine(4,2));
    }
    public static List<List<Integer>> combinationSum3(int k, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        docombine(1, target, new ArrayList<Integer>(), res, k);
        System.out.println(res);
        return res;
    }

    public static void docombine(int start,int target,
                                 ArrayList<Integer> item, List<List<Integer>> res, int k){
        if(target<0||item.size()>k) return;
        if(target == 0 && item.size() == k){
            res.add(new ArrayList<Integer>(item));
            return;
        }

        for(int i=start;i<10;i++){
            item.add(i);
            docombine(i+1,target-i,item,res,k);
            item.remove(item.size()-1);
        }
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
        if(item.size() > k) return;
        if(item.size()==k){
            res.add(new ArrayList<Integer>(item));
            return;
        }

        for(int i=start;i<A.length;i++){
            if(i>start && A[i]==A[i-1]) continue;//just add one line
            item.add(A[i]);
            domysubsets(A,i+1,item,res,k);
            item.remove(item.size()-1);
        }
    }

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        gelFactors(n,2,new ArrayList<Integer>(),res);
        return res;
    }
    public void gelFactors(int n,int fac,List<Integer> cur, List<List<Integer>> res){
        for(int i=fac;i*i<=n;i++){
            cur.add(i);
            cur.add(n/i);
            res.add(cur);
            cur.remove(cur.size()-1);
            gelFactors(n/i,i,cur,res);
            cur.remove(cur.size()-1);
        }
    }


}
