package ArraysStrings.string;

import java.util.HashSet;

/**
 * Created by lipingxiong on 10/13/15.
 Given a string, find the length of the longest substring without repeating characters. For example, the longest substring
 without repeating letters for "abcabcbb" is "abc", which the length is 3.
 For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class lengthOfLongestSubstring {
    public static void main(String[] args){
        lengthOfLongestSubstring("abcabcbb");
        lengthOfLongestSubstring("b");
    }
    public static int lengthOfLongestSubstring(String s){
        HashSet<Character> set = new HashSet<>();
        int start=0,max=0;
        int i=0;
        for(;i<s.length();i++){
            char ch = s.charAt(i);
            if(set.contains(ch)){
                max=Math.max(max,i-start);
                while(s.charAt(start)!=ch){
                    set.remove(s.charAt(start));
                    start++;
                }
                start++;
            }
            else {
                set.add(ch);
            }
        }
//        注意这里还要在进行一次，因为可能到末尾也没有出现重复的，那么就要算末尾-start的长度
        max = Math.max(max,i-start);
        System.out.println(max);
        return max;
    }
}
