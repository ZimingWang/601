package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lipingxiong on 10/25/15.
 */
public class flipGame {
    public static void main(String[] args){
        System.out.println(generatePossibleNextMoves("++++"));
        System.out.println(generatePossibleNextMoves("--++"));
    }
    public static List<String> generatePossibleNextMoves(String s) {
        ArrayList<String> res = new ArrayList<>();
        char[] arr = s.toCharArray();
        int n = s.length();
        String tmp="--";
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1) && s.charAt(i)=='+') {
                res.add(s.substring(0, i - 1) + tmp + s.substring(i + 1));
            }
        }
        return res;
    }

}
