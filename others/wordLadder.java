package others;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by lipingxiong on 8/21/15.
 */
/*
Given two words (beginWord and endWord), and a dictionary, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]

As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
hit->ait->bit->
neighbors: only one letter is diff
queue: hit->neighbors of hit ->
neighbor1->.... ->  neighbors of neighbor1 ->
during visiting, if ==endWord, then we find it. record the length

while queue:
    cur = q.poll
    while neigh in cur.neighbors:
        if dict.contains(neigh):
            level++;
        if neigh == endWord:
            return level;

 */
/*
Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]

As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
*/
public class wordLadder {
    public static void main(String[] args){
        ArrayList<String> dict = new ArrayList<>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        System.out.println(wordLadder("hit", "cog", dict));
    }

    public static int wordLadder(String beginWord, String endWord, ArrayList<String> dict) {
        LinkedList<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        int L = beginWord.length();
        queue.offer(beginWord);
        visited.add(beginWord);
        int lastNum = 1;
        int curNum = 0;
        int level = 1;
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            lastNum--;
            // visit its neighbors

            for (int i = 0; i < L; i++) {
                char[] curArr = cur.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    curArr[i] = c;
                    String neigh = new String(curArr);
//                    System.out.println(neigh);
                    if (neigh.equals(endWord)) {
                        return level + 1;
                    }
                    if(!visited.contains(neigh) && dict.contains((neigh))) {
                        curNum++;
                        visited.add(neigh);
                        queue.offer(neigh);

                        System.out.println("In dict:" + neigh);
                    }
                }
            }
            if(lastNum==0){
                lastNum = curNum;
                curNum=0;
                level++;
            }

        }
        return 0;
    }
}
