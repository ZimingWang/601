package ArraysStrings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lipingxiong on 10/9/15.
 */

public class zeroSumArr {
    public static void main(String[] args){
        zeroSumArr zs = new zeroSumArr();
        zs.largestZeroSumArr(new int[]{15, -2, 2, -8, 1, 7, 10, 23});
//        zs.largestZeroSumArr(new int[]{1, -2,2});
        //1,-1,0,    2 - (-1) = 3
    }
    public int largestZeroSumArr(int[] arr){
        int sum=0;
        int maxLen =0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(sum,-1);
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            System.out.println(sum);
            if(map.containsKey(sum)){
                int len = i - map.get(sum);
                maxLen = Math.max(len,maxLen);
            }
            else {
                map.put(sum, i);
            }
        }
        System.out.println(maxLen);
        return maxLen;
    }
}
