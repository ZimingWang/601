package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lipingxiong on 11/20/15.
 */
public class wallsGates {

    public static void main(String[] args){
        wallsGates w = new wallsGates();
        int INF = Integer.MAX_VALUE;
        w.wallsAndGates(new int[][]{
                {INF, -1,  0,  INF},
                {INF, INF, INF , -1},
                {INF, -1, INF,  -1},
                {0,  -1, INF, INF},
        });
    }

    HashSet<Integer> visited = new HashSet<>();
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++){
                if(rooms[i][j] == 0) {
                    bfs(rooms, i, j);
                    visited.clear();
                }
            }
        }
        com.com.ptrBoardInt(rooms);
    }
    private void bfs(int[][] rooms, int i, int j) {
        int[][] dir = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        int m = rooms.length;
        int n = rooms[0].length;
        Queue<Integer> queue = new LinkedList<>();
        int level = 1;
        int curNum = 1;
        int nextNum = 0;
        queue.offer(i * n + j);
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            visited.add(cur);
            curNum--;
            int row = cur / n;
            int col = cur % n;
            for(int[] d: dir) {
                int x = row + d[0];
                int y = col + d[1];
                if(valid(rooms, x, y)) {
                    queue.offer(x * n + y);
                    rooms[x][y] = Math.min(level, rooms[x][y]);
                    nextNum++;
                }
            }
            if(curNum == 0){
                curNum = nextNum;
                nextNum=0;
                level++;
            }
        }
    }

    private boolean valid(int[][] rooms, int i, int j){
        if(i<0 | i>=rooms.length || j<0 || j>=rooms[0].length) return false;
        if(rooms[i][j] > 0 && !visited.contains(i * rooms[0].length + j)) {
            return true;
        }
        return false;
    }    
}
