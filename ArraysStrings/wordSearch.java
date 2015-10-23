package ArraysStrings;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by lipingxiong on 10/23/15.
 */
public class wordSearch {
/*
    Given board =
    [
            ['A','B','C','E'],
            ['S','F','C','S'],
            ['A','D','E','E']
            ]
    word = "ABCCED", -> returns true,
    word = "SEE", -> returns true,
    word = "ABCB", -> returns false.
    */
    public static void main(String[] args){
        char[][]  board = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println(exist(board, "ABCCED"));
        System.out.println(exist(board, "SEE"));
        System.out.println(exist(board, "ABCB"));
    }
    public static boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0)
            return true;
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(search(board,i,j,visited,word,0)) return true;
            }
        }
        return false;
    }
    public static boolean search(char[][] board, int i,int j,boolean[][] visited,String word, int index){
        if(index == word.length()) return true;

        if( i<0 || i>=board.length || j<0 || j>=board[0].length || visited[i][j]
            || board[i][j] != word.charAt(index)){
            return false;
        }

        visited[i][j]=true;
        boolean res =     search(board,i-1,j,visited,word,index+1)
                || search(board,i+1,j,visited,word,index+1)
                || search(board,i,j-1,visited,word,index+1)
                || search(board,i,j+1,visited,word,index+1)
                ;

        visited[i][j] = false;
        return res;
    }

}
