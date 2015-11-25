package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lipingxiong on 11/17/15.
 */
public class groupShift {

    public static void main(String[] args){
//        ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"]
        String[] strings = new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        System.out.println(groupString(strings));
    }

    public static List<List<String>> groupString(String[] strings){
        HashMap<String, List<String> > map = new HashMap<>();


        for(int i=0; i<strings.length;i++){
            String s = strings[i];
            int offset = s.charAt(0) - 'a';
            String key = "";
            for(int j = 0;j < s.length();j++){
                char ch = s.charAt(j);
                char tmp = (char)(ch - offset);
                if(tmp < 'a'){
                    tmp += 26;
                }
                key += tmp;
            }
            if(!map.containsKey(key) ){
                map.put(key,new ArrayList<String>());
            }
            map.get(key).add(s);
        }
        List< List<String>> res = new ArrayList<>();
        for(List<String> list : map.values()){
            Collections.sort(list);
            System.out.println(list);
            res.add(list);
        }
        return res;
    }
}
