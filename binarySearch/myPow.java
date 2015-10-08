package binarySearch;

/**
 * Created by lipingxiong on 8/23/15.
 x*x.....
 x^n/2*
 x
 x.x
2/2==1
 3/2==1
 5/2==2
 */
public class myPow {
    public double myPow(double x, int n) {
        if(n==0){
            return 1;
        }
        if(n==1){
            return x;
        }
        if(n<0){
            return 1.0/myPow(x,-n);
        }
        double temp = myPow(x,n/2);
        if(n%2==1) return temp*temp*x;
        return temp * temp;
    }
}
