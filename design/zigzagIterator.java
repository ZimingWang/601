package design;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by lipingxiong on 10/16/15.
 */

public class zigzagIterator {

    LinkedList<Iterator<Integer >> ites = null;

    public zigzagIterator( List<List<Integer>> lists) {
        Iterator  it = lists.iterator();
        while(it.hasNext()){
            List<Integer> list = (List<Integer>) it.next();
            ites.add(list.iterator());
        }
    }
//用一个list存iterators，每次去掉最头部的，取出元素后，如果该iterator 还有元素，就重新加入list
    public int next(){
        Iterator<Integer> curIt = ites.remove();
        int res = curIt.next();
        if(curIt.hasNext()) {
            ites.add(curIt);
        }
        return res;
    }
    public boolean hasNext(){
        return !ites.isEmpty();
    }
}
