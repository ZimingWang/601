package ArraysStrings;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by lipingxiong on 10/22/15.
 * Given [100, 4, 200, 1, 3, 2],
 The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
100,4,200,1,3,2
 4,200,1,3,2
 200
 ()
3,
 2,
 1,


100,4,200,1,3,2
100,4,200,1,3,2
100,4,200,1,3,2
100,4,200,1,3,2
 */
public class longestConsecutive {
    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0)
            return 0;
        int max = 1;
        HashSet<Integer> set = new HashSet<>();
        for (int e :num){
            set.add(e);
        }
        int count=1;
        while(!set.isEmpty()){
            Iterator<Integer> iter = set.iterator();
            int cur =  iter.next();
            set.remove(cur);
            int i=cur-1;
            while(set.contains(i)){
                set.remove(i--);
                count++;
            }
            i=cur+1;
            while(set.contains(i)){
                set.remove(i++);
                count++;
            }
        }
        if(count > max) max=count;
        return max;
    }
}
