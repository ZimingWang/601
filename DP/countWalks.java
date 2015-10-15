package DP;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lipingxiong on 10/14/15.
 */
public class countWalks {

    class Node {
        int i;
        int j;

        Node(int row, int col) {
            i = row;
            j = col;
        }
    }

    int BFS(char[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int curNum=0, nextNum=0,level=0,count=0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer( new Node(0,0) );
//        visited[0][0] = true;

        curNum=1;

        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            int i=cur.i;
            int j=cur.j;
            visited[i][j]=true;
//            System.out.println(i+"  " +j);

            if(i==m-1&&j==n-1) count++;
            curNum--;
            if(i>0  && matrix[i-1][j] == 'o'&& !visited[i-1][j]) {queue.offer( new Node(i-1,j)); nextNum++;}
            if(i<m-1 && matrix[i+1][j] == 'o'&& !visited[i+1][j]) {queue.offer( new Node(i+1,j));nextNum++;}
            if(j>0 && matrix[i][j-1] == 'o'&& !visited[i][j-1]) {queue.offer( new Node(i,j-1)); nextNum++;}
            if(j<n-1 && matrix[i][j+1] == 'o'&& !visited[i][j+1]) {
//                System.out.println(i+" "+j);
                queue.offer( new Node(i,j+1)); nextNum++;
            }
            if(curNum==0){
                level++;
                System.out.println("level=" + level + "nextNum="+ nextNum);
                curNum=nextNum;
                nextNum=0;
            }
        }
        level--;
        System.out.println(count % (long)(Math.pow(10,9)+7) );
        if(count==0) System.out.println(-1);
        else System.out.println(level);
        return level;
    }

    public static void main(String[] args){
        countWalks cw = new countWalks();
//        dp.cut_ord(new int[]{2,5,7,8},5);
        char[][] matrix={
                {'o','o','o'},
                {'o','x','o'},
//                {'o','o','o'},
//                {'o','o','o'},
        };

//        int m=1;
//        int n=3;
//        char[][] matrix=new char[m][n];
//        String s= "ooo";
//        for(int i=0;i<m;i++) {
//            matrix[i] = s.toCharArray();
//        }
//        int k = cw.BFS(matrix);
        cw.routingDP2(matrix);

//        countWalks(matrix,node1,node2,k);
    }
//    int countwalks(int graph[][], int u, int v, int k){

//    }
    public int routingDP(char[][] matrix){
        int m = matrix.length;
        int n=matrix[0].length;
        int[][] dp = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(matrix[i][j] =='x'){
                    dp[i][j] = Integer.MAX_VALUE;
                }
                else{
                    if(i==0&&j==0)dp[i][j]=0;
                    else if(i==0) dp[i][j]=dp[i][j-1] + 1;
                    else if(j==0) dp[i][j]=dp[i-1][j] + 1;
                    else dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + 1;
                }
            }
        }
        System.out.println(dp[m-1][n-1]);
        return 0;
    }

    public int routingDP2(char[][] matrix){
        int m = matrix.length;
        int n=matrix[0].length;
        int[][] ways = new int[m][n];
        for(int j=0;j<n;j++){
            if(matrix[0][j] == 'o') ways[0][j] = 1;
            else{
                while(j<n) ways[0][j++]=0;
            }
        }
        for(int i=0;i<m;i++){
            if(matrix[i][0] == 'o') ways[i][0] = 1;
            else{
                while(i<m) ways[i++][0] = 0;
            }
        }

        for(int i=1;i<m;i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 'x') {
                    ways[i][j] = 0;
                } else {
                    ways[i][j] = ways[i - 1][j] + ways[i][j - 1];
                }
            }
        }
        if(ways[m-1][n-1] ==0 ) System.out.println(-1);
        else System.out.println(ways[m-1][n-1] % (long)(Math.pow(10,9) + 7));
        return 0;
    }

}
