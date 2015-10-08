package ArraysStrings;

import java.util.Arrays;

/*
Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition
 nums[i] + nums[j] + nums[k] < target.

For example, given nums = [-2, 0, 1, 3], and target = 2.

Return 2. Because there are two triplets which sums are less than 2:
[-2, 0, 1]
[-2, 0, 3]
i=0,j=len-1
while(i<=j){
A[i]+A[j]>=target, go left, j--; until Ai+aj<target,
then try to add a[i+1], aj[j-1];
) both < target, j--, try again,OR i++, try again
) a[j-1] nOT, j--
)a[i+1]NOT, j--

-2+3=1,
-2+3+0=1 OK
-2+3+1=2 NOT
-2+0+1=-1 OK

*/
public class ThreeSumSmaller{
    public static int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length <= 2)
            return 0;
        int count=0;
        Arrays.sort(nums);
        for(int k=2;k<nums.length-1;k++){
            int i=0;
            int j=k-1;
            while(i<j){
                if(nums[i] + nums[j] + nums[k] < target){
                    count+=j-i;
                    i++;
                }
                else{
                    j--;
                }
            }
        }
        return count;
    }
    public static void main(String[] args){
        System.out.println(threeSumSmaller(new int[]{-2, 0, 1, 3},2) );
        System.out.println(threeSumSmaller(new int[]{-2, 0, 1, 3}, 3));
//        [-1,0,1], 0
        System.out.println(threeSumSmaller(new int[]{-1,0,1}, 0));
//        [-2,0,1,3], 4
        /*
        -2+3=1 < 4,
        -2+3+1=2 < 4 OK
        -2+3+0=1 <4 OK
        -2+1+0=-1 OK
         */
        System.out.println(threeSumSmaller(new int[]{-2,0,1,3}, 4));
        /*
        [-1,1,-1,0], -1
        -1+1=0>  j--
        -1+0
         */
        System.out.println(threeSumSmaller(new int[]{-1,-1,0,1}, -1));
//        [2,0,0,2,-2], 2
        System.out.println(threeSumSmaller(new int[]{-2,0,0,2,2}, 2));
    }
    public static int threeSumSmallerNOTWork(int[] nums, int target){
        int i=0;
        int j=nums.length-1;
        Arrays.sort(nums);
//        ptrArr(nums);
        int count=0;
        while(i>=0 && j>=2 && i<j){
//            if(nums[i]+nums[j]+nums[j-1] >= target || nums[i]+nums[j]+nums[i+1] >= target ){
//                j--;
//            }
            if (nums[i]+nums[j]+nums[j-1] < target){
                count++;
            }
            if(j-1!=i+1 && nums[i]+nums[j]+nums[i+1] < target){
                count++;
            }
            j--;
        }
        return count;
    }

    public static void ptrArr(int[] nums){
        for(int n:nums){
            System.out.print(n + " ");
        }
        System.out.println();
    }

}
