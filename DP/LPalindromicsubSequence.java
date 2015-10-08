package DP;

/**
 * Created by lipingxiong on 8/30/15.
 */
public class LPalindromicsubSequence {
    public static int calculate(char []str){
        int n = str.length;
        int[][] T=new int[n][n];
        // l ==1
        for(int i=0;i<n;i++){
            T[i][i] = 1;
        }
        int l=2;
        int j=0;
        while(l<=n) {
//            System.out.println(l);
            for (int i = 0; i <= n-l; i++) {
                j = i + l - 1;
                if(str[i]==str[j] && l==2) {
                    T[i][j] = 2;
                }
                else{
                    if (str[i] == str[j]) {
                        T[i][j] = T[i + 1][j - 1] + 2;
                    } else {
                        T[i][j] = Math.max(T[i + 1][j], T[i][j - 1]);
                    }
                }
            }
            l++;
        }
        return T[0][n-1];
    }
    public static String longestPalindrome(String s) {
        int n = s.length();
        String res = null;
        boolean[][] T = new boolean[n][n];
        // T[0][0] = true;
        int maxLen = 0;
        for(int j=0;j<n;j++){
            for(int i=0;i<=j;i++){
                if(s.charAt(i)==s.charAt(j) && (j-i<2 || T[i+1][j-1]) ){
                    T[i][j] = true;
                    if( (j-i+1) > maxLen) {
                        maxLen = j-i+1;
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        String s = "baadcaab";
//        System.out.println(calculate(s.toCharArray()) );
        s="cdbabd";
        System.out.println(longestPalindrome(s) );
    }
}
