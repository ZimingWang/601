package graph;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by lipingxiong on 9/12/15.
 */
public class courseSchedule2 {
    //accepted my solution
    Stack<Integer> reversePost = new Stack<>();
    boolean hasCycle=false;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            graph[i]= new ArrayList<Integer>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]); //pre->take
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] onStack=new boolean[numCourses];//for cycle detection

        for(int i=0;i<numCourses;i++) {// dfs each vertex
            if(hasCycle) return new int[]{};
            if(!visited[i]) dfs(graph, visited, onStack, i);
        }
        int i = 0;
        int[] res = new int[numCourses];
//        System.out.println(hasCycle);

        // convert stack to list
        while(!reversePost.isEmpty()){
            res[i++]=reversePost.pop();
        }

        return res;
    }

    public void dfs(ArrayList<Integer>[] graph, boolean[] visited,boolean[] onStack,int v){
        if(hasCycle) return;
        visited[v] = true;
        onStack[v] = true; //for cycle detection
        
        for(int i=0;i<graph[v].size();i++){
            int w = graph[v].get(i);
            if(!visited[w]){
                dfs(graph, visited,onStack,w);
            }
            else if(onStack[w]) { //for cycle detection
                hasCycle=true;
                return;
            }
        }
        onStack[v]=false; //for cycle detection
        reversePost.push(v);
    }

    public static void prtArr(int[] arr){
        for(int i:arr){
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        courseSchedule2 ins = new courseSchedule2();
        //4, [[1,0],[2,0],[3,1],[3,2]] ;  [0,1,2,3]. Another correct ordering is[0,2,1,3].
//        ins.findOrder(3, new int[][]{{0, 1}, {1, 2}});
        int[] res=ins.findOrder(4,new int[][] {{1,0},{2,0},{3,1},{3,2}}); //  [0,1,2,3]
//        int[] res=ins.findOrder(2,new int[][]{{0, 1}, {1, 0}});
//        int[] res=ins.findOrder(3,new int[][]{{1, 0}, {2, 1},{0,2}});
        prtArr(res);
    }
}
