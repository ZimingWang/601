package graph;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lipingxiong on 8/21/15.
 */
public class courseSchedule {

    public boolean canFinishBFS(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses]; // i -> j
        int[] indegree = new int[numCourses];

        for (int i=0; i<prerequisites.length; i++) {
            int ready = prerequisites[i][0];
            int pre = prerequisites[i][1];
            if (matrix[pre][ready] == 0)
                indegree[ready]++; //duplicate case
            matrix[pre][ready] = 1;
        }

        int count = 0;
        Queue<Integer> queue;
        queue = new LinkedList<>();
        for (int i=0; i<indegree.length; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int i=0; i<numCourses; i++) {
                if (matrix[course][i] != 0) {
                    if (--indegree[i] == 0)
                        queue.offer(i);
                }
            }
        }
        return count == numCourses;
    }

    // 0 take  1 pre
    public boolean canFinishDFS(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        boolean[] visited = new boolean[numCourses];
        boolean[] onStack = new boolean[numCourses];
        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList();
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        //check each course
        for (int i = 0; i < numCourses; i++) {
            if(!dfs(graph,i,visited,onStack)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(ArrayList[] graph,int v, boolean[] visited, boolean[] onStack){
        onStack[v] = true;
        visited[v] = true;
        for(int i=0 ; i<graph[v].size();i++ ){
            int w = (int)(graph[v].get(i) );

            if( !visited[w]){
                if(! dfs(graph,w,visited,onStack) ) return  false;
            }
            else if(onStack[w]){
                return false;//detect cycle
            }
        }
        onStack[v] = false;
        return true;
    }
    public boolean canFinishBFS2(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];
        //Initialize graph and create graph
        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList();

        for (int i = 0; i < prerequisites.length; i++) {
            int take = prerequisites[i][0];
            int pre = prerequisites[i][1]; //pre->take in graph,indegree means how many pres this course
            indegree[take]++;
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        //BFS
        int count =0;
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < numCourses; i++) {
            if(indegree[i]==0) queue.offer(i);
        }
        while(!queue.isEmpty()){
            int cur = queue.poll();
            count++;
            for(int neigh:graph[cur]){
                indegree[neigh]--;
                if(indegree[neigh]==0){
                    queue.offer(neigh);
                }
            }
        }
        return count == numCourses;
    }

    public static void main(String[] args){
        courseSchedule ins = new courseSchedule();
        System.out.println(ins.canFinishDFS(2, new int[][]{{0, 1}, {1, 0}}));
        System.out.println(ins.canFinishDFS(3, new int[][]{{0, 1}, {1, 2}}));
    }

}
