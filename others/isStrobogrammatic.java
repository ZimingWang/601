package others;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lipingxiong on 8/21/15.
 */
public class isStrobogrammatic {
    public static void main(String[] args){
        String num="6";
        System.out.println(isStrobogrammatic2(num));
    }

    public static boolean isStrobogrammatic(String num) {
        int i=0;
        int j=num.length()-1;
        while(i<=j){
            if( !isSame(num.charAt(i),num.charAt(j), i, j) ) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static boolean isSame(char c1, char c2,int i,int j){
        Set<Character> charSet = new HashSet<Character>() {{
            add('0');
            add('1');
            add('8');
//            add('6');
//            add('9');
        }};
//        '0','1','8','6','9'}};
        if(i==j && (c1=='6' || c1=='9') ) return false;
        if(c1==c2 && charSet.contains(c1)) return true;
        if(c1=='6' && c2=='9' || c1=='9' && c2=='6' ) return true;
        return false;
    }
    public static boolean isStrobogrammatic2(String num) {
        for (int i=0, j=num.length()-1; i <= j; i++, j--)
            if (!"00 11 88 696".contains(num.charAt(i) + "" + num.charAt(j)))
                return false;
        return true;
    }

    public boolean isStrobogrammatic3(String num) {
        int start = 0;
        int end = num.length() - 1;
        while (start <= end) {
            switch(num.charAt(start)) {
                case '0':
                case '1':
                case '8':
                    if (num.charAt(end) != num.charAt(start)) {
                        return false;
                    }
                    break;
                case '6':
                    if (num.charAt(end) != '9') {
                        return false;
                    }
                    break;
                case '9':
                    if (num.charAt(end) != '6') {
                        return false;
                    }
                    break;
                default:
                    return false;
            }
            start++;
            end--;
        }
        return true;
    }

}

