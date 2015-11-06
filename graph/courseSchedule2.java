package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * Created by lipingxiong on 9/12/15.
 */
public class courseSchedule2 {
    //accepted my solution
    Stack<Integer> reversePost = new Stack<>();
    boolean hasCycle=false;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites==null) return new int[]{};
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();

        for(int i=0;i<prerequisites.length;i++){
            int take = prerequisites[i][0];
            int pre = prerequisites[i][1];
            if(!map.containsKey(pre)) map.put(pre,new ArrayList<Integer>());
            map.get(pre).add(take);
        }
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> stack = new HashSet<>();
        int[] res = new int[numCourses];

        for(int i=0;i<numCourses;i++) {
            if(hasCycle) return new int[]{};
            System.out.println("i="+i);
            if(!visited.contains(i)) dfs(map,i,visited,stack);
        }
        int i=0;
        while(!reversePost.isEmpty()){
            res[i++] = reversePost.pop();
        }
        return res;
    }
    public void dfs(HashMap<Integer,ArrayList<Integer>> map,int cur,
                              HashSet<Integer> visited, HashSet<Integer> stack) {
        System.out.println("cur="+cur);
        visited.add(cur);
        stack.add(cur);
        if (map.containsKey(cur)){
            System.out.println("cur in map="+cur);
            for (int neigh : map.get(cur)) {
                if (!visited.contains(neigh)) {
                    dfs(map, neigh, visited, stack);
                    visited.add(neigh);
                } else if (stack.contains(neigh)) {
                    hasCycle = true;
                    return;
                }
            }
        }
        stack.remove(cur);
        reversePost.push(cur);
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
