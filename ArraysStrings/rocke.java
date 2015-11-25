package ArraysStrings;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lipingxiong on 11/24/15.
 */
public class rocke {
    public static void main(String[] args) {
        long l = -1;

        List<Long> list= new LinkedList<Long>();
// Fill list with numbers 1 to 499,999
//        for (long i = 1; i<500000;i++ ) {
////            list.add(i);
//        }

        System.out.println(foo(l, list));
    }

    public static boolean foo(long l, List<Long> list) {
        Integer startPos = null;
        Iterator<Long> iter = list.iterator();
        for (int i = 0; i <= list.size(); i++){
            if (list.get(i) < l) {
                startPos = i;
                break;
            }
        }

        if (startPos * 2 > 0.1 * list.size()) {
            return true;
        } else {
            return false;
        }
    }
}
