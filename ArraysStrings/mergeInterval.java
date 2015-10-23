package ArraysStrings;

import sort.minMeetingRooms.*;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by lipingxiong on 10/17/15.
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

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> res = new ArrayList<Interval>();  //
        if (intervals == null || intervals.size() == 0)
            return intervals;
        /*
        Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
end <= pre start :
         */
        Comparator<Interval> cmp = new Comparator<Interval>(){
            @Override
            public int compare(Interval i1, Interval i2){
                if(i1.start==i2.start){
                    return i1.end - i2.end;
                }
                else return i1.start - i2.start;
            }
        };
        res.add(intervals.get(0));
        for (int i = 0; i < intervals.size(); i++) {
            if (res.get(res.size() - 1).end <= intervals.get(i).start) {
                res.get(res.size() - 1).end = Math.max(res.get(res.size() - 1).end, intervals.get(i).end);
                ;
            } else {
                res.add(intervals.get(i));
            }
        }
        return res;
    }

//    public insertInterval(){
//
//    }

}
