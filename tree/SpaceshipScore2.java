package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
     */
    public class SpaceshipScore2 {



//        Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>() {
//            public int compare(Map.Entry<Integer, Integer> o1,
//                               Map.Entry<Integer, Integer> o2) {
//                if(o1.getValue() == o2.getValue()){
//                    return o1.getKey() - o2.getKey();
//                }
//                return o1.getValue() - o2.getValue();
//            }
//
//        });


//    class Time {
//        long time;
//        boolean isStart;
//        int sid;
//    }
/* Enter your code here. Read input from STDIN. Print output to STDOUT */


        //binary indexed tree
        class BITree{

            public void updateBinaryIndexedTree(int binaryIndexedTree[], int val, int index){
                while(index < binaryIndexedTree.length){
                    binaryIndexedTree[index] += val;
                    index = getNext(index);
                }
            }
            public int getSum(int binaryIndexedTree[], int i,int j){
                if(i > 0) return  getSum(binaryIndexedTree,j) - getSum(binaryIndexedTree,i-1);
                return getSum(binaryIndexedTree,j);
            }
            /**
             * Start from index+1 if you want prefix sum 0 to index. Keep adding value
             * till you reach 0
             */
            public int getSum(int binaryIndexedTree[], int index){
                index = index + 1;
                int sum = 0;
                while(index > 0){
                    sum += binaryIndexedTree[index];
                    index = getParent(index);
                }
                return sum;
            }

            /**
             * Creating tree is like updating Fenwick tree for every value in array
             */
            public int[] createTree(int input[]){
                int binaryIndexedTree[] = new int[input.length+1];
                for(int i=1; i <= input.length; i++){
                    updateBinaryIndexedTree(binaryIndexedTree, input[i-1], i);
                }
                return binaryIndexedTree;
            }

            /**
             * To get parent
             * 1) 2's complement to get minus of index
             * 2) AND this with index
             * 3) Subtract that from index
             */
            private int getParent(int index){
                return index - (index & -index);
            }

            /**
             * To get next
             * 1) 2's complement of get minus of index
             * 2) AND this with index
             * 3) Add it to index
             */
            private int getNext(int index){
                return index + (index & -index);
            }

        }
        static class Racer {
            int ID;
            long start;
            long end;
            int score;
            public Racer(int id,long start,long end){
                this.ID = id;
                this.start = start;
                this.end = end;
            }
            public void setscore(int score){
                this.score = score;
            }
            public int getscore(){
                return this.score;
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
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = br.readLine();

            int n = Integer.parseInt(line);

            //arraylist save all racers records
            ArrayList<Racer> A = new ArrayList<Racer>();

            while ((line = br.readLine()) != null) {
                String[] k = line.split(" ");
                Racer r1 = new Racer(Integer.parseInt(k[0]), Long.parseLong(k[1]), Long.parseLong(k[2]));
                A.add(r1);
            }

            //sort the A array by start time decending
            Collections.sort(A, new Comparator<Racer>() {
                public int compare(Racer r1, Racer r2) {
                    if (r1.start > r2.start)
                        return -1;
                    else
                        return 1;
                }
            });

            System.out.println("A size is "+A.size());
            System.out.println(A.get(0).ID +" "+A.get(0).start );
        }



    }


