package ArraysStrings;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by lipingxiong on 10/17/15.
 */
public class threeSum {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num)
    {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(num==null || num.length<=2)
            return res;
        Arrays.sort(num);
        for(int i=num.length-1;i>=0;i--){
            ArrayList<ArrayList<Integer>> twoRes = twoSum(num,i-1,0-num[i]);
            for(ArrayList<Integer> list:twoRes){
                list.add(num[i]);
                res.add(list);
            }
        }
        return res;
    }
    public ArrayList<ArrayList<Integer>> twoSum(int[] num,int end,int target){
        int i=0,j=end;
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

        while(i<j){
            if(num[i]+num[j]==target) {
                ArrayList<Integer> item = new ArrayList<Integer>();
                item.add(num[i]);
                item.add(num[j]);
                res.add(item);
                i++;j--;
            }
            else if((num[i]+num[j]) > target){
                j--;
            }
            else i++;
        }
        return res;
    }
}
