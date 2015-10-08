package ArraysStrings;

import java.util.ArrayList;

/**
 * Created by lipingxiong on 8/21/15.
 */
/*
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
 */
public class spiralMatrix {
    public static ArrayList<Integer> spiralMatrix(int[][] matrix){
        ArrayList<Integer> res= new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int levelNum = Math.min(m,n)/2;
        for(int level=0;level<levelNum;level++){
            for(int j=level;j<=n-1-level;j++){
                res.add(matrix[level][j]);
            }
            for(int i=level;i<=m-1-level;i++){
                res.add(matrix[i][n-1-level]);
            }
            for(int j=n-2-level;j>=level;j--){
                res.add(matrix[m-1-level][j]);
            }
            for(int i=m-2-level;i>=level+1;i--){
                res.add(matrix[i][level]);
            }
        }
        //odd
        if(levelNum%2==1){
            if(m<n) {
                int level = levelNum;
                for (int j = level; j <= n - 1 - level; j++) {
                    res.add(matrix[level][j]);
                }
            }
            else{
                for(int i=levelNum;i<=m-1-levelNum;i++){
                    res.add(matrix[i][levelNum]);
                }
            }
        }
        return res;
    }
/*
You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 */
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int levelNum = n/2;

        int num=1;
        for(int level=0;level<levelNum;level++) {
            for (int i = level; i<n-1-level; i++) {
                matrix[level][i]=num++;
            }
            for(int i=level;i<n-1-level;i++){
                matrix[i][n-1-level]=num++;
            }
            for(int i=n-1-level;i>level;i--){
                matrix[n-1-level][i]=num++;
            }
            for(int i=n-1-level;i>level;i--){
                matrix[i][level]=num++;
            }
        }
        if(levelNum%2==1){
            matrix[levelNum][levelNum] = num;
        }
        return matrix;
    }

}
