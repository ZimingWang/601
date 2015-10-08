package tree;

import java.util.ArrayList;

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
}
