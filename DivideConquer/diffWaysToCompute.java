package DivideConquer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lipingxiong on 8/23/15.
 */
public class diffWaysToCompute {

    public static List<Integer> diffWaysToCompute(String input){
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<input.length();i++){
            if (input.charAt(i) == '-' ||
                    input.charAt(i) == '*' ||
                    input.charAt(i) == '+' ) {
                List<Integer> list1 = diffWaysToCompute(input.substring(0, i)); //0->i
                List<Integer> list2 = diffWaysToCompute(input.substring(i + 1));//i+1 -> n
                for (Integer n1 : list1) {
                    for (Integer n2 : list2) {
                        int temp=0;
                        switch (input.charAt(i)){
                            case '-': temp=n1-n2;break;
                            case '*': temp = n1*n2;break;
                            case '+': temp =n1+n2;break;
                        }
                        res.add(temp);
                    }
                }
            }
        }
        if(res.size()==0){
            res.add(Integer.parseInt(input));
        }
        return res;
    }
   public static void main(String[] args){
       System.out.println(diffWaysToCompute("1+2"));
   }
}

/*
public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ret = new LinkedList<Integer>();
        for (int i=0; i<input.length(); i++) {
            if (input.charAt(i) == '-' ||
                input.charAt(i) == '*' ||
                input.charAt(i) == '+' ) {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i+1);
                List<Integer> part1Ret = diffWaysToCompute(part1);
                List<Integer> part2Ret = diffWaysToCompute(part2);
                for (Integer p1 :   part1Ret) {
                    for (Integer p2 :   part2Ret) {
                        int c = 0;
                        switch (input.charAt(i)) {
                            case '+': c = p1+p2;
                                break;
                            case '-': c = p1-p2;
                                break;
                            case '*': c = p1*p2;
                                break;
                        }
                        ret.add(c);
                    }
                }
            }
        }
        if (ret.size() == 0) {
            ret.add(Integer.valueOf(input));
        }
        return ret;
    }
}
 */



