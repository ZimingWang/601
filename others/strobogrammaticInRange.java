package others;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
//from others.findStrobogrammatic import *;

/**
 * Created by lipingxiong on 8/22/15.
 */
public class strobogrammaticInRange {
    // Given low = "50", high = "100", return 3. Because 69, 88, and 96 are three strobogrammatic numbers.
    /*
[0, 1, 8]
[11, 69, 88, 96]
[101, 111, 181, 609, 619, 689, 808, 818, 888, 906, 916, 986]
[1001, 1111, 1691, 1881, 1961, 6009, 6119, 6699, 6889, 6969, 8008, 8118, 8698, 8888, 8968, 9006, 9116, 9696, 9886, 9966]
[10001, 10101, 10801, 11011, 11111, 11811, 16091, 16191, 16891, 18081, 18181, 18881, 19061, 19161, 19861, 60009, 60109, 60809, 61019, 61119, 61819, 66099, 66199, 66899, 68089, 68189, 68889, 69069, 69169, 69869, 80008, 80108, 80808, 81018, 81118, 81818, 86098, 86198, 86898, 88088, 88188, 88888, 89068, 89168, 89868, 90006, 90106, 90806, 91016, 91116, 91816, 96096, 96196, 96896, 98086, 98186, 98886, 99066, 99166, 99866]
[100001, 101101, 106901, 108801, 109601, 110011, 111111, 116911, 118811, 119611, 160091, 161191, 166991, 168891, 169691, 180081, 181181, 186981, 188881, 189681, 190061, 191161, 196961, 198861, 199661, 600009, 601109, 606909, 608809, 609609, 610019, 611119, 616919, 618819, 619619, 660099, 661199, 666999, 668899, 669699, 680089, 681189, 686989, 688889, 689689, 690069, 691169, 696969, 698869, 699669, 800008, 801108, 806908, 808808, 809608, 810018, 811118, 816918, 818818, 819618, 860098, 861198, 866998, 868898, 869698, 880088, 881188, 886988, 888888, 889688, 890068, 891168, 896968, 898868, 899668, 900006, 901106, 906906, 908806, 909606, 910016, 911116, 916916, 918816, 919616, 960096, 961196, 966996, 968896, 969696, 980086, 981186, 986986, 988886, 989686, 990066, 991166, 996966, 998866, 999666]
    m=2,
    n=3,
m=low.len
n=high.len
        System.out.println(findStrobogrammatic(1).size()); // size1=3
        System.out.println(findStrobogrammatic(2).size()); //size2=4
        System.out.println(findStrobogrammatic(3).size()); //size3=3*size2= 3* 4 = 12
        System.out.println(findStrobogrammatic(4).size()); //size4=5*size2= 5 *4 = 20
        System.out.println(findStrobogrammatic(5).size()); //size5=3*size4= 3* 20 = 60
        System.out.println(findStrobogrammatic(6).size()); //size6=5*size4 = 5*20 = 100

        50> 11,count--;
        100, count++;
*/

    public static int strobogrammaticInRange(String low, String high){
        //some corner cases
        if(Integer.parseInt(low) < 0) return 0;
        if(less(high,low)) return 0;

        int m=low.length();
        int n=high.length();

        int size=4; //size when n =2
        int count=0;
        for(int i=m;i<=n-1;i++){
            count+=getSize(i);
        }
        List<String> res;
        res=findStrobogrammatic.findStrobogrammatic(m);
        for(String s:res){
            if(less(s,low)){
                count--;
            }
        }
        res=findStrobogrammatic.findStrobogrammatic(n);
        for(String s:res){
            if(less(s,high) || s.equals(high)){  // <=
                count++;
            }
        }
        return count;

    }
    private static int getSize(int n){
        if(n==1) return 3;
        if(n==2) return 4;
        if(n%2==1){
            return 3 * getSize(n-1);
        }
        else{
            return 5 * getSize(n-2);
        }
    }
    // check whether a < b
    private static boolean less(String a, String b){
        if(a.length() != b.length())
            return a.length() < b.length();
        int i = 0;
        while(i < a.length() && a.charAt(i) == b.charAt(i))
            i++;
        return i == a.length() ? false: a.charAt(i) < b.charAt(i);
    }

    // Given low = "50", high = "100", return 3. Because 69, 88, and 96 are three strobogrammatic numbers.
    public static void main(String[] args){
        System.out.println(strobogrammaticInRange("0","0"));
        System.out.println(strobogrammaticInRange("50","100"));
        System.out.println(strobogrammaticInRange("50", "101"));
        System.out.println(strobogrammaticInRange("0", "2147483647"));
        System.out.println(less("11","11") );
        System.out.println(less("11","12") );
    }

//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);

//        System.out.println("2147483647".length());
//        System.out.println("6000000009".length());
//        System.out.println(Long.parseLong("6000000009") > Integer.parseInt("2147483647"));

//        Line 24: java.lang.NumberFormatException: For input string: "6000000009"
//        System.out.println(getSize(1));
//        System.out.println(getSize(2));
//        System.out.println(getSize(3));
//        System.out.println(getSize(4));
//        System.out.println(getSize(5));
//        System.out.println(getSize(6));

}
