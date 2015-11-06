package graph;

import java.util.*;

/**
 * Created by lipingxiong on 10/31/15.
 *
 */
public class cloneGraph {
//    * Definition for undirected graph.
    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    };

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.offer(node);
        UndirectedGraphNode copyNode = new UndirectedGraphNode(node.label);
        map.put(node, copyNode);

        while(!q.isEmpty()){
            UndirectedGraphNode cur = q.poll();
            for(UndirectedGraphNode neigh : cur.neighbors){
                if(!map.containsKey(neigh)){
                    map.put(neigh, new UndirectedGraphNode(neigh.label));
                    q.offer(neigh);
                }
                map.get(cur).neighbors.add(neigh);
            }
        }
        return map.get(node);
    }
//    public void dfs(UndirectedGraphNode node, Queue<UndirectedGraphNode> q){
//        while
//    }

}
