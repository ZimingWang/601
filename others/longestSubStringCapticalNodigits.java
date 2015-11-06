package others;

/**
 */
public class longestSubStringCapticalNodigits {
    public static void main(String[] args){
        System.out.println(longestSubString("") );
        System.out.println(longestSubString("22D") );
        System.out.println(longestSubString("Ab34"));
//        System.out.println(longestSubString("ab"));
        System.out.println(longestSubString("23Ab456cDEf"));
        System.out.println(longestSubString("23Ab456cDEf8"));
    }
    public static int longestSubString(String s){
        if(s==null || s.length() == 0) return 0;
        int max = 0;
        int j = 0; // start of window
        int n = s.length();
        boolean flag =  false;
        int i=0;
        for(;i<n;i++){
//            System.out.println(j+" "+i);
            if(flag==true && Character.isDigit(s.charAt(i))) {
                max = Math.max(i-j,max);
                i++;
                j = i;
                flag = false;
            }
            while(i<n && Character.isDigit(s.charAt(i))) {
                i++;
                j++;
            }
//            j = i; //update start
            if(i==n) return max;
            if(flag==false && Character.isUpperCase(s.charAt(i))){
                 flag=true;
            }
        }
        if(flag && i==n) max = Math.max(i-j,max);
        return max;
    }
}
