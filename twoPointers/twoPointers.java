package twoPointers;

/**
 * Created by lipingxiong on 10/29/15.
 */
public class twoPointers {
    public static void main(String[] args){
        System.out.println(minSubArrayLen(4, new int[]{1, 4, 4}));
    }
    public static int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int i = 0;
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int j = 0;
        while(i<n){
            System.out.printf("i=%d,j=%d,sum=%d\n", i, j, sum);
            while( i<n && sum<s) sum += nums[i++];
            if(sum < s) break;
            System.out.println(i);
            while(j<i && sum>=s) sum -= nums[j++];
            System.out.println("j="+j);
            min = Math.min(min,i-j+1);
        }
        return min==Integer.MAX_VALUE ? 0 : min;
    }
}
