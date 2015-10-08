package graph;

/**
 * Created by lipingxiong on 8/21/15.
 */
public class numIslands {

    public static void main(String args[]){
            /*
    110
    100
    001
         */
        char[][] grid = {{'1','1','0'},{'1','0','0'},{'0','0','1'}};
//        grid[0][0]='1';
        System.out.println(numIslands(grid));
    }
    public static int numIslands(char[][] grid){
        if (grid==null) return 0;
        int m = grid.length;
        int n = grid[0].length;
        if(m==0 || n==0) return 0;
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public static void dfs(char[][] grid, int i, int j){
        int m=grid.length;
        int n=grid[0].length;
        if(i<0||j<0||i>=m||j>=n) return;
        if(grid[i][j]=='1') {
            grid[i][j]=0;
            dfs(grid,i-1,j);
            dfs(grid,i+1,j);
            dfs(grid,i,j-1);
            dfs(grid,i,j+1);
        }
    }

}
