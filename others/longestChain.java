package others;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by lipingxiong on 10/30/15.
 */
public class longestChain {
    public static void main(String[] args) {
        System.out.println( longest_chain(new String[]{"a", "abcd", "bcd", "abd", "cd", "c"}) );
//        System.out.println( longestchain(new String[]{"a", "abcd", "bcd", "abd", "cd", "d"}) );
//        System.out.println( longestchain(new String[]{"a", "abcd", "bcd", "abd", "cd", "ab",""}) );
            System.out.println( longest_chain(new String[]{"cd", "c", ""}) );
    }

//    public static int longestchain(String[] dict){
//        HashSet<String> set = new HashSet<>();
//        int max = 0;
//        //put elements to a set
//        for(String s:dict){
//            set.add(s);
//        }
//        //map value:  the longest chain starting from this word
//        HashMap<String,Integer> map = new HashMap<>();
//
//        for(String s:dict) {
//            if(map.containsKey(s)) max=Math.max(max, map.get(s));
//            else max = Math.max(max, longestchain(set, s, map));
//        }
////        max = longestchain(set,"cd",map);
//        return max;
//    }
//    public static int longestchain(HashSet<String> set,String str,HashMap<String,Integer>map){
//        System.out.println("str="+str);
//        ptrSet(set);
//        if(map.containsKey(str)) return map.get(str);
//
//        int max=1;
//
//        set.remove(str);
//        for(int i=0;i<str.length();i++){
//            String substr = str.substring(0,i)+str.substring(i+1);//remove charAt(i)
//            System.out.println(substr);
//
//            if(set.contains(substr)){
//                int res = longestchain(set,substr,map);
//                max = Math.max(max,res + 1);
//            }
//        }
//
//        set.add(str);//recover
//
//        map.put(str,max);
//        return max;
//    }

    static int longest_chain(String[] w) {
        HashSet<String> set = new HashSet<>();//Use set to help identify whether the word exists
        for(String s:w){
            set.add(s);
        }
        int maxLen=0;//Length of the longest chain
        HashMap<String,Integer> map = new HashMap<>(); //Use map to save the previous results to avoid repeated calculation

        for(String s:w){
            if (s.length() <= maxLen) {continue;}
            maxLen = Math.max(maxLen, longestchain(set,s,map));
        }
        return maxLen;
    }
    public static int longestchain(HashSet<String> set,String str,HashMap<String,Integer>map){
        if(map.containsKey(str)) return map.get(str);
        int max = 1;
//        set.remove(str);

        for(int i=0;i<str.length();i++){
            String substr = str.substring(0,i)+str.substring(i+1);
            if(set.contains(substr)){
                int res = longestchain(set,substr,map);
                max = Math.max(max,res+1);
            }
        }


//        set.add(str);
        map.put(str,max);
        return max;
    }



    public static void ptrSet(HashSet<String> set){
        System.out.print("set=");
        if(set.isEmpty()) {
            System.out.println("Empty");
            return;
        }
        Iterator<String> iter = set.iterator();
        while(iter.hasNext()){
            System.out.print(iter.next() +",");
        }
        System.out.println();
    }


}
