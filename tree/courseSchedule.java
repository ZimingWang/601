package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lipingxiong on 8/25/15.
 Course Schedule Total Accepted: 14360 Total Submissions: 64823 My Submissions Question Solution
 There are a total of n courses you have to take, labeled from 0 to n - 1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 For example:

 2, [[1,0]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

 2, [[1,0],[0,1]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

 Note:
 The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 */

public class courseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Course[] courses = new Course[numCourses];// array of courses, n courses
        for (int i = 0; i < numCourses; i++) {
            courses[i] = new Course();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            //prerequisites[i][0] course want to take, prerequisites[i][1] pre
            courses[prerequisites[i][0]].add(courses[prerequisites[i][1]]); // A list of pre if want to take the course
        }
        for (int i = 0; i < numCourses; i++) {
            if(isCyclic(courses[i])) return false;
        }
        return true;
    }

    private boolean isCyclic(Course cur) {
        if (cur.tested == true) return false;
        if (cur.visited == true) return true;
        cur.visited = true;
        for (Course c : cur.pre) {
            if (isCyclic(c)) {//chech each pre to see if has cycle
                return true;
            }
        }
        cur.tested = true;
        return false;
    }
// a course represented as a class
    class Course {
        boolean visited = false;
        boolean tested = false;
        List<Course> pre = new ArrayList<Course>();// every course has a list of pre
        public void add(Course c) {
            pre.add(c);
        }
    }

}
