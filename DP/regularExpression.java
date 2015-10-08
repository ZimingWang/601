package DP;

/**
 * Created by lipingxiong on 9/16/15.
 * n=s.len, m = p.len
 * for(int i = p.length() - 1; i>=0;i--) 这个循环是代表每次循环用p[i:]这段pattern去匹配s，
 * i==m-1 表示此时pattern是空字符，空字符一定能匹配空字符，所以mat[n]=true. 代表 p[m-1:] 一定能匹配 s[n-1:]
 * 用p[i:]这段pattern去匹配s的时候，此时的pattern能否匹配s[j:]，记录在mat[j]. 代表 p[i:] 能否匹配s[j:]
 * 下一轮循环要用到前一轮的结果，因为对mat是从后往前update，所以只需要一维就行。
 *
 */

public class regularExpression {
    public boolean regularExpression(String s,String p){
    boolean[] matching = new boolean[s.length() + 1];
    matching[s.length()]=true;
    for(int i = p.length() - 1; i>=0;i--)
    {
        /*
        p[i]=='*',要连同前面一个字符一起看，此时'x*'能代表0个字符，1个或者多个字符。
        0个字符:matching[j] = matching[j], 表示'x*'没起到任何作用
        1个字符：
         */
        if (p.charAt(i) == '*') {
            for (int j = s.length() - 1; j >= 0; j--){
                matching[j] = matching[j] || matching[j + 1] && (p.charAt(i - 1) == '.' || p.charAt(i - 1) == s.charAt(j));
            }
            i--;
        } else {
            for (int k = 0; k < s.length(); k++) {
                matching[k] = matching[k + 1] && (p.charAt(i) == '.' || p.charAt(i) == s.charAt(k));
            }
            matching[s.length()] = false;//这里为什么设置？pattern中已经出现了一个非*的字符，到此为止的pattern不可能再匹配空字符了。所以此位置都是要设置为false
        }
    }

    return matching[0];
}

    public boolean isMatch(String s,String p){
        boolean[] matching = new boolean[s.length() + 1];
        matching[s.length()]=true;
        for(int i = p.length() - 1; i>=0;i--)
        {
            if (p.charAt(i) == '*') {
                for (int j = s.length() - 1; j >= 0; j--){
                    matching[j] = matching[j] || matching[j + 1] ;//&& (p.charAt(i - 1) == '.' || p.charAt(i - 1) == s.charAt(j));
                }
//                i--;
            } else {
                for (int k = 0; k < s.length(); k++) {
                    matching[k] = matching[k + 1] && (p.charAt(i) == '?' || p.charAt(i) == s.charAt(k));
                }
                matching[s.length()] = false;
            }
        }

        return matching[0];
    }

}
