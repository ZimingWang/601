package ArraysStrings.string;

import java.util.HashMap;

/**
 * Created by lipingxiong on 10/13/15.
 */
public class minWindow {
    public static void main(String[] args){
        String S = "AAOBECO";
//        String S = "ADOBECODEBANC";
        String T = "ABC";
        String res = minWindow(S,T) ;
        System.out.println(res);
    }
    /*
    S = "ADOBECODEBANC"
    T = "ABC"
    Minimum window is "BANC".
    */
    public static String minWindow(String S, String T) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<T.length();i++){
            char ch = T.charAt(i);
            if(map.containsKey(T.charAt(i)))
            {
                map.put(T.charAt(i),map.get(T.charAt(i))+1);
            }
            else
            {
                map.put(T.charAt(i),1);
            }
        }
        int min=S.length(),beg=0,end=0;
        int m = S.length();
        int n = T.length();
        int start=0;
        HashMap<Character,Integer> curmap = new HashMap<>();
        int count=0;
//        while(start<m && !map.containsKey(ch)) start++;
        for(int i=0;i<S.length();i++) {
            char ch = S.charAt(i);
//            start = i;

            //in T,and still need, count++
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch)-1);
                if(map.get(ch)==0){
                    count++;
                }
            }
            while(count==T.length()){//find a window
                min = Math.min(min, i-start + 1 );
                beg=start; end=i;

                ch = S.charAt(start);
                if( map.containsKey(ch) ) {
                    map.put( ch,map.get(ch)+1 );
                    if(map.get(ch)>0) count--;
                }
                start++;
            }
        }
        return S.substring(beg,end+1);

    }

}
