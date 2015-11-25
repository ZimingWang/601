package ArraysStrings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lipingxiong on 11/25/15.
 */
public class reorder {
    public static void main(String[] args) {
        reorder(new int[]{0,1,2,1,0});
    }
    public static int[] reorder(int[] a){
        if(a==null||a.length==0) return new int[0];
        int n = a.length;
        int[] b = new int[n];
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=n; i++){
            list.add(i);//1,2,3,4,5
        }
        for(int i=n-1; i>=0; i--){
            b[i] = list.remove(i - a[i]);
        }
        com.com.ptrArr(b);
        return b;
    }
}
