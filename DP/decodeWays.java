package DP;

/**
 * Created by lipingxiong on 10/16/15.
 */
public class decodeWays {
    public static void main(String[] args)
    {
        decodeWays ins = new decodeWays();
        ins.numDecodings("00");
        ins.numDecodings("01");
        ins.numDecodings("09");
        ins.numDecodings("11");

    }
    public int numDecodings(String s) {
        char[] chs = s.toCharArray();
        int num1=1,num2=1,num3=1;

        for(int i=1;i<chs.length;i++){
            if(chs[i]=='0'){
                if(chs[i-1] =='1' || chs[i-1]=='2'){
                    num3=num1;
                }
                else if(chs[i-1]=='0') return 0;
            }
            else{
                if(chs[i-1]=='1'|| (chs[i-1]=='2' && chs[i]<=6)){
                    num3 = num1+num2;
                }
                else{
                    num3=num1;
                }
            }

            num1=num2;
            num2=num3;
        }
        System.out.println(num2);
        return num3;
    }

    public class Solution {
        public int numDecodings(String s) {
            int n = s.length();
            if (n == 0) return 0;

            int[] memo = new int[n+1];
            memo[n]  = 1;
            memo[n-1] = s.charAt(n-1) != '0' ? 1 : 0;

            for (int i = n - 2; i >= 0; i--)
                if (s.charAt(i) == '0') continue;
                else memo[i] = (Integer.parseInt(s.substring(i,i+2))<=26) ? memo[i+1]+memo[i+2] : memo[i+1];

            return memo[0];
        }
    }


}
