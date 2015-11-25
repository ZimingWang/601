package graph;

/**
 * Created by lipingxiong on 11/20/15.
 */
public class surroundedRegion {
    public static void main(String[] args){
        surroundedRegion s = new surroundedRegion();
        s.solve(new char[][]{
            {'X','X','X'},
            {'X','0','X'},
            {'X','X','X'},
        });

//        s.solve(new char[][]{
//                {'0'}
//        });

    }
    int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public void solve(char[][] board) {
        if(board==null || board.length==0 || board[0].length==0) return;
        int m = board.length;
        int n = board[0].length;
        for(int i =0;i<m;i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m-1 || j == 0 || j == n-1) {
                    if(board[i][j] == '0') dfs(board, i, j);
                }
            }
        }
//        com.com.ptrBoard(board);

        for(int i =0;i<m;i++){
            for (int j=0;j<n;j++){
                if(board[i][j] == '0'){
                    board[i][j] = 'X';
                } else if(board[i][j] == '1'){
                    board[i][j] = '0';
                }
            }
        }
//        com.com.ptrBoard(board);

    }
    private void dfs(char[][] board, int i, int j) {
        if(i< 0 || i>=board.length || j<0 || j>=board[0].length || board[i][j] != '0' ) return;
        System.out.println(board[i][j] + " "+ i + " " + j);
        board[i][j] = '1';
        for(int[] d : dir) {
            dfs(board, i + d[0], j + d[1]);
        }
    }

}
