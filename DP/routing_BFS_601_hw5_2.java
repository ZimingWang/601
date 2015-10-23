package DP;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * Created by lipingxiong on 10/14/15.
 */
public class routing_BFS_601_hw5_2 {
        long count=0;

        class Node{
            int i;
            int j;
            Node(int row,int col){
                i=row;
                j=col;
            }
        }
//        public static void main(String args[] ) throws Exception {
//        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
//            Scanner in = new Scanner(System.in);
//            String[] split = in.nextLine().split(" ");
//            int[] A = new int[split.length];
//            for(int i=0; i<split.length; i++)
//                A[i] = Integer.parseInt(split[i]);
//            int m=A[0];
//            int n=A[1];
//            if(m>0 && n>0){
//                char[][] matrix=new char[m][n];
//                //int N = Integer.parseInt(in.nextLine().trim());
//                //int[] T = new int[N];
//                for(int i=0; i<m; i++) {
//                    matrix[i] = in.nextLine().trim().toCharArray();
//                }
//                routing_BFS_601_hw5_2 slu=new routing_BFS_601_hw5_2();
//                slu.BFS(matrix);
//            }
//            in.close();
//
//        }
        public static void main(String[] args) {
//            countWalks cw = new countWalks();
//        dp.cut_ord(new int[]{2,5,7,8},5);
            routing_BFS_601_hw5_2 ins = new routing_BFS_601_hw5_2();
            char[][] matrix = {
                    {'o', 'o', 'o'},
                    {'o', 'x', 'x'},
//                    {'o','o','o'},
//                {'o','o','o'},
            };
            ins.BFS(matrix);
        }

        private int BFS(char[][] matrix){
            if(matrix==null) return 0;

            int m = matrix.length;
            int n = matrix[0].length;
            if(m==0||n==0) return 0;

            boolean[][] visited = new boolean[m][n];
            long[][] dp = new long[m][n];
            dp[0][0] = 1;
            long mod = (long)(Math.pow(10,9)+7);
//            System.out.println(mod);
            int curNum=0, nextNum=0,level=0;
            Queue<Node> queue = new LinkedList<>();
            queue.offer( new Node(0,0) );

            curNum=1;
            visited[0][0] = true;

            while(!queue.isEmpty()) {
                Node cur = queue.poll();
                int i = cur.i;
                int j = cur.j;
//                System.out.println(i+"  " +j);

                curNum--;

                if (i > 0 && matrix[i - 1][j] == 'o') {
                    if (!visited[i - 1][j]) {
                        queue.offer(new Node(i - 1, j));
                        nextNum++;
                        visited[i-1][j] = true;
                    } else {
                        dp[i][j] = dp[i][j] % mod;
                        dp[i][j] += dp[i - 1][j]%mod;
                    }
                }
                dp[i][j] = dp[i][j] % mod;

                if (i < m - 1 && matrix[i + 1][j] == 'o') {
                    if(!visited[i + 1][j]){
                        queue.offer(new Node(i + 1, j));
                        nextNum++;
                        visited[i+1][j] = true;
                    }
                    else {
                        dp[i][j] = dp[i][j] % mod;
                        dp[i][j] += dp[i+1][j]%mod;
                    }
                }
                dp[i][j] = dp[i][j] % mod;

                if(j>0 && matrix[i][j-1] == 'o') {
                    if(!visited[i][j-1]){
                        queue.offer( new Node(i,j-1));
                        nextNum++;
                        visited[i][j-1] = true;
                    }
                    else {
                        dp[i][j] = dp[i][j] % mod;
                        dp[i][j] += dp[i][j-1] % mod;
                    }
                }
                dp[i][j] = dp[i][j] % mod;

                if(j<n-1 && matrix[i][j+1] == 'o') {
                    if(!visited[i][j+1]){
                        queue.offer(new Node(i, j + 1));
                        nextNum++;
                        visited[i][j+1] = true;
                    }
                    else {
                        dp[i][j] = dp[i][j] % mod;
                        dp[i][j] += dp[i][j+1] % mod;
                    }
                }
                dp[i][j] = dp[i][j] % mod;

                if(matrix[i][j] == 'x') dp[i][j]=0;
//                System.out.println("i="+i+"j="+j+"dp[i,j]="+dp[i][j]);

                if(curNum==0){
                    level++;

                System.out.println("level=" + level + "nextNum="+ nextNum);
                    curNum=nextNum;
                    nextNum=0;
                }
            }
            level--;

            long res = dp[m-1][n-1] % mod;
            System.out.println(res);

            if(res==0) System.out.println(-1);
            else System.out.println(level);

            return 0;
        }

    }
