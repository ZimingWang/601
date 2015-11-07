package hashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by lipingxiong on 11/6/15.
 */
public class bullsCows {
    public static void main(String[] args){
        System.out.println(getHint("1807", "7810"));
        System.out.println(getHint("1123", "0111"));
        System.out.println(getHint("11", "11"));
    }
    public static String getHint(String secret, String guess) {
//        HashMap<Character,Boolean> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        HashMap<Character,Integer> bullmap = new HashMap<>();
        HashMap<Character,Integer> cowmap = new HashMap<>();

        int n = secret.length();
//        if(n<4) return "0A0B";
        for(int i=0;i<n;i++){
            set.add(secret.charAt(i));
        }
        for(int i=0;i<n;i++){

            char ch1 = secret.charAt(i);
            char ch2= guess.charAt(i);
            if(!set.contains(ch2)) continue;
            if(ch1!=ch2 && !bullmap.containsKey(ch2) ){
                cowmap.put(ch2, 1);
            }
            else {
                if(!bullmap.containsKey(ch2)){
                    bullmap.put(ch2,1);
                }
                else bullmap.put(ch2,bullmap.get(ch2)+1);

                cowmap.remove(ch2);
            }
        }
//        StringBuilder sb = new StringBuilder();
//        sb.append(bullmap.size());
//        sb.append("A");
        int bulls = 0;
        for(Map.Entry<Character,Integer> entry : bullmap.entrySet()){
            bulls +=  entry.getValue();
        }
        return bulls + "A" + cowmap.size() + "B";

    }

}
