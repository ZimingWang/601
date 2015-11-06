package sort;

/**
 * Created by lipingxiong on 10/13/15.
 */
public class sorts {
   public static void main(String[] args){
      wiggleSort(new int[]{3,5,2,1,6,4});
   }

   public static void wiggleSort(int[] nums){

      for(int i=0;i<nums.length;i++){
         System.out.printf("i=%d,nums[i]=%d\n",i,nums[i]);
         com.com.ptrArr(nums);

         if(i%2==1){
            if(nums[i] < nums[i-1]) swap(nums,i);
         }
         else if(i!=0 && nums[i] > nums[i-1] ){
            swap(nums,i);
         }

      }
      com.com.ptrArr(nums);
   }
   public static void swap(int[] nums, int i){
      int tmp=nums[i];
      nums[i]=nums[i-1];
      nums[i-1]=tmp;
   }

}
