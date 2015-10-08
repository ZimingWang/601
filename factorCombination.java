import java.util.ArrayList;
import java.util.List;

/**
 * Created by lipingxiong on 9/2/15.
 * input=32
 [
 [2, 16],
 [2, 2, 8],
 [2, 2, 2, 4],
 [2, 2, 2, 2, 2],
 [2, 4, 4],
 [4, 8]
 ]
 */
public class factorCombination {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        gelFactors(n,2,new ArrayList<Integer>(),res);
        return res;
    }
    public void gelFactors(int n,int fac,List<Integer> cur, List<List<Integer>> res){
        for(int i=fac;i*i<n;i++){
            if(n/i==0) {
                cur.add(i);
                cur.add(n / i);
                res.add(new ArrayList<Integer>(cur));
                cur.remove(cur.size() - 1);
                gelFactors(n /i, i, cur, res);
            }
        }
    }
/*
    A = [2,3,1,1,4], return true.
    A = [3,2,1,0,4], return false.
 */
    public static boolean canJump(int[] A) {
        int n = A.length;
        boolean[] T = new boolean[n];
        T[0]=true;
        for(int i=1;i<n;i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] + j >= i) {
                    T[i] = true;
                    break;
                }
            }
        }
        return T[n-1];
    }
    public static void main(String[] args){
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJump(new int[]{3,2,1,0,4}));
    }

    public int numTrees(int n) {
        int[] T= new int[n+1];
        T[0]=1;
        T[1]=1;

        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++) {
                T[i] += T[j] * T[i-j-1];
            }
        }
        return T[n];
    }

}
