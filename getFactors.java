import java.util.ArrayList;
import java.util.List;

/**
 * Created by lipingxiong on 8/23/15.
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

public class getFactors {
    public List<ArrayList<Integer>> getFactors(int n) {
        List<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        getFactors(n, 2, new ArrayList<Integer>(), res);
        return res;
    }
    public void getFactors(int n,int fac,List<Integer> cur, List<ArrayList<Integer>> res){
        for(int i=fac;i*i<=n;i++){
            if(n%i==0){
                cur.add(i);
                cur.add(n/i);
                res.add(new ArrayList<Integer>(cur));
                cur.remove(cur.size()-1);
                getFactors(n/i,i,cur,res);
                cur.remove(cur.size()-1);
            }
        }
    }
}













    /* from discuss
public class getFactors {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        gelFactors(n,2,new ArrayList<Integer>(),res);
        return res;
    }
    public void gelFactors(int n,int fac,List<Integer> cur, List<List<Integer>> res){
        for(int i=fac;i*i<=n;i++){
            if(n %i == 0){
                cur.add(i);
                cur.add(n/i);
                res.add(new ArrayList<Integer>(cur));
                cur.remove(cur.size()-1);
                gelFactors(n/i,i,cur,res);
                cur.remove(cur.size()-1);
            }
        }
    }
}
*/