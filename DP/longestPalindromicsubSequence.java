package DP;

/**
 * Created by lipingxiong on 8/30/15.
 * 先一个字符，然后2个字符，然后3个，l=m 个的时候，l=m-1个的表已经填好。 所以m个的时候只需要做一些判断就行。
 * T= N^2
 */
public class longestPalindromicsubSequence {

    public static void main(String[] args) {
        String s = "baadcaab";
//        System.out.println(calculate(s.toCharArray()) );
        s="cdbabd";
        System.out.println(longestPalindromesubSequence(s) );
    }

    public static int longestPalindromesubSequence(String s){
//        int l = 1;
        char[] arr = s.toCharArray();
        int n = arr.length;
        int[][] t = new int[n][n];

        for(int l=1; l<=n; l++){
            for(int i=0; i<=n-l; i++){
                int j = i+l-1;
                if(i == j) t[i][j] = 1;
                else {
                    if (arr[i] == arr[j]) {
                        t[i][j] = t[i + 1][j - 1] + 2;
                    }
                    else{
                        t[i][j] = Math.max(t[i+1][j],t[i][j-1]);
                    }
                }
            }
        }
        return t[0][n-1];
    }

//
//    public static int calculate(char []str){
//        int n = str.length;
//        int[][] T=new int[n][n];
//        // l ==1
//        for(int i=0;i<n;i++){
//            T[i][i] = 1;
//        }
//        int l=2;
//        int j=0;
//        while(l<=n) {
////            System.out.println(l);
//            for (int i = 0; i <= n-l; i++) {
//                j = i + l - 1;
//                if(str[i]==str[j] && l==2) {
//                    T[i][j] = 2;
//                }
//                else{
//                    if (str[i] == str[j]) {
//                        T[i][j] = T[i + 1][j - 1] + 2;
//                    } else {
//                        T[i][j] = Math.max(T[i + 1][j], T[i][j - 1]);
//                    }
//                }
//            }
//            l++;
//        }
//        return T[0][n-1];
//    }
//    public static String longestPalindrome(String s) {
//        int n = s.length();
//        String res = null;
//        boolean[][] T = new boolean[n][n];
//        // T[0][0] = true;
//        int maxLen = 0;
//        for(int j=0;j<n;j++){
//            for(int i=0;i<=j;i++){
//                if(s.charAt(i)==s.charAt(j) && (j-i<2 || T[i+1][j-1]) ){
//                    T[i][j] = true;
//                    if( (j-i+1) > maxLen) {
//                        maxLen = j-i+1;
//                        res = s.substring(i, j + 1);
//                    }
//                }
//            }
//        }
//        return res;
//    }


}
