package string;

import java.util.HashSet;

/**
 */
public class longestWithoutRepeat {
    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring("a"));
        System.out.println(lengthOfLongestSubstring("cdd"));

    }
    public static int lengthOfLongestSubstring(String s){
        if(s==null || s.length()==0) return 0;
        HashSet<Character> set = new HashSet<>();
        int start=0;
        int max=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!set.contains(ch)) set.add(ch);
            else {
                max = Math.max(i - start, max);

                while (start < s.length() && s.charAt(start) != ch) {
                    set.remove(s.charAt(start));
                    start++;
                }
                start++;
            }
        }
        max = Math.max(max,s.length()-start);
        return max;
    }
}
