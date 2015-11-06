package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by lipingxiong on 9/11/15.
 */
public class graphValidTree {
    /*
    public boolean validTree(int n, int[][] edges) {
        // initialize n isolated islands
        int[] nums = new int[n];
        Arrays.fill(nums, -1);

        // perform union find
        for (int i = 0; i < edges.length; i++) {
            int x = find(nums, edges[i][0]);
            int y = find(nums, edges[i][1]);

            // if two vertices happen to be in the same set
            // then there's a cycle
            if (x == y) return false;

            // union
            nums[x] = y;
        }

        return edges.length == n - 1;
    }

    int find(int nums[], int i) {
        if (nums[i] == -1) return i;
        return find(nums, nums[i]);
    }
    */
/*
    private int[] id;
    public boolean validTree(int n, int[][] edges) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        for(int i=0;i<edges.length;i++){
            int p = edges[i][0];
            int q = edges[i][1];
            if(root(p) == root(q)) return false;
            union(p,q);
        }
        return true;
    }
    public int root(int p){
        int i=p;
        while(id[i]!=i){i=id[i];}
        return i;
    }
    public void union(int p,int q){
        int i=root(p);
        int j=root(q);
        id[i] = j; // set p'root to q's root
    }
    */

//    private int[] id;
//    public boolean validTree(int n, int[][] edges) {
//        id = new int[n];
//        for (int i = 0; i < n; i++) {
//            id[i] = i;
//        }
//        for (int i = 0; i < edges.length; i++) {
//            int p = edges[i][0];
//            int q = edges[i][1];
//            union(p, q);
//        }
//        return true;
//    }
//    public int root(int p) {
//        int i = p;
//        while (id[i] != i) {
//            i = id[i];
//        }
//        return i;
//    }
//
//    public void union(int p,int q){
//        int i=root(p);
//        int j=root(q);
//
//    }
//

    public static void main(String[] args){
        graphValidTree gv = new graphValidTree();
        System.out.println(gv.validTree(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}}));
//        [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]]/
        System.out.println(gv.validTree(5, new int[][]{{0, 1}, {1, 2}, {2, 3},{1,3}, {1, 4}}));
        System.out.println(gv.validTree(5, new int[][]{{0, 1}, {2, 3}}));

    }

    public boolean validTree(int n, int[][] edges) {
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<edges.length;i++){
            int v = edges[i][0];
            int w = edges[i][1];
            if(!map.containsKey(v)){
                map.put(v,new ArrayList<Integer>());
            }
            map.get(v).add(w);
            if(!map.containsKey(w)) map.put(w,new ArrayList<Integer>());
            map.get(w).add(v);
        }
        HashSet<Integer> visited= new HashSet<>();
        if(!dfs(map,0,-1,visited)) return false;

        for(int i=0;i<n;i++){
           if(!visited.contains(i)) return  false;
        }
        return true;

    }
    public boolean dfs(HashMap<Integer,ArrayList<Integer>>map, int v,int p
            ,HashSet<Integer> visited){
        visited.add(v);
        if(map.containsKey(v)) {
            for (int neigh : map.get(v)) {
                if (!visited.contains(neigh)) {
                    if (!dfs(map, neigh, v, visited)) return false;
                } else if (p != neigh) return false;
            }
        }
        return true;
    }


}
