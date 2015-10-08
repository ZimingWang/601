package graph;

import java.util.LinkedList;

/**
 * Created by lipingxiong on 9/12/15.
 */
public class UndirectedGraph {
    private final int V;
    private int E;
    private LinkedList<Integer>[]  adj;
    public UndirectedGraph(int V){
        this.V = V;
        this.E = 0;
        adj = new LinkedList[V];
        for(int v=0;v<this.V;v++){
            adj[v] = new LinkedList<Integer>();
        }
    }
    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }
    public Iterable<Integer> adj(int v){
        return adj[v];
    }

}
