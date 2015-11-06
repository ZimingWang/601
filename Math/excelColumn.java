package Math;

/**
 */
public class excelColumn {
    public static void main(String[] args){
        System.out.println(convertToTitle(1));
        System.out.println(convertToTitle(2));
        System.out.println(convertToTitle(26));
        System.out.println(convertToTitle(27));
        System.out.println(convertToTitle(28));
        System.out.println(convertToTitle(29));
        System.out.println(convertToTitle(30));
    }
    public static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n>0){
            n--;
            sb.append( (char)(n%26 + 'A') );
            n /= 26;
        }
        return sb.reverse().toString();
    }

    public int titleToNumber(String s) {
        int res  = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            res = 26 * res + (int)(ch-'A'+1);
        }
        return  res;
    }

}
