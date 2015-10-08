package DP;

/**
 * Created by lipingxiong on 9/5/15.
 */
public class minEditDistance {
    public int minDistance(String word1, String word2) {
        int  m =word1.length();
        int n=word2.length();
        int[][] T= new int[m+1][n+1]; //
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0) T[i][j]=j;
                if(j==0) T[i][j]=i;
                if(word1.charAt(i)==word2.charAt(j)){
                    T[i][j]=T[i-1][j-1];
                }
                else{
//                    T[][] =  + 1;
                }
            }
        }
        return T[m][n];
    }
}
