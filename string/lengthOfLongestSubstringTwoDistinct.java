package string;

import java.util.HashMap;

/**
 * Created by lipingxiong on 10/13/15.
 * Given a string, find the length of the longest substring T that contains at most 2 distinct characters.

 For example, Given s = “eceba”,

 T is "ece" which its length is 3.
 */
public class lengthOfLongestSubstringTwoDistinct {
    public static void main(String[] args){
        lengthOfLongestSubstringTwoDistinct("e");
    }
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length()==0) return 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0,i=0;
        for (; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                if (map.size() == 2) {
                    max = Math.max(max, i - start);
                    while (map.size() == 2) {
                        ch = s.charAt(start);
                        map.put(ch, map.get(ch) - 1);
                        if (map.get(ch) == 0) {
                            map.remove(ch);
                        }
                        start++;
                    }
                }
                map.put(s.charAt(i), 1);
            }
        }
        //注意最后这里一定要加
        max = Math.max(max,i-start);
//        System.out.println(max);
        return max;
    }

}
