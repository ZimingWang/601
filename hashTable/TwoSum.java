package hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lipingxiong on 8/23/15.
 */
public class TwoSum {
    private Map<Integer, Integer> map = new HashMap<>();
    public void add(int number) {
        int count = map.containsKey(number) ? map.get(number) : 0;
        map.put(number,count+1);
    }

    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int x = entry.getKey();
            int y= value - x;
            if(map.containsKey(y)){
                if(y!=x) return true;
                if(y==x && map.get(x)>1) {
                    return true;
                }
            }
        }
        return false;
    }
}