import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lipingxiong on 11/3/15.
 */
public class Uber {
    class Pair{
        int row;
        int col;
        boolean visited;
        Pair(int i,int j){
            row=i;
            col=j;
            visited = false;
        }
    }
//    boolean bfs(int[][] matrix, Pair n1,Pair n2){
//        Queue<Pair> q = new LinkedList<>();
//        q.offer(n1); // start from n1
//        n1.visited = true;
//        while(!q.isEmpty()){
//            Pair cur = q.poll();
//            int i=cur.row; int j = cur.col;
//
//            if(i==n2.row && j==n2.col) return true;
//            if() q.offer( new Pair(i-1,j));
//            q.offer( new Pair(i+1,j));
//            q.offer( new Pair(i,j-1));
//            q.offer( new Pair(i,j+1));
//        }
//
//    }
}

