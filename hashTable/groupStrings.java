package hashTable;

import java.util.*;

/**
 * Created by lipingxiong on 8/22/15.
 */
/*
For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
Return:

[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
 */
public class groupStrings {
    public static List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strings) {
            int offset = str.charAt(0) - 'a';
            String key = "";
            for (int i = 0; i < str.length(); i++) {
                char c = (char) (str.charAt(i) - offset);
                if (c < 'a') {
                    c += 26;
                }
                key += c;
            }
            System.out.println("key="+key);
            if (!map.containsKey(key)) {
                List<String> list = new ArrayList<String>();
                map.put(key, list);
            }
            map.get(key).add(str);
        }
        for (String key : map.keySet()) {
            List<String> list = map.get(key);
            Collections.sort(list);
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args){
        String[] str_list = new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        int offset = 1;
        char c = (char) ('a' - offset);
        c+=26;
        System.out.println("c="+c);
        groupStrings(str_list);
    }
}
