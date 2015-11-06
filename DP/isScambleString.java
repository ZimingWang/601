package DP;

import java.util.HashMap;
import java.util.Map;

/**
 */
public class isScambleString {
    public static void main(String[] args){
//        System.out.println(isScramble("gr","rg") );
//        System.out.println(isScramble("great", "rgeat"));
//        System.out.println(isScramble("great", "rgea"));
        String s1="ackbdflwqhqarscoepmmxyymcarbjn";
        String s2="mphoebfamrmcscdblwryqykaaqjcnx";
        System.out.println(isScramble(s1,s2) );
    }
    public static boolean isScramble(String s1, String s2) {
        HashMap<String,Boolean> map = new HashMap<>();
        boolean res = isScramble(s1,s2,map);
        System.out.println("-----end-----");
        ptrMap(map);
        return res;
    }
    public static boolean isScramble(String s1, String s2, HashMap<String,Boolean> map) {
        String key = s1 + s2;
        System.out.println("key="+key);
        if(map.containsKey(key)) return map.get(key);
//        ptrMap(map);
        int len = s1.length();
        if(len == 0) return  true;
        if(len ==1 && s1.equals(s2)) {
            map.put(key,true);
            return true;
        }

        for(int i=1;i<len;i++){
            if (isScramble(s1.substring(0,i),s2.substring(0,i),map)
                    && isScramble(s1.substring(i),s2.substring(i),map)
            ){
                map.put(key,true);
                return true;
            }
            if( isScramble(s1.substring(0,i),s2.substring(len-i),map)
                    && isScramble( s1.substring(len-i),s2.substring(0,i),map)
                    ){
                map.put(key,true);
                return true;
            }
        }
        map.put(key,false);
//        ptrMap(map);
        return false;
    }
    public static void ptrMap(HashMap<String,Boolean> map){
        for(Map.Entry<String,Boolean> entry:map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
