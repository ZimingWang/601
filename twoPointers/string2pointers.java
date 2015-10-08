package twoPointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lipingxiong on 9/9/15.
 */
public class string2pointers {
    public  static void main(String args[]){
//        System.out.println(ins.restoreIpAddresses("25525511135"));
        System.out.println(lengthOfLongestSubstringTwoDistinct("eceba"));
    }
    public List<Integer> findSubstring(String s, String[] words) {
        int L = words.length;
        int k = words[0].length();
        HashMap<String, Integer> map = new HashMap<>();
        for(String w: words){
            if(map.containsKey(w)){
                map.put(w,map.get(w)+1);
            }
            else{
                map.put(w,1);
            }
        }
        int left=0;
        int count=0;
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<L;i++){
            HashMap<String, Integer> curMap = new HashMap<>();
            for(int j=i;j<s.length()-L;j+=k){
                String ss=s.substring(j,j+k);
                if(map.containsKey(ss)){
                    if(curMap.containsKey(ss)) curMap.put(ss, curMap.get(ss)+1);
                    else curMap.put(ss,1);
                    if(count == L){
                        res.add(left);
                    }
                    if(curMap.get(ss) <= map.get(ss)){
                        count++;
                    }
                    else{
                        String temp = s.substring(left,left+k);
                        if(curMap.containsKey(temp)){
                            curMap.put(ss, curMap.get(ss)-1);
                            count--;
                        }
                        left += k;
                    }
                }
            }

        }
        return new ArrayList<>();
    }
    /*
    S = "ADOBECODEBANC"
    T = "ABC"
    Minimum window is "BANC".
     */
    public String minWindow(String S, String T) {
        if (S == null || S.length() == 0)
            return "";
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < T.length(); i++) {
            if (map.containsKey(T.charAt(i))) {
                map.put(T.charAt(i), map.get(T.charAt(i)) + 1);
            } else {
                map.put(T.charAt(i), 1);
            }
        }
        int left = 0;
        int start = 0;
        int count =0 ;
        int minLen =0;
        int minIndex =0;
        char[] s = S.toCharArray();
        for(int r=0;r<s.length;r++){
            char c= s[r];
            if(map.containsKey(c)){
                map.put(c, map.get(c)-1); // need number -1,
                if(map.get(c) >= 0) count++;// still need this char

                while(count == T.length()){
                    if(r-start+1 > minLen) {
                        minLen = r-start+1;
                        minIndex = start;
                    }
                    //start shift to right
                    if(map.containsKey(s[start])){
                        if(map.get(s[start])==0) map.put(s[start], map.get(s[start])+1 ); //del one, need another one
                        count--;//need more char,shift r,go to next round
                    }
                    start++; // not in map, still shift right
                }
            }
        }
        if(minIndex>S.length()) return "";
        return S.substring(minIndex,minIndex+minLen);
    }

    // eceba
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.isEmpty()) return 0;
        int[] dict = new int[256];
        int count=0;
        int start=0;
        int maxLen=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            dict[c]++;
            if(dict[c]==1){
                count++;//find new char
                //3rd new char,update maxLen,move start,also dict[start]--;until count<=2
                while(count>2){
                    maxLen = Math.max(maxLen,i-start);
                    dict[start]--;
                    if(dict[start]==0) count--;
                    start++;
                }
            }
        }
        return maxLen;
    }
    // abcabcbb
    /*
len=1;
for i in 0-n:
    if in set://find repeated
        update len, i-start
        move left util no repeated

    else: set.add(s[i])
  */
}
