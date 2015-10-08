package hashTable;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by lipingxiong on 8/14/15.
 */
public class validAnagram {
    public static void main(String[] args){
        System.out.println(isAnagram("ant", "tna"));
        System.out.println(isAnagram("act", "tna"));
    }
    public static boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }
        System.out.println(map);
        for(int i=0; i<t.length(); i++){
            if(! map.containsKey(t.charAt(i))) return false;

            map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
            if(map.get(t.charAt(i)) < 0) return false; // Already has too many character
            System.out.println(map);
        }
        for(Integer value:map.values()){
            if(value !=0) return false;
        }
        return true;
    }



}
