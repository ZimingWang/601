package ArraysStrings;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by lipingxiong on 8/16/15.
 */
public class myStrings {
    public static void main(String[] args){
//        System.out.println(isUniqueChar("hello") );

        char[] str = new char[20]; //" he llo".toCharArray();
        //str = " he llo".toCharArray();
//        System.out.println( replaceSpaces(str,str.length) );
        System.out.println(compressStr("aabcccccaaa"));
        System.out.println(compressStr("aab"));
        System.out.println(compressStr("abc"));
    }
    /*
    public boolean isRotation(String s1, String s2) {
        int len = s1.length();
        if(len == s2.length() && len > 0){
            String s1s1= s1+s2;
            return isSubString(s1s1,s2);
        }
        return false;
    }*/

    public void setZeros(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col= new boolean[n];
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    row[i]=true;
                    col[j]=true;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(row[i] || col[j]){
                    matrix[i][j]=0;
                }
            }
        }
    }

    /*
    1.5 Implement a method to perform basic string compression using the counts of repeated characters.
    For example, the string aabcccccaaa would become a2blc5a3.
     If the "compressed" string would not become smaller than the original string,
     your method should return the original string.
     */
    public static String compressStr(String s){
//        int last = ;
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<s.length();i++){
            if(s.charAt(i) == s.charAt(i-1)) {
                count++;
            }
            else{
                sb.append(s.charAt(i-1));
                sb.append(count);
                count=1;
            }
        }
        sb.append(s.charAt(s.length()-1));
        sb.append(count);
        if(sb.length() == s.length()*2) return s;
        else {
            return sb.toString();
        }
    }

    //
    public static String replaceSpaces(char[] str, int length){
        int spaceCount = 0;
        for(char c:str) {
            if(c ==  ' ') spaceCount++;
        }
        System.out.println(spaceCount);
        int newLen = length + 2*spaceCount;
        System.out.println(newLen);
        int j = newLen - 1;
        for(int i=length-1;i>=0;i--){
            if(str[i]!=' '){
                str[j--]=str[i];
            }
            else{
                j -=3;
//                i--;
                str[j]='%';
                str[j+1]='2';
                str[j+2]='0';
            }
        }
        return new String(str);
    }

    public static boolean isUniqueChar(String s){
        if(s.length() > 256) return false;
        boolean[] occured = new boolean[256];
        for(int i=0;i<s.length();i++) {
            int val = s.charAt(i);
            System.out.println(val);
            if ( occured[val] ) {
                return false;
            }
            occured[val] = true;
        }
        return true;
    }
    //Anagram
    public static String sortString(String s){
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
    public static boolean isPermutation(String s, String t){
        if(s.length() != t.length()) return false;
        return sortString(s).equals(sortString(t) );
    }


/*
    void reverse(char *str){
        char *end=str;
        char tmp;
        while(*end){
            end++;
        }
        end--;
        while(str<end){
            tmp = *str;
            *str = *end;
            *end = tmp;
            str++;
            end++;
        }
    }
    */

}
