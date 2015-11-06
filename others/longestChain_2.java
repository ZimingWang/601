package others;

import java.util.*;

/**
 * Created by lipingxiong on 10/30/15.
 */
public class longestChain_2 {
    HashMap<String, ArrayList<String>> graph ;
    HashSet<String> visited ;
    Stack<String> stack ;

    public longestChain_2() {
        graph = new HashMap<>();
        visited = new HashSet<>();
        stack = new Stack<>();
    }

    public static void main(String[] args){
        longestChain_2 lc = new longestChain_2();
        int res =0;
        res=lc.longestchain2(new String[]{"a", "abcd", "bcd", "abd", "cd", "c"});
        System.out.println(res);
    }

    public int longestchain2(String[] dict){

        HashSet<String> set = new HashSet<>();

        for(String s:dict){
            set.add(s);
        }
        for(String cur:dict){
            for(int i=0;i<cur.length();i++) {
                String substr = cur.substring(0, i) + cur.substring(i + 1);//remove charAt(i)
//            System.out.println(substr);

                if (set.contains(substr)) {
                    if(!graph.containsKey(cur)) graph.put(cur,new ArrayList<String>());
                    graph.get(cur).add(substr);
                }
            }
            if(!graph.containsKey(cur)) graph.put(cur,new ArrayList<String>());
        }
        ptrMap(graph);
        int max=0;

        for(String s:dict){
            if(!visited.contains(s)) dfs(s);
            max=Math.max(max,stack.size());
            ptrStack(stack);
            stack.clear();
        }
        return max;
    }

    public void dfs(String s ){
        visited.add(s);
        for(String neigh : graph.get(s)){
            if(!visited.contains(neigh)){
                dfs(neigh);
            }
        }
        stack.push(s);
    }
    public void ptrStack(Stack<String> stack){
        System.out.println("stack=");
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + ",");
        }
        System.out.println();
    }
    public void ptrMap(HashMap<String,ArrayList<String>>map){
        for(Map.Entry<String,ArrayList<String>> entry : map.entrySet()){
            System.out.print(entry.getKey() + " : ");
            System.out.println(entry.getValue());
        }
    }

}
