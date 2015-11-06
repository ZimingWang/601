package Math;

import java.util.ArrayList;

/**
 * Created by lipingxiong on 10/29/15.
 */
public class FibonacciCoding {
    public static void main(String[] args){
//        System.out.println(encode(65));
        System.out.println(encode(4));
        System.out.println(encode(5));
        System.out.println(encode(6));
//        assert();
    }

    public static String encode(int n){
        if(n<1) return "";
        StringBuilder res = new StringBuilder();
        ArrayList<Integer> fibNum = new ArrayList<>();
//        int index = 1;
        fibNum.add(1);
        fibNum.add(2);
        while(fibNum.get(fibNum.size()-1)<n){
            int m = fibNum.size();
            fibNum.add(fibNum.get(m-1) + fibNum.get(m-2) );
        }

        if(fibNum.get(fibNum.size()-1)>n) fibNum.remove(fibNum.size()-1); //remove the last

        for(int e:fibNum){
            System.out.println(e);
        }
        System.out.println(fibNum.size());
        int i=fibNum.size()-1;

        while(i>=0){
            System.out.printf("i=%d,fibNum=%d,n=%d\n", i, fibNum.get(i),n);
            if(fibNum.get(i) <= n){
                res.append("1");
                n -= fibNum.get(i);
            }
            else{
                res.append('0');
            }
            i--;
        }
        res = res.reverse();
        res.append("1");
        return res.toString();

    }
}
