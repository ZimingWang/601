package Math;

import java.util.ArrayList;
import java.util.Random;

/**
 */
public class maths {
    public static void main(String[] args){
//        System.out.println(isPalindrome(11) );
//        System.out.println(isPalindrome(12));
//        System.out.println(isPalindrome(121));
//        System.out.println(isPalindrome(3) );
//        System.out.println(isPalindrome(1021) );
//        myPow(3,1);
//        System.out.println(encode(65));
//        System.out.println(encode(4));
//        System.out.println(encode(5));
//        System.out.println(encode(6));
        maths m = new maths();
//        m.randomWeight(new int[]{});
//        assert();
    }


    public static String encode(int n){
        if(n<1) return "";
        StringBuilder res = new StringBuilder();
        ArrayList<Integer> fibNum = new ArrayList<>();
//        int index = 1;
        fibNum.add(1);
        fibNum.add(2);
        while(fibNum.get(fibNum.size()-1)<n){
            int m = fibNum.size();
            fibNum.add(fibNum.get(m-1) + fibNum.get(m-2) );
        }
        if(fibNum.get(fibNum.size()-1)>n) fibNum.remove(fibNum.size()-1); //remove the last
        for(int e:fibNum){
            System.out.println(e);
        }
        System.out.println(fibNum.size());
        int i=fibNum.size()-1;

        while(i>=0){
            System.out.printf("i=%d,fibNum=%d,n=%d\n", i, fibNum.get(i),n);
            if(fibNum.get(i) <= n){
                res.append("1");
                n -= fibNum.get(i);
            }
            else{
                res.append('0');
            }
            i--;
        }
        res = res.reverse();
        res.append("1");
        return res.toString();

    }

//    string encode (int n){
//        if(n < 1) return "";
//        string res;
//        vector<int> digits;
//        int index = 1;
//        digits.empalce_back(1);
//        digits.empalce_back(2);
//        while(digits.back() < n){
//            digits.emplace(digits[i], digits[i-1]);
//            index++;
//        }
//        while(index >= 0){
//            if(digits[index] <= n){
//                res.push_back('1');
//                n -= digits[index];
//            }
//            else{
//                res.push_back('0');
//            }
//            index--;
//        }
//        return res;
//    }

    public static boolean isPalindrome(int x) {
        if(x<0) return false;
        if(x==0) return true;
        int fac = 1;
        while(x/10 >= fac){
            fac = fac * 10;
        }
        System.out.println(fac);
        while(x > 0){
            if(x/fac != x%10) return false;
            x = (x%fac) / 10;
            fac /= 100;
        }
        return  true;
    }
    public static double myPow(double x, int n) {
        if(n==0) return 1;
        if(n<0) {
            x = 1/x;
            n = -n;
        }
        if(n==1)return x;

        double tmp = myPow(x,n/2);
        if(n%2==1){
            return x*tmp*tmp;
        }
        else
            return tmp*tmp;
    }
    public int sqrt(int x) {
        if(x==0) return 0;
        if(x<0) return -1;
        int l = 1;
        int r = x/2+1;
        while(l < r){
            int m = (l+r) /2;
            if(x/m<m && x/(m+1)<(m+1)){
                return  m;
            }
            else if(x/m<m) r = m-1; // m is too big
            else l = m+1;
        }
        return 0;
    }
    public int reverse(int x) {
        int res = 0;
        while(x>0){
            int newres = res * 10 + x % 10;
            if((newres - x%10) /10 != res) return 0;//overflow
            res = newres;
            x /=10;
        }
        return res;
    }
}
