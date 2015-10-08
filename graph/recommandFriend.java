package graph;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by lipingxiong on 10/7/15.
 *
 * pattern = "abba", str = "dog cat cat dog" should return true.
 pattern = "abba", str = "dog cat cat fish" should return false.
 pattern = "aaaa", str = "dog cat cat dog" should return false.
 pattern = "abba", str = "dog dog dog dog" should return false.
 */

public class recommandFriend {
    int recommandFriend(HashMap<Integer,ArrayList<Integer>> map,int key){
        HashMap<Integer,Integer> cmap = new HashMap<>();
        for(int i:map.get(key)){
            for(int j:map.get(i)){
                int count = (cmap.containsKey(j))? cmap.get(j) :1;
                cmap.put(j,count);
            }
        }
        //get largest from cmap
        return 0;
    }
    public static void main(String[] args){
//        System.out.println(wordPattern("abba", "dog dog dog dog"));
//        System.out.println(wordPattern("", "dog cat cat fish"));
//        System.out.println(wordPattern("abba", ""));
//        System.out.println(wordPattern("", ""));

        System.out.println(isIsomorphic("eggc", "addd"));
        System.out.println(isIsomorphic("", ""));
        System.out.println(isIsomorphic("foo", "bar"));
    }
    public static boolean wordPattern(String pattern, String str) {
        if(pattern=="" && str=="") return true;
        char[] arr1=pattern.toCharArray();
        String[] arr2=str.split(" ");
//        System.out.println(arr1.length);
//        System.out.println(arr2.length);

        if(arr1.length!=arr2.length) return false;
        HashMap<Character,String> map = new HashMap<>();
        HashSet<String> set=new HashSet<>();

        for(int i=0;i<arr1.length;i++){
            if(map.containsKey(arr1[i])){
                if(!arr2[i].equals( map.get(arr1[i])) ) return false;
            }
            else {
                if(set.contains(arr2[i]) ) return false;
                map.put(arr1[i],arr2[i]);
                set.add(arr2[i]);
            }
        }
        return true;
    }

    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        char[] arr1= s.toCharArray();
        char[] arr2=t.toCharArray();
        if(arr1.length != arr2.length) return  false;

        for(int i=0;i<arr1.length;i++){
            if(map.containsKey(arr1[i]) ){
                if(arr2[i]!=map.get(arr1[i])) return false;
            }
            else{
                if(set.contains(arr2[i])) return false;
                map.put(arr1[i],arr2[i]);
                set.add(arr2[i]);
            }
        }
        return true;
    }
}
