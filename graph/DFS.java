package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

/**
 * Created by lipingxiong on 8/21/15.
 */
public class DFS {



    public class Graph {
        int V; //number of vertex
        int E;// number of edges
        HashMap<Integer, ArrayList<Integer>> adj;

        public Graph(int V) {
            this.V = V;
            adj = new HashMap<>();
            for (int v = 0; v < V; v++) {
                adj.put(v, new ArrayList<Integer>());
            }
        }

        public void addEdge(int v, int w) {
            adj.get(v).add(w);
            adj.get(w).add(v);
        }

        public Iterable<Integer> adj(int v) {
            return adj.get(v);
        }
    }

    private boolean[] visited;

    public void dfs(Graph G, int v) {
        visited[v] = true;
        for (int w : G.adj(v)) {
            if (!visited[w]) {
//                visited[w]=true;
                dfs(G, w);
            }

        }
    }

}
/*
public class DepthFirstOrder{
    private boolean[] marked;
    private Stack<Integer> reversePost;
    public DepthFirstOrder(Digraph G){
        reversePost = new Stack<Integer>();
        marked = new boolean[G.V()];
        for(int v=0;v<G.V();v++){
            if(!marked[v]) dfs(G,v);
        }
    }
    private void dfs(){
        marked[v]=true;
        for(int w: G.adj(v)){
            if(!marked[w]) dfs(G,w);
        }
        reversePost.push(v);
    }
    public Iterable<Integer> reversePost(){
        return reversePost;
    }

}
*/
