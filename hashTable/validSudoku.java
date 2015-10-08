package hashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lipingxiong on 8/23/15.
 */
public class validSudoku {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            if (!check(board,i,i,0,8)) return false;//check ith row, cols from 0 to 8
            if(!check(board,0,8,i,i)) return  false;// check ith col, row: 0-8
        }
        // check square
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++) {
                if (!check(board, i * 3, i * 3 + 2, j * 3, j * 3 + 2))
                    return false;// row and col indexs increase the same way
            }
        }
        return true;
    }
    private static boolean check(char[][] board, int row1,int row2,int col1, int col2){
        Set set = new HashSet<Character>();
        for(int i=row1;i<=row2;i++){
            for(int j=col1;j<=col2;j++){
                if(board[i][j]!='.') { // has value
                    if (set.contains(board[i][j])) return false; // find duplicate
                    else set.add(board[i][j]);
                }
            }
        }
        return  true;
    }

}

/*
public class Solution {
public boolean isValidSudoku(char[][] board) {
    for (int i=0; i<9; i++) {
        if (!isParticallyValid(board,i,0,i,8)) return false; // check a row
        if (!isParticallyValid(board,0,i,8,i)) return false; // check a col
    }
    for (int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            if (!isParticallyValid(board,i*3,j*3,i*3+2,j*3+2)) return false;
        }
    }
    return true;
}
private boolean isParticallyValid(char[][] board, int x1, int y1,int x2,int y2){
    Set singleSet = new HashSet();
    for (int i= x1; i<=x2; i++){
        for (int j=y1;j<=y2; j++){
            if (board[i][j]!='.') if(!singleSet.add(board[i][j])) return false;
        }
    }
    return true;
}
 */