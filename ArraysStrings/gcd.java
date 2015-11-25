package ArraysStrings;

/**
 * Created by lipingxiong on 11/9/15.
 */
public class gcd {
    public static void main(String[] args){
        System.out.println(getNumThree(10,5) );
        System.out.println(getNumThree(3, 6));
        System.out.println(getNumThree(4, 10));
    }
    public static int getNumThree(int m,int n){
        int num=1;
        while(num>0){
            num=m%n;
            m=n;
            n=num;
        }
        return m;
    }
}
