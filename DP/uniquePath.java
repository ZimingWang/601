package DP;

/**
 * Created by lipingxiong on 10/23/15.
 */
public class uniquePath {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] t=new int[m][n];
        for(int j=0;j<n;j++){
            if(obstacleGrid[0][j]=='0') t[0][j] = 1;
            else break;;
        }
        for(int i=0;i<m;i++){
            if(obstacleGrid[i][0]=='0') t[i][0] = 1;
            else break;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j] == '1') t[i][j] = 0;
                else t[i][j] = t[i][j-1] + t[i-1][j];
            }
        }
        return t[m-1][n-1];
    }
}
