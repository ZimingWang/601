package DP;

import java.util.Arrays;

/**
 * Created by lipingxiong on 10/14/15.
 */
public class boxStack {

    /*
        public Box[] createRotations(Box[] boxes){
            Box[] boxes = new Box[boxes.length * 3];
            int k=0;
            for(int i=0;i<boxes.length;i++){
                boxes[k++] = Box.createBox(boxes[i].height,boxes[i].length,boxes[i].width);
                boxes[k++] = Box.createBox(boxes[i].length,boxes[i].height,boxes[i].width);
                boxes[k++] = Box.createBox(boxes[i].width,boxes[i].height,boxes[i].width);
            }
            return boxes;
        }
        */
    public static int highestStack(int[][] matrix) {

//        Box[] boxes = createRotations(boxes);
        Box[] boxes = new Box[matrix.length];

        for (int i = 0; i < boxes.length; i++) {
            boxes[i] = new Box(matrix[i][0], matrix[i][1], matrix[i][2]);
        }
        Arrays.sort(boxes);
        int n = boxes.length;
        int[] T = new int[n];
        for (int i = 0; i < n; i++) {
            T[i] = boxes[i].height;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (boxes[j].length > boxes[i].length && boxes[j].width > boxes[i].width) {
                    T[i] = Math.max(T[i], T[j] + boxes[i].height);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0; i < T.length; i++){
            if(T[i] > max){
                max = T[i];
            }
        }

        return max;
    }

    static class Box implements Comparable<Box> {
        int width;
        int length;
        int height;

        Box(int x, int y, int z) {
            this.width = x;
            this.length = y;
            this.height = z;
        }

        Box() {
        }
//
//        Box createBox(int height, int side1, int side2) {
//            Box b = new Box();
//            b.height = height;
//            if (side1 > side2) {
//                b.length = side1;
//                b.width = side2;
//            } else {
//                b.length = side2;
//                b.width = side1;
//            }
//            return b;
//        }

        @Override
        public int compareTo(Box box) {
            if (this.length * this.width >= box.length * box.width)
                return -1;
            else return 1;
        }
    }


    public static void main(String[] args) {
//        boxStack bs = new boxStack();

        // W,L H
        int[][] matrix = new int[][]{
                {4, 2, 4},
                {2, 3, 2},
                {1, 1, 1},
                {4, 4, 1},
        };

//        Box input[] = { new Box(3, 2, 5), new Box(1, 2, 4) };
        System.out.println(highestStack(matrix));
//        bs.heightStack(input);
    }


}