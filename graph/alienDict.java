package graph;

import java.util.*;

/**
 * Created by lipingxiong on 9/15/15.
 */
public class alienDict {

    Stack<Character> stack = new Stack<>();
    HashMap<Character,HashSet<Character>> graph = new HashMap<>(); //use set to store neighbors, because may appear repreated neighbors
    HashSet<Character> visited = new HashSet<>();
    boolean hasCycle = false; //when has cycle, return ""
    HashSet<Character> onStack = new HashSet<>();
    //use charSet to store all characters in words,but not in the graph.insert those to the head the res.
    Set<Character> charSet = new HashSet<Character>() ;

    private Set<Character> getCharSet(String[] words) {
        for (String word : words) {
            for (char c : word.toCharArray()) {
                charSet.add(c);
            }
        }
        return charSet;
    }

    public String alienOrder(String[] words) {
        getCharSet(words);//get all characters
        //create graph
        for(int i=0;i<words.length-1;i++){
            String w1 = words[i];
            String w2 = words[i+1];
            int m = w1.length();
            int n = w2.length();
            int minLen = Math.min(m,n);
//            System.out.println(w1+" "+w2 + " "+minLen);
            //search for the first mismatch character,
            for(int k=0;k<minLen;k++){
                while(k<minLen &&(w1.charAt(k) == w2.charAt(k))) k++;
//                System.out.println("k="+k);
                if(k<minLen){
                    //mismatch and not the end,find one edge,add to graph
                    addEdge(w1.charAt(k), w2.charAt(k) );
                    break;//NOTE:After find the fist mismatch, should break
                }
            }
        }
        // reverse postorder search of graph
//        System.out.println("keySet"+graph.keySet());

        for(char v : graph.keySet()){
//            System.out.println(v + ":" + graph.get(v));
            if(hasCycle) return "";
            if(!visited.contains(v))dfs(v);
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        for (Character c : charSet) { //insert orphan chars.
            sb.insert(0, c);
        }
        return sb.toString();
    }
    private void addEdge(char v1, char v2){
//        System.out.println(v1+" "+v2);
        charSet.remove(v1);
        charSet.remove(v2);
        //add edge v1->v2
        if(!graph.containsKey(v1) ){
            graph.put(v1,new HashSet<Character>());
        }
        graph.get(v1).add(v2);
        // add edge v2->[], otherwise v2 will not in the graph,will cause null exceptation when dfs v1's neigh v2,
        // because v2 not in graph, cause null exception
        if(!graph.containsKey(v2) ){
            graph.put(v2,new HashSet<Character>());
        }
    }
    private void dfs( char v){
        onStack.add(v);
        visited.add(v);
        //neighbors
//        System.out.println("visited " + v);
        if(!graph.containsKey(v)) return ;
            for (char neigh : graph.get(v)) {
//                System.out.println("neigh:" + neigh);
                if (hasCycle) return;
                if (!visited.contains(neigh)) {
                    visited.add(neigh);
                    dfs(neigh);
                } else if (onStack.contains(neigh)) {
                    hasCycle = true;
                }
            }

//        System.out.println("push " + v);
        stack.push(v);
        onStack.remove(v);
    }

    public static void main(String[] args){
        alienDict ad = new alienDict();

        /*String[] dict = new String[]{        "wrt",
                "wrf",
                "er",
                "ett",
                "rftt"};*/
//        String[] dict = new String[]{"wrt","tr"};
        String[] dict = new String[]{"baa", "abcd", "abca", "cab", "cad"};
//        String[] dict = new String[]{"z","z"};
        System.out.println("res:" + ad.alienOrder(dict));
    }

}
