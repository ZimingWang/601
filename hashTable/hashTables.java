package hashTable;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by lipingxiong on 10/29/15.
 */
public class hashTables {

    public static void main(String[] args){
        HashMap<Integer,Integer> map =new HashMap<>();
        System.out.println(map.put(0, 0));
        System.out.println(map.put(0, 1));
        System.out.println( map.get(0) );
    }

    public boolean canPermutePalindrome(String s) {
        HashSet<Character> set = new HashSet<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(set.contains(ch)) set.remove(ch);
            else set.add(ch);
        }
        return set.size()==0 || set.size()==1;
    }
    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }



    }
