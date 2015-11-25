package hashTable;

import java.util.HashMap;
import java.util.HashSet;

/**
 */
public class wordPattern {
    public static boolean wordPattern(String pattern, String str) {
        if (pattern == "" && str == "") return true;
        char[] arr1 = pattern.toCharArray();
        String[] arr2 = str.split(" ");
        int m = arr1.length;
        int n = arr2.length;
        if(m!=n)return  false;

        HashMap<Character,String> map = new HashMap<>();
        for(int i=0;i<m;i++){
            if(!map.containsKey(arr1[i])){
                map.put(arr1[i],arr2[i]);
            }
            else {
                if(arr2[i] != map.get(arr1[i])) return false;
            }
        }
        return true;
    }

    final static boolean debug = true;

    HashMap<Character, String> map = new HashMap<>();
    HashSet<String> set=new HashSet<>();

    public boolean wordPatternMatch(String pattern, String str) {
        return h(0, pattern,str,0);
    }
//accepted
    public  boolean h(int start,String pattern, String str, int i){
        if(debug)  System.out.println("start= "+start+" i=" + i);

        if(start >= pattern.length()) {
            return i == str.length();
        }

        char c = pattern.charAt(start);

        if(map.containsKey(c)) {
            String word = map.get(c);
            //从i开始的word是否是预期的
            if( !str.startsWith(word,i)) return false;
//            如果是预期的，继续判断后面的
            return h(start+1,pattern,str,i+word.length());
        }
//        map中没有c，要一个一个试这个c对应的word，一旦发现一种能使得后面的也成立，
//        说明找到了，可以直接返回，但要是这次的不行，要清理环境然后继续尝试，直到k到str的end为止。
        for(int k=i;k<str.length();k++){
            String word = str.substring(i,k+1);
            if(set.contains(word)) continue;

            map.put(c,word);
            set.add(word);
            if(h(start+1,pattern,str,k+1)) return true;

            map.remove(c);
            set.remove(word);
        }
        return false;
    }


    public static void main(String[] args){
        wordPattern w = new wordPattern();
//        System.out.println(w.wordPatternMatch("ab", "red"));
//        System.out.println(w.wordPatternMatch("aa", "reblue"));
//        System.out.println(w.wordPatternMatch("abab", "redblueredblue"));
//        System.out.println(w.wordPatternMatch("aaaa", "asdasdasdasd"));
//        System.out.println(w.wordPatternMatch("aabb", "xyzabcxzyabc"));
//        System.out.println(w.wordPatternMatch("ab", "aa"));
//        System.out.println(w.wordPatternMatch("itwasthebestoftimes",
//                        "ittwaastthhebesttoofttimes"));

        System.out.println(w.wordPatternMatch("stimes", "stimes"));
    }


//    public  boolean h(int start,String pattern, String str, int i){
//        if(debug)  System.out.println("start= "+start+" i=" + i);
//
//        if(start >= pattern.length()) {
//            return i == str.length();
//        }
//        char ch = pattern.charAt(start);
//
//        for(int k=i;k<str.length();k++) {
//            if(debug)  System.out.println("start= "+start+" k=" + k+"******");
//            String word = str.substring(i, k + 1);
//            if(debug) System.out.println(ch + " " + word +  " " + i + " " + k);
//
//            if(!map.containsKey(ch)) {
//                if(set.contains(word)) continue; // diff pattern, same word
//                map.put(ch, word);
//                set.add(word);
//            }
//            else{
//                if(!map.get(ch).equals(word)) {
//                    if(debug) System.out.println("not equal to previous pat");
//                    continue;
//                }
//            }
//            if(debug)  System.out.println(map);
//
//            boolean res = h(start+1,pattern,str,k+1);
//
//            map.remove(ch); // recover
//            set.remove(word);
//
//            if(res) return true;
//
//            if(debug) System.out.println(map);
//
//            if(debug) System.out.println();
//
//        }
//        if(debug)System.out.println("------");
//        if(debug)System.out.println("------");
//
//        return false;
//    }


}
