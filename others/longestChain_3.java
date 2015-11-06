package others;

import java.util.*;

/**
 * Created by lipingxiong on 10/30/15.
 */
public class longestChain_3 {

    public static void main(String[] args) {
        System.out.println( longestchain(new String[]{"a", "abcd", "bcd", "abd", "cd", "c",""}) );
//        System.out.println( longestchain(new String[]{"a", "abcd", "bcd", "abd", "cd", "d"}) );
//        System.out.println( longestchain(new String[]{"a", "abcd", "bcd", "abd", "cd", "ab",""}) );
//            System.out.println( longestchain(new String[]{"cd", "c",""}) );
    }

    public static int longestchain(String[] dict){
        TreeMap<Integer,HashSet<String>> map = new TreeMap<>(Collections.reverseOrder());
        int max=0;//
        for(String s : dict){
            int len = s.length();
            if(!map.containsKey(len)){
                map.put(len,new HashSet<String>());
            }
            map.get(len).add(s);
        }
        ptrMap(map);

        int path = 1;
        int maxPathSoFar = 0;

        for(Map.Entry<Integer,HashSet<String>> entry : map.entrySet()){
            int len = entry.getKey();
            if(len<maxPathSoFar) break;

            HashSet<String> set = entry.getValue();
            Iterator<String> iter = set.iterator();


            while(iter.hasNext()) {
                path = 1;
                String cur = iter.next();

                //delete one char,
                for(int i=0;i<cur.length();i++){
                    String substr = cur.substring(0, i) + cur.substring(i + 1);//remove charAt(i)

                    int k = len-1;
                    while(map.containsKey(k) && map.get(k).contains(substr)){

                        path++;
                        System.out.printf("substr=%s,  k=%d, path=%d\n",substr,k,path);
                        k--;
                    }
                    maxPathSoFar = Math.max(path,maxPathSoFar);
                    path = 1;
                }
            }
        }


        return maxPathSoFar;
    }


    public static void ptrMap(TreeMap<Integer,HashSet<String>> map){
        for(Map.Entry<Integer,HashSet<String>> entry : map.entrySet()){
            System.out.print(entry.getKey() + " : ");
            System.out.println(entry.getValue());
        }
    }
}
