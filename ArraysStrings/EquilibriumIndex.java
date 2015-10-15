package ArraysStrings;

import java.util.ArrayList;

/**
 * Created by lipingxiong on 10/9/15.
 */
public class EquilibriumIndex {
    public static void main(String[] args){
//        EquilibriumIndex(new int[]{1,-1,1});
        EquilibriumIndex(new int[]{-7, 1, 5, 2, -4, 3, 0});
    }
    static ArrayList<Integer> EquilibriumIndex(int[] arr){
        int sum = 0;
        for(int e:arr){
            sum+=e;
        }
        ArrayList<Integer> res = new ArrayList<>();
        int left=0;
        for(int i=0;i<arr.length;i++){
            sum-=arr[i];
            if(sum==left){
                System.out.println(i);
                res.add(i);
            }
            left+=arr[i];
        }

        return res;
    }
}
