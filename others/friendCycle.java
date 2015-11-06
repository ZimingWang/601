package others;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by lipingxiong on 10/30/15.
 */
public class friendCycle {
        public static void main(String[] args) {
//            String[] friends = {"YYNN","YYYN","NYYN","NNNY"};
//            System.out.println(friendCircles(friends));

            Scanner in = new Scanner(System.in);
            int n  = Integer.parseInt(in.nextLine());
//            char[][] matrix=new char[n][n];
//
//            for(int i=0; i<n; i++) {
//                matrix[i] = in.nextLine().trim().toCharArray();
//            }
            String[] friends = new String[n];
            for(int i=0;i<n;i++){
                friends[i] = in.nextLine().trim();
            }
            for(int i=0;i<n;i++) {
                System.out.println(friends[i]);
            }
            in.close();
            System.out.println(friendCircles(friends));

        }
//        public static int friendCircles (String[] friends) {
//            if (friends == null || friends.length == 0) return 0;
//
//            int circles = 0, n = friends.length;
//            boolean[] visited = new boolean[n];
//            Queue<Integer> q = new LinkedList<Integer>();
//            q.offer(0);//0 is the index of first person in friends
//            visited[0] = true;
//
//            while (!q.isEmpty()) {
//                int curr = q.poll();
//                System.out.println("curr="+curr);
//                char[] currFriends = friends[curr].toCharArray();
//                for (int i = 0; i < currFriends.length; i++) {
//                    if (currFriends[i] == 'Y' && i != curr && !visited[i]) {
//                        System.out.println("inclue i="+i);
//                        q.offer(i);//i belongs the the circle with curr
//                        visited[i] = true;
//                    }
//                }
//                if (q.isEmpty()) {//find another component/circle
//                    circles++;
//                    System.out.println("circles="+circles);
//                    for (int i = 0; i < n; i++) {//offer next unvisited friend to the queue
//                        if (!visited[i]) {
//                            System.out.println("i="+i);
//                            q.offer(i);//create a new component
//                            visited[i] = true;
//                            break;
//                        }
//                    }
//                }
//            }
//            return circles;
//        }
    static int friendCircles(String[] friends) {
        if(friends == null || friends.length == 0) return 0;

        int circlesCount = 0;
        int n = friends.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(0);
        visited[0] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            char[] curFriends = friends[cur].toCharArray();
            for(int i=0;i<curFriends.length;i++){
                if(curFriends[i]=='Y' && i!=cur && !visited[i]){
                    q.offer(i);
                    visited[i]=true;
                }
            }
            if(q.isEmpty()){
                circlesCount++;
                for(int i=0;i<n;i++){
                    if(!visited[i]){
                        q.offer(i);
                        visited[i] = true;
                        break;
                    }
                }
            }
        }
        return circlesCount;

    }
    }
