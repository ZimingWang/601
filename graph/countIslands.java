package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by lipingxiong on 11/25/15.
 */
public class countIslands {
    public static void main(String[] args){
//        int[][] edges= new int[][]{{0,1},{1,2},{2,3}};
        int[][] edges= new int[][]{{0,1},{2,3}};
        countIslands ci = new countIslands();
        ci.countIslands(edges);
    }
    int max = 1;
    int min = 1;
    int count;
    HashMap<Integer, ArrayList<Integer>> map;
    HashSet<Integer> visited = new HashSet<>();

    public int[] countIslands(int[][] edges){
        map = new HashMap<>();
        int n = 7;
        for(int i=0;i<7;i++){
            map.put(i,new ArrayList<Integer>());
        }
        for(int[] edge:edges){
            int w = edge[0];
            int v = edge[1];
            map.get(w).add(v);
            map.get(v).add(w);
        }
        System.out.println(map);
        for(int v : map.keySet()){
            if(!visited.contains(v)){
                count = 0;
                dfs(v);
                if(count > max) max = count;
                else if(count < min) min = count;
            }
        }
        System.out.println(max+" "+ min);
        return new int[]{max,min};
    }
    private void dfs(int v){
        count++;
        visited.add(v);
        for(int w : map.get(v) ){
            if(!visited.contains(w)) {
                dfs(w);
            }
        }
    }


}
