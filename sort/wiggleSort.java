package sort;

/**
 * Created by lipingxiong on 10/21/15.
 */
public class wiggleSort {

    public static void wiggleSort(int[] nums){
        for(int i=0;i<nums.length;i++){
            if(i%2==1){
                if(nums[i] < nums[i-1]) swap(nums,i);
            }
            else if(i!=0 && nums[i] > nums[i-1] ){
                swap(nums,i);
            }
        }
    }
    public static void swap(int[] nums, int i){
        int tmp=nums[i];
        nums[i]=nums[i-1];
        nums[i-1]=tmp;
    }
}
