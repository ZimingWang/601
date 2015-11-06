package string;

/**
 */
public class strstr {
    public static void main(String[] args){
        System.out.println(strStr("a","a"));
    }
    public static int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if(m==0) return 0;
        for(int i=0;i<=n-m;i++){
            int j=0;
            for(;j<m;j++){
                if(haystack.charAt(i+j) != needle.charAt(j)) break;
            }
            System.out.println(j);
            if(j==m) return i;
        }
        return -1;
    }
}
