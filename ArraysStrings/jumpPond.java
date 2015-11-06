package ArraysStrings;

import java.util.HashSet;

/**
 * Created by lipingxiong on 10/23/15.
 */
public class jumpPond {
        // write your code in Java SE 8
    public static void main(String[] args){
        int[] A = new int[]{5,2};
        System.out.println(solution(A,5,3));

        System.out.println(solution(new int[]{1,3,1,4,2,5},7,3));
//        System.out.println(solution(new int[]{1,3,1,4,2,5},9,3));
        System.out.println(solution(new int[]{1,3,1,4,2,5},4,3));
    }
    public static int solution(int[] A, int X, int D) {
        // write your code in Java SE 8
        if(X <= D) return 0;
        HashSet<Integer>  set = new HashSet<>();

        int curPos = 0;
        for(int i=0;i<A.length;i++){

            if( A[i] > curPos && (A[i]-curPos) <= D ) curPos = A[i]; //can jump to
            else {
                set.add(A[i]);
            }
            for(int j=D;j>=1;j--){
                if(set.contains(curPos + D)) {
                    curPos = curPos + D;
                    break;
                }
            }
            if( D + curPos >= X ) return i;
        }

        return -1;
    }

}
