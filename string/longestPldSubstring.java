package string;

/**
 * Created by lipingxiong on 10/25/15.
 */
public class longestPldSubstring {
    public static String longestPalindrome(String s) {
        if(s==null || s.length()==0) return "";
        int max=1;
        int n = s.length();
        String res = s.substring(0, 1);
        boolean[][] t = new boolean[n][n];

        for(int i=0;i<n;i++){
            t[i][i] = true;
        }

        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(s.charAt(i)==s.charAt(j) && (  j-i<2 || t[i+1][j-1]  )){
                    t[i][j] = true;
                    if(j-i+1 > max){
                        max= j-i+1;
                        res = s.substring(i,j+1);
                    }
                }
            }
        }
        return res;
    }
}
