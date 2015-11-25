package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * Created by lipingxiong on 11/18/15.
 */
public class courseSchedule22 {

    Stack<String> visited = new Stack<>();
    HashMap<String, ArrayList<String>> graph = new HashMap<>();
    Stack<String> reverseStack = new Stack<>();

    public static void main(String[] args){
        courseSchedule22 c = new courseSchedule22();
        String[] allCourse = new String[]{"C","D","R","I","S"};
        System.out.println(c.findOrder(allCourse));
    }
    public ArrayList<String> findOrder(String[] allCourses){
        String[][]  list = new String[][]{
                {"C","D"},
                {"S","I"},
                {"I","R"},
                {"D","R"},

        };
      for(String[] item : list){
          String pre = item[0];
          String take = item[1];
          if(!graph.containsKey(pre)){
              graph.put(pre,new ArrayList<String>());
          }
          graph.get(pre).add(take);
      }

        for(String course : allCourses){
            dfs(course);
        }
        ArrayList<String> res = new ArrayList<>();
//        for(String c : reverseStack){
//            res.add(c);
//        }
        while(!reverseStack.isEmpty()){
            res.add(reverseStack.pop());
        }
        return res;
     }

    public void dfs(String pre){
        if(visited.contains(pre)) return;
        visited.add(pre);
        if(graph.containsKey(pre)){
            for(String neigh : graph.get(pre)){
                if(!visited.contains(neigh)) {
                    dfs(neigh);
                }
            }
        }

        reverseStack.add(pre);
    }

}
