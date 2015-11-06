package sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by lipingxiong on 8/24/15.
 * heap顶部是最早结束的meeting，如果当前meeting 的开始时间比这个大，说明不需要新的room，否则需要新的room
 *
 */
public class minMeetingRooms {
//    * Definition for an interval.
    public class Interval {
        int start;
        int end;
        Interval(){start=0;end=0;}
        Interval(int s, int e){start=s; end =e;}
    }


//    public int minMeetingRooms(Interval[] intervals) {
//        Arrays.sort(intervals, new Comparator<Interval>() {
//            @Override
//            public int compare(Interval o1, Interval o2) {
//                return o1.start - o2.start;
//            }
//        });
//        // use min heap to keep track of the min end time of the meetings
//        // already found have to have
//        PriorityQueue<Interval> pq= new PriorityQueue<>(intervals.length,
//                new Comparator<Interval>() {
//                    @Override
//                    public int compare(Interval o1, Interval o2) {
//                        return o1.end - o2.end;
//                    }
//                }
//        );
//        pq.offer(intervals[0]);
//        Interval cur= new Interval();
//        for(int i=0;i<intervals.length;i++){
//            cur = pq.poll();
//            if(intervals[i].start < cur.end){
//                //need a new room
//                pq.offer(intervals[i]);
//            }
//            else{
//                //merge two intervals
//                cur.end = intervals[i].end;
//            }
//        }
//        pq.offer(cur);
//        return pq.size();
//    }

    /*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

        For example,
        Given [[0, 30],[5, 10],[15, 20]],
        return 2.
*/
    public int minMeetingRooms2(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;
        Comparator<Interval> cmp = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start; // sort by start time increasingly
            }
        };
        Arrays.sort(intervals, cmp);
        PriorityQueue<Interval> heap = new PriorityQueue<>(intervals.length, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end - o2.end;
            }
        });
        heap.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            Interval cur = intervals[i];
            Interval top = heap.poll();
            if(cur.start < top.end){
                // need new room
                heap.offer(cur);
            }
            else{
                top.end = cur.end; //merge two
            }
            heap.offer(top);
        }
        return heap.size();
    }
}

/*
  // Sort the intervals by start time
  Arrays.sort(intervals, new Comparator<Interval>() {
    public int compare(Interval a, Interval b) { return a.start - b.start; }
  });
 */