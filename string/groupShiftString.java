package string;

import java.util.*;

/**
 */
public class groupShiftString {
    public static void main(String[] args){
        String[] strs = new String[]{"abc","xyz"};
        System.out.println(groupStrings(strs));
    }
    public static List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strings) {
            int offset = str.charAt(0) - 'a';
            String key = "";
            for(int i=0;i<str.length();i++){
                char ch = (char)(str.charAt(i) - offset);
                if(ch < 'a') ch += 26;
                key += ch;
            }
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(str);
        }
        for(String  key:map.keySet()){
            List<String> list = map.get(key);
            Collections.sort(list);
            result.add(list);
        }
        return result;
    }
}
