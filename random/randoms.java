package random;

import java.util.Random;

/**
 * Created by lipingxiong on 11/17/15.
 */
public class randoms {
/*    {1,6,2,1}
1,7
1,7,9,10
(0,1],
(1-7]
 (7,9]
 */
    public static void main(String[] args){
        System.out.println(findCeil(new int[]{1,7,9,10},0) );
    }
    private static int findCeil(int[]freq, int key){
        int n = freq.length;
        int l = 0, r = n-1;
        while(l <= r){
            int m = l + (r-l)/2;
            if(key > freq[m]) {
                l = m + 1;
            }
            else if(key < freq[m]){
                r = m - 1;
            }
            else{
                return m;
            }
        }
        //A[l] will be the elem bigger than key
        return l;
    }

    public int generateRandom(int[] arr, int[] freq){
        int sum = 0;
        int n = freq.length;
        for(int i=1;i<freq.length;i++){
            freq[i] = freq[i-1] + freq[i];
        }
        int r = getRandom(freq[n-1]);
        int ceil = findCeil(freq,r);
        return arr[ceil];
    }

    /*
    产生 0-max的数字，如果想要1-max，就是在生成之后加上1
    http://www.javaguru.co/2014/12/how-to-generate-range-of-random.html
     */
    public int getRandom(int max){
        Random random = new Random();
        return random.nextInt(max+1); //0---max
//        for(int i=0;i<10;i++){
//            System.out.println(random.nextInt(9) + 1);
//        }
    }

/*
(a,1),(b,2)(c,3)
1,3,6
0-1---3----6
   */

    public int randomWeight(int[] arr,char[] vals){
        int n = arr.length;
        int[] sum = new int[n];
        sum[0] = arr[0];

        for(int i=1;i<arr.length;i++){
            sum[i] = sum[i-1]+arr[i];
        }
        int num = getRandom(sum[n-1]);
        int l=0,r=n-1;
        int index = 0;
        while(l<=r){
            int m = (l+r)/2;
            if(sum[m]==num) index = m;
            else if(sum[m] > num) r= m-1;
            else l=m+1;
        }
        return vals[index];
    }
}
