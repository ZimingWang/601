package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * Created by lipingxiong on 8/17/15.
 */
public class myGraph {

    public boolean search (ArrayList<ArrayList<Integer>> adjLists, int start , int end){
        boolean[] visited = new boolean[adjLists.size()];
        return dfs(adjLists,visited,start,end);
    }
    public boolean dfs(ArrayList<ArrayList<Integer>> adjLists, boolean[] visited, int start, int end){
        visited[start]=true;
        for(int w: adjLists.get(start) ){
            if(!visited[w]){
                if(w==end) return true;
                if (dfs(adjLists,visited,w,end)) return true;
            }
        }
        return false;
    }
    HashSet<Integer> visited = new HashSet<>();
    HashSet<Integer> stack = new HashSet<>();
    Stack<Integer> reversePost = new Stack<>();

    boolean hasCycle = false;

    public int[] findOrder(int numCourses){
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();

        for(int i=0;i<numCourses;i++){
            if(hasCycle)return new int[]{};
            dfs(map, i);
        }
        int[] res = new int[numCourses];
        int i = 0;
        while(!reversePost.isEmpty()){
            res[i++] = reversePost.pop();
        }
        return res;
    }
    void dfs(HashMap<Integer,ArrayList<Integer>> map, int v){
        visited.add(v);
        stack.add(v);
        for(int neigh : map.get(v)){
            if( !visited.contains(neigh)){
                dfs(map,neigh);
            }
            else if(stack.contains(v)){
                hasCycle = true;
                return;
            }
        }
        stack.remove(v);
        reversePost.add(v);
    }


}
