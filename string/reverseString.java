package string;

/**
 */
public class reverseString {
    public static void main(String[] args){
        System.out.println(reverseWords2("  the sky is   blue "));
    }
    public static String reverseWords(String s) {
        int i=0;
        s=s.trim();
        int n = s.length();
        if(n==0) return "";
        while(i<n && s.charAt(i)!=' '){
            i++;
        }
        String str = s.substring(0,i);
        String res = reverseWords( s.substring(i) );
        return  (res=="") ? str : res+ " "+ str;
    }
    public static String reverseWords2(String s){
        s=s.trim();
        int n = s.length();

        StringBuilder sb = new StringBuilder();
        for(int i=n-1;i>=0;i--){
            if(i>=0 && s.charAt(i)==' ' && s.charAt(i)==s.charAt(i+1)) continue;
            if(i<0) break;
            sb.append(s.charAt(i));
        }
        int left=0;
        int right=0;
        int m = sb.length();
        for(int i=0;i<m;i++){
            while( i<m && sb.charAt(i)!=' ' )i++;
            System.out.println(i);
            right = i-1;
            while(left<right){
                char tmp = sb.charAt(left);
                sb.setCharAt(left,sb.charAt(right));
                sb.setCharAt(right,tmp);
                left++;
                right--;
            }
            left = i+1;
        }
        return sb.toString();
    }
}
