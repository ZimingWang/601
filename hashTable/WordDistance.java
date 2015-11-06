package hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lipingxiong on 8/22/15.
 */
public class WordDistance {
    Map<String, ArrayList<Integer>> map = new HashMap<>();

    public WordDistance(String[] words) {
        for(int i=0;i<words.length;i++){
            if(!map.containsKey(words[i])){
                map.put(words[i],new ArrayList<Integer>());
                map.get(words[i]).add(i);
            }
            else{
                map.get(words[i]).add(i);
            }
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int min = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < l1.size() && j < l2.size(); ) {
            int index1 = l1.get(i);
            int index2 = l2.get(j);
            if (index1 < index2) {
                min = Math.min(min, index2 - index1);
                i++;
            } else {
                min = Math.min(min, index1 - index2);
                j++;
            }
        }
        return min;
    }


    public int shortestWordDistance(String[] words, String word1, String word2) {
        int p1 = -1;
        int p2= -1;
        int min = words.length;
        for(int i=0;i<words.length;i++){
            if(words[i].equals(word1)){
                if(word1.equals(word2)){
                    if(p1 != -1 && i-p1< min) {
                        min = i-p1;
                        p1=i;
                        break;
                    }
                }
                else{
                    p1=i;
                }
            }
            else if(words[i].equals(word2)){
                p2=i;
            }
            if(p1!=-1 && p2!=-1 && p2-p1 < min){
                min = p2-p1;
            }
        }
        return min;
    }

/*
For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.
*/
    public static void main(String[] args){
         String[] words = {"practice", "makes", "perfect", "coding", "makes"};
         WordDistance wordDistance = new WordDistance(words);
         System.out.println(wordDistance.map);
         System.out.println(wordDistance.shortest("coding", "makes") );
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");



