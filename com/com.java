package com;
/**
 * Created by lipingxiong on 10/16/15.
 */
public class com {
    public static void ptrArr(int[] num){
        for(int k=0;k<num.length;k++){
            System.out.print(num[k] + " ");
        }
        System.out.println();
    }
    public static void ptrArrLong(long[] num){
        for(int k=0;k<num.length;k++){
            System.out.print(num[k] + " ");
        }
        System.out.println();
    }

    public static void ptrStr(String[] num){
        for(int k=0;k<num.length;k++){
            System.out.print(num[k] + ",");
        }
        System.out.println();
        System.out.println("len="+num.length);
    }

    public static void ptrChar(char[] num){
        for(int k=0;k<num.length;k++){
            System.out.print(num[k] + ",");
        }
        System.out.println();
//        System.out.println("len="+num.length);
    }
    public static void ptrBoard(char[][] board) {
        for (int i = 0; i < board[0].length; i++) {
            ptrChar(board[i]);
        }
    }
    public static void ptrBoardInt(int[][] board) {
        for (int i = 0; i < board[0].length; i++) {
            ptrArr(board[i]);
        }
    }
}
