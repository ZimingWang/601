package graph;

import java.util.Arrays;

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
    private int[] id;
    public boolean validTree(int n, int[][] edges) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        for (int i = 0; i < edges.length; i++) {
            int p = edges[i][0];
            int q = edges[i][1];
            union(p, q);
        }
        return true;
    }
    public int root(int p) {
        int i = p;
        while (id[i] != i) {
            i = id[i];
        }
        return i;
    }

    public void union(int p,int q){
        int i=root(p);
        int j=root(q);

    }


    public static void main(String[] args){
        graphValidTree gv = new graphValidTree();
        System.out.println(gv.validTree(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}}));
//        [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]]/
        System.out.println(gv.validTree(5, new int[][]{{0, 1}, {1, 2}, {2, 3},{1,3}, {1, 4}}));
        System.out.println(gv.validTree(5, new int[][]{{0, 1}, {2, 3}}));

    }

}
