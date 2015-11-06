package hashTable;

import java.util.HashMap;

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
}
