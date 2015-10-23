package string;

import java.util.Set;

/**
 * Created by lipingxiong on 10/13/15.
 */
public class strings {
    public static void main(String[] args) {
        strings ss = new strings();
        String S = "ADOBECODEBANC";
        String T = "ABC";
        System.out.println(palind(",A.aC"));
    }
    public static boolean palind(String s){
        int i=0,j=s.length()-1;
        while(i<j){
            while(!valid(s.charAt(i))) i++;
            while(!valid(s.charAt(j))) j--;
            char c1=lower(s.charAt(i));
            char c2=lower(s.charAt(j));
//            if( (lower(s.charAt(i) )!= lower(s.charAt(j)) ){
            if( c1!=c2 ){
                return false;
            }
            else if(i==j) return false;

            i++;j--;
        }
        return true;
    }
    public static char lower(char c){
        if(c<='Z'&&c>='A'){
            return (char)(c-'A'+'a');
        }
        return c;
    }
    public static boolean valid(char c){
        if(c<='Z'&&c>='A' || c<='z'&&c>='a') return true;
        return false;
    }


//    比较两个string,只有小写字母和数字，数字要连起来一起比较value,结果返回-1，0，1
//    "abc12", "abc34"
    /*
    a,c
    12,34
     */
//    public static int cmp(String s1,String s2){
//
//    }


}
