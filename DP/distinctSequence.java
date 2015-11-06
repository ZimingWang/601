package DP;

/**
 */
public class distinctSequence {
    public int numDistinct(String S, String T) {
        int n = S.length();
        int m = T.length();
        int t[][] = new int[m+1][n+1];
        for(int j=0;j<n;j++){
            t[0][j] = 1;
        }
        for(int i=1;i<=m;i++){ // T
            for(int j=1;j<=n;j++){ // S
                if(T.charAt(i-1) == S.charAt(j-1)){
                    t[i][j] = t[i-1][j-1] + t[i][j-1];
                }
                else{
                    t[i][j] = t[i][j-1];
                }
            }
        }
        return t[m][n];
    }
}
