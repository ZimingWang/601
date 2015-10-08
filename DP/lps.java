package DP;

/**
 * Created by lipingxiong on 9/1/15.
 */
public class lps {
    public static int lps(String s) {
        int n = s.length();
        int[][] T = new int[n][n];
        int j = 0;
        int res = 1;
        for (int l = 1; l <= n; l++) {
            for (int i = 0; i <= n-l; i++) {//Note the boundary of i.
                j = i + l - 1;
                if (i == j) {
                    T[i][j] = 1;
                    continue;
                }
                if (s.charAt(i) == s.charAt(j)) {
                    T[i][j] = T[i + 1][j - 1] + 2;
                } else T[i][j] = Math.max(T[i + 1][j], T[i][j - 1]);
                res = Math.max(res, T[i][j]);
            }
        }
        return res;
    }

    public static void main(String args[]) {
        System.out.println(lps("agbdba"));
    }
}
