package DP;

/**
 * Created by lipingxiong on 8/23/15.
 1 0 1 0 0
 1 0 1 1 1
 1 1 1 1 1
 1 0 0 1 0
 */
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int m= matrix.length;
        int n=matrix[0].length;
        int res=0;
        int[][] T=new int[m+1][n+1];
        /*
        for(int i=0;i<m;i++){
            T[0][i] = (matrix[0][i]); // first row
        }
        for(int i=0;i<m;i++){
            T[i][0]=matrix[i][0];// first col
        }
        */

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(matrix[i-1][j-1]=='1'){
                    T[i][j]= 1 + Math.min(Math.min(T[i-1][j-1],T[i-1][j]),T[i][j-1] );
                    res = Math.max(res,T[i][j]);
                }
            }
        }
        return  res*res;
    }

    public static void main(String args[]) {

//        int arr[][] = {{0, 1, 1, 0, 1}, {1, 1, 1, 0, 0}, {1, 1, 1, 1, 0}, {1, 1, 1, 0, 1}};
//        char arr[][] = {{'0','1'},};
        char arr[][] = {{'1','1'},{'1','1'}};
        MaximalSquare ms=new MaximalSquare();
        System.out.println(ms.maximalSquare(arr));
    }
}
