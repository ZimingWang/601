package hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lipingxiong on 8/23/15.
 */
public class TwoSumUnsorted {

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<numbers.length;i++){
            int x= numbers[i];
            if(map.containsKey(target-x)){
                return new int[] { map.get(target - x) + 1, i + 1 };
            }
            map.put(x,1);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
/*
0.. ..  i-1-k...  ,i-1,i
k=3
0,1,2,3,4i
*/