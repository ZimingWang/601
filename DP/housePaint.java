package DP;

/**
 * Created by lipingxiong on 8/23/15.
 1: min(C00,C01,C02)
 2: second min
 3: all 3
 4:
 */
public class housePaint {

    public int minCost(int[][] costs) {
        if(costs==null || costs.length==0) return 0;
        for(int i=1; i< costs.length; i++){
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
        }
        int  n= costs.length;
        return Math.min(costs[n-1][0],Math.min(costs[n - 1][1], costs[n-1][2]));
    }
    public static int minCost2(int[][] costs) {
        if(costs ==null) return 0;
        int n = costs.length;
        if(n==0) return 0;
        int k = costs[0].length;

        int[][] T = new int[n + 1][k];
        int old_m1 = 0, old_m2 = 0;
        int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < k; j++) {
                if (T[i - 1][j] == old_m1) {
                    System.out.println("j=" + j);
                    T[i][j] = old_m2 + costs[i-1][j];
                } else {
                    T[i][j] = old_m1 + costs[i-1][j];
                }
                if (j == 0) {
                    m1 = T[i][j];
                } else {
                    if (T[i][j] < m1) m1 = T[i][j];
                    else if (T[i][j] < m2) {
                        m2 = T[i][j];
                    }
                }
            }
            old_m1 = m1;
            old_m2 = m2;
            System.out.println("m1 m2 "+m1+" "+m2);
        }
        ptr(T[1]);
        ptr(T[2]);
//        ptr(T[3]);
        return m1;
    }
    public static void ptr(int[] arr){
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public static void main(String[] args){
//        int[][] costts =new int[][]{{4,20,1,2}};
//        int[][] costts =new int[][]{{4,20,1,2},{10,3,5,7}};
//        int[][] costts =new int[][]{{4,20,1,2},{10,3,5,7},{2,10,3,4}};
        //[[1,5,3],[2,9,4]]
        int[][] costts =new int[][]{{1,5,3},{2,9,4}};
        System.out.println(minCost2(costts));
//[[11,20,4,3,19,3,18,17,6,8,18,18],[6,14,13,4,8,12,16,4,14,15,11,12],[8,1,4,20,19,9,12,11,13,12,1,3][8,12,9,3,1,14,3,16,12,13,4,10]]

    }
}
