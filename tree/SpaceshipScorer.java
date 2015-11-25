package tree;
import org.omg.PortableInterceptor.INACTIVE;

import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
import java.io.BufferedReader;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;


/**
 * Created by lipingxiong on 11/16/15.
 */
public class SpaceshipScorer {
    final static boolean debug = false;
    /*
    I used binary indexed tree to solve it.

    we traverse at most O(Logn) nodes in both getSum() and update() operations.
    Time complexity of cosnstruction is O(nLogn) as it calls update() for all n elements.
     */
    //binary indexed tree
    public static class BITree{
        int[] data; // To store the data of the tree
        BITree(int size){
            this.data = new int[size+1];
        }
        // Update the value of the tree nodes, add 1
        public void updateBinaryIndexedTree(int index){
            index = index + 1;
            while(index < data.length){
                data[index]++;
                index = getNext(index);
            }
        }

        // The range Sum(i, j) can be obtained through getSum(j) – getSum(i-1).
        public int getSum(int i,int j){
            if(i > 0) return  getSum(j) - getSum(i-1);
            else return getSum(j);
        }

        // Get the sum from data[0...index]
        public int getSum(int index){
            index = index + 1;
            int sum = 0;
            while(index > 0){
                sum += data[index];
                index = getParent(index);
            }
            return sum;
        }

        private int getParent(int index){
            return index - (index & -index);
        }

        private int getNext(int index){
            return index + (index & -index);
        }

    }
    static class RacerTime {
        int ID; // racer ID
        double time; //start or end
        boolean isStart; // is this time start time or not

        public RacerTime(int id, double time, boolean isStart) {
            this.ID = id;
            this.time = time;
            this.isStart = isStart;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n  = Integer.parseInt(in.nextLine());

        //arraylist save all racers records
        ArrayList<RacerTime> A = new ArrayList<RacerTime>();
        for(int i=0;i<n;i++){
            String line = in.nextLine().trim();
            String[] arr = line.split(" ");
            RacerTime t1 = new RacerTime(Integer.parseInt(arr[0]), Double.parseDouble(arr[1]),true);//startTime
            A.add(t1);
            RacerTime t2 = new RacerTime(Integer.parseInt(arr[0]), Double.parseDouble(arr[2]),false);//endTime
            A.add(t2);
        }

        //sort the A array by time
        Collections.sort(A, new Comparator<RacerTime>() {
            public int compare(RacerTime t1, RacerTime t2) {
                if (t1.time < t2.time)
                    return -1;
                else
                    return 1;
            }
        });

        if(debug) System.out.println("size of A: " + A.size());
        if(debug) {
            for (int i = 0; i < A.size(); i++) {
                System.out.println(A.get(i).ID + " " + A.get(i).time + " " + A.get(i).isStart);
            }
        }

        Map<Integer,Integer> scoreMap = new TreeMap<>();
        BITree bit = new BITree(A.size());

        HashMap<Integer,Integer> idToStartTime = new HashMap<>();

        for(int i=0;i<A.size();i++){
            if(A.get(i).isStart == true){
                idToStartTime.put(A.get(i).ID,i);
                if(debug) System.out.println(idToStartTime);
            }
            else{
                int startIdx = idToStartTime.get( A.get(i).ID) ;
                if(debug) System.out.println("startIdx=" + startIdx);

                int score = bit.getSum(startIdx,i);
                if(debug) System.out.println("score=" + score);

                scoreMap.put(A.get(i).ID, score);
                bit.updateBinaryIndexedTree(startIdx);

            }
        }
        if(debug) {
            for (Map.Entry<Integer, Integer> entry : scoreMap.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }

        // Convert map.entrySet() to list
        List<Map.Entry<Integer,Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>(scoreMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o1.getValue() == o2.getValue()) {
                    if(o1.getKey() < o2.getKey()) return  -1;
                    else return 1;
                }
                if(o1.getValue() < o2.getValue()) return -1;
                else return  1;
            }

        });

        Map.Entry<Integer, Integer> pair = null;
        for(int i=0;i < list.size();i++) {
            pair = list.get(i);
            System.out.println(pair.getKey() + " " + pair.getValue());
        }

    }


    /*
5
2 100 200
3 110 190
4 105 145
1 90 150
5 102 198
*/

}
