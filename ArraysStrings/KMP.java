package ArraysStrings;

/**
 * Created by lipingxiong on 10/16/15.
 */
public class KMP {
    public static void main(String[] args){
        KMP ins = new KMP();
//        String s="acacab";
        String s="acacabacacabacacac";
        ins.create_lps(s);
    }

    /**
     * Compute temporary array to maintain size of suffix which is same as prefix
     * Time/space complexity is O(size of pattern)
     */
    int[] create_lps(String pattern){
        char[] chs = pattern.toCharArray();
        int n = pattern.length();
        int[] T = new int[n];
        int i=1,j=0;
        T[0]=0;
        while(i<n){
            if(chs[i]==chs[j]){
                T[i]=j+1;
                i++;j++;
            }
            else{
                if(j>0)j=T[j-1];//i unchanged
                else {
                    T[i]=0;
                    i++;
                }
            }
        }
        com.com.ptrArr(T);
        return T;
    }
    int patternSearch_KMP(String S,String P,int[] lps){
        char[] text = S.toCharArray();
        char[] pattern = P.toCharArray();
        int i=0,j=0;
        while(i<text.length){
            if(text[i]==pattern[j]){
                i++;
                j++;
            }
            else{
//                j不为0，则可以利用lps[j-1]中的信息，省去比较，i不变，j变成前缀长度。
                if(j!=0) {
                    j = lps[j - 1];
                }
                else {
                    i++; // 第一个字符就不匹配，则去匹配text中后面一个字符
                }

            }
        }
        return 0;

    }

}
