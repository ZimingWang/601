package Math;

/**
 */
public class missingNumber{
    public static void main(String[] args){
//        missingNumber(new int[]{0,1,3});
//        System.out.println( firstMissingPositive(new int[]{3,2,-3,-2}) );
//        System.out.println(firstMissingPositive(new int[]{4,3,2,1}));
//          System.out.println(firstMissingPositive(new int[]{1,2,3,4}));
        System.out.println( firstMissingPositive(new int[]{-255567, 1, -255678, -3123343,0}) );
    }

    public static int missingNumber(int[] nums) { //xor
        int res = nums.length;
        for(int i=0; i<nums.length; i++){
            System.out.println(i + " " +nums[i]);
            res ^= i;
            res ^= nums[i];

        }
        System.out.println("res="+res);
        return res;
    }

    public static int firstMissingPositive(int[] A) {
        int n = A.length;
        for(int i = 0; i < n; ++i)
//            while(A[i] > 0 && A[i] <= n && A[A[i] - 1] != A[i]) {
            while(A[i] > 0 && A[i] <= n && A[i]!=i+1) {
                System.out.printf("i=%d,A[i]=%d\n",i,A[i]);
                swap(A, i, A[i]-1);
                com.com.ptrArr(A);
            }

        for(int i = 0; i < n; ++ i)
            if(A[i] != i + 1)
                return i + 1;

        return n + 1;
    }
    public static void swap(int[] A,int i,int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }


}
