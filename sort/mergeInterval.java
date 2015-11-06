package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by lipingxiong on 10/30/15.
 */
public class mergeInterval {
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

//    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
//        ArrayList<Interval> res = new ArrayList<Interval>();  //
//        if (intervals == null || intervals.size() == 0)
//            return intervals;
//        Comparator<Interval> comp = new Comparator<Interval>(){
//            @Override
//            public int compare(Interval i1,Interval i2){
//                if(i1.start == i2.start){
//                    return i1.end-i2.end;
//                }
//                return i1.start - i2.start;
//            }
//        };
//        Collections.sort(intervals,comp);
//        res.add(intervals.get(0));
//        for(int i=1;i<intervals.size();i++){
//            if (res.get(res.size()-1).end >= intervals.get(i).start){
//
//            }
//        }
//    }
/*


 */
}
