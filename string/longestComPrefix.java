package string;

/**
 */
public class longestComPrefix {
    public static void main(String[] args) {
        String[] strs=null;
        strs = new String[]{"","",""};
        strs = new String[]{"ab","a","ad"};
        strs = new String[]{"abcd","ab"};
        strs = new String[]{"abcd",""};
        strs = new String[]{"","abcd",};
        longestCommonPrefix(strs);
    }

    public static String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        StringBuilder sb = new StringBuilder();
        int minLen = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            minLen = Math.min(minLen, strs[i].length());
        }
        if(minLen==0) return "";
        int i=0;
        while(i<minLen) {
            char ch = strs[0].charAt(i);
            int j=1;
            for (;j < n; j++) {
                if( strs[j].charAt(i)!=ch) break;
            }
            if(j<n)break;//mismatch
            sb.append(ch);
            i++;
        }
//        System.out.println(sb.toString());
        return sb.toString();
    }
}
