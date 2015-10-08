package bitManipulation;

/**
 * Created by lipingxiong on 8/20/15.
 */
public class singleNumber {
    public static int singleNumber(int A[]){
        // a^a ==0, a^b!=0
        // abcab
//        int num=A[0];
        int num=0;
        for(int x: A){
            num ^=x;
        }
        return num;
    }
    public static void main(String args[]){
        System.out.println( singleNumber(new int[]{1,2,3,1,2}));
        System.out.println( (2^2) );
    }
}
