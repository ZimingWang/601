package ArraysStrings;

/**
 * Created by lipingxiong on 10/21/15.
 * 2,3,1,2,4,3
 * j     i
 * 2,3,1,2,4,3
 *   j   i
 * 2,3,1,2,4,3
 *   j     i
 * 2,3,1,2,4,3
 *     j   i
 * 2,3,1,2,4,3
 *       j i
 * 2,3,1,2,4,3
 *       j   i
 * 2,3,1,2,4,3
 *         j i
 * 2,3,1,2,4,3
 *           ji
 1,2,3,4,5
 j       i
 1,2,3,4,5
       j i
 1,2,3,4,5

 1,2,3,4,5

 1,2,3,4,5
 */
public class minSubArrayLen {

    public static void main(String[] args){
//        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minSubArrayLen(11, new int[]{1,2,3,4,5}));
    }
    public  static int minSubArrayLen(int s, int[] nums) {
        int i=0;
        int n = nums.length;
        int minLen = n;
        int sum=0;
        int start = 0;

        while(i<n){
            // add,until sum > s
//            System.out.println("---j="+ start +"i="+i+"sum="+sum);
            while(i<n && sum<s) {
                sum+=nums[i];
                if(sum>=s) break;
                i++;
            }
            if(sum<s) break;
//                System.out.println("minLen="+minLen);
//                System.out.println("j="+ start +"i="+i+"sum="+sum);
            while(sum>=s) {
                sum -= nums[start++];
            }
            i++;
            minLen = Math.min(minLen, i - start + 1);
        }
//        System.out.println(minLen);
        return minLen;
    }

    public  static int minSubArrayLen2(int s, int[] nums) {
        int i=0;
        int n = nums.length;
        int minLen = n;
        int sum=0;
        int start = 0;

        while(i<n){
            // add,until sum > s
//            System.out.println("---j="+ start +"i="+i+"sum="+sum);
            while(i<n && sum<s) {
                sum+=nums[i];
                if(sum>=s) break;
                i++;
            }
            if(sum<s) break;
            //
            if(sum==s){
                minLen = Math.min(minLen,i-start+1);
//                System.out.println("minLen="+minLen);
//                System.out.println("j="+ start +"i="+i+"sum="+sum);
                sum-=nums[start++];
                if(sum<s) i++;
            }
            else {
                while(sum>s) {
                    sum -= nums[start++];
                }
                if(sum<s) i++;
//                System.out.println("sum="+sum +"j="+start);
            }

        }
//        System.out.println(minLen);
        return minLen;
    }
}
