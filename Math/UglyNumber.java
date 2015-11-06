package Math;

import java.util.ArrayList;

/**
 * Created by lipingxiong on 8/23/15.
 */
public class UglyNumber {
    public boolean isUgly(int num){
        if(num<=0) return false;
        if(num==1) return true;
        if(num%2==0) num /= 2;
        if(num%3==0) num /= 3;
        if(num%5==0) num /= 5;
        return num == 1;
    }
//    丑陋数序列可以拆分为下面3个子列表：
//
//            (1) 1×2, 2×2, 3×2, 4×2, 5×2, …
//            (2) 1×3, 2×3, 3×3, 4×3, 5×3, …
//            (3) 1×5, 2×5, 3×5, 4×5, 5×5, …
//    我们可以发现每一个子列表都是丑陋数本身(1, 2, 3, 4, 5, …) 乘以 2, 3, 5
//
    public static void main(String[] args){
        System.out.println(nthUglyNumber(13));
    }
    public static int nthUglyNumber(int n){
        int res[] = new int[n];
        res[0] = 1;
        int i2=0,i3=0,i5=0;
        int m2,m3,m5;

        for(int i=1;i < n;i++){
            m2 = res[i2] * 2;
            m3 = res[i3] * 3;
            m5 = res[i5] * 5;
            int m = Math.min( Math.min(m2,m3) , m5);
            if(m == m2){
                i2++;
            }
            if(m == m3){
                i3++;
            }
            if(m == m5){
                i5++;
            }
            res[i] = m;
            System.out.printf("%d,%d,%d,%d\n", m2, m3, m5, m);
        }
        com.com.ptrArr(res);
        return res[n-1];
    }

//        public static int nthUglyNumber(int n) {
//            int[] ugly = new int[n];
//            ugly[0] = 1;
//            int index2 = 0, index3 = 0, index5 = 0;
//            int factor2 = 2, factor3 = 3, factor5 = 5;
//            for(int i=1;i<n;i++){
//                int min = Math.min(Math.min(factor2,factor3),factor5);
//                ugly[i] = min;
//                System.out.printf("%d,%d,%d,%d\n", factor2, factor3, factor5, min);
//                if(factor2 == min)
//                    factor2 = 2*ugly[++index2];
//                if(factor3 == min)
//                    factor3 = 3*ugly[++index3];
//                if(factor5 == min)
//                    factor5 = 5*ugly[++index5];
//
//            }
//            return ugly[n-1];
//        }

}
