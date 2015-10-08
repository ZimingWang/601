package backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lipingxiong on 9/4/15.
 */
public class strobogrammatic {
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }

    List<String> helper(int n, int m) {
        if (n == 0) return new ArrayList<String>(Arrays.asList(""));
        if (n == 1) return new ArrayList<String>(Arrays.asList("0", "1", "8"));

        List<String> list = helper(n - 2, m);

        List<String> res = new ArrayList<String>();

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            //最外层不能是0，010 这种不行，这个不是数字；所以n==m的时候，不能加这层0
            if (n != m) res.add("0" + s + "0");

            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("8" + s + "8");
            res.add("9" + s + "6");
        }

        return res;
    }

    public static void main(String args[]){
        strobogrammatic ins =new strobogrammatic();
        System.out.println(ins.findStrobogrammatic(3));
        System.out.println(ins.findStrobogrammatic(4));
    }
}
