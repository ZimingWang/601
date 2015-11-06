package greedy;

import DP.DPs;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by lipingxiong on 10/11/15.
 * cur opt + subp(n-i)
 */
public class greedys {
    int bestTimeBuy(int[] p) {
        int sum = 0;
        for (int i = 1; i < p.length; i++) {
            if (p[i] > p[i - 1]) {
                sum += p[i] - p[i - 1];
            }
        }
        return sum;
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int sum =0;
        int total = 0; //记录之前不合法的点，消耗的油量，其实是负数
        int tank =  0; //记录合法的开始处到当前的油量
        int start = 0; //合法的开始点

        for(int i=0;i<n;i++){
            tank = tank + gas[i]-cost[i];
//            tank<0说明从i开始无法进行下去，所以更新start=i+1，tank为0
            if(tank < 0){
                start = i+1;
                total += tank;
                tank = 0;
            }
        }
        return (tank+total<0)? -1 : start;
    }

    public static void main(String[] args){
        greedys g = new greedys();
        System.out.println(g.jump(new int[]{2,3,1,1,4}));
        System.out.println(g.jump(new int[]{1,2,3}));
        System.out.println(g.jump(new int[]{1,2}));
    }
    public int jump(int[] arr){
        Queue<Integer> q = new LinkedList<>();
        if(arr.length < 2) return 0;
        q.offer(0);
        int curMax = 0+arr[0];

        int nextMax = 0;
        int i=1;
        int level = 0;

        while(!q.isEmpty()){
            int cur = q.poll();
            level ++;
            if(curMax>=arr.length-1) return level;
            while(i <= curMax){
                q.offer(i);
                nextMax = Math.max(nextMax,i+arr[i]);
//                if(nextMax>=arr.length-1) return level+1;
                i++;
            }
            curMax = nextMax;
        }
        return -1;
    }

/*

    A = [2,3,1,1,4], return true.

    A = [3,2,1,0,4], return false.
    */
    boolean f(int[] nums){
        int max=0;
        for(int i=0;i<=max && i<nums.length;i++){
            int cur = i+nums[i];
            max=Math.max(max,cur);
            if(max>=nums.length-1) return true;
        }
        return  false;
    }

//    public static void main(String[] args){
//        greedys gd= new greedys();
//        int[] coins = new int[]{ 5, 10, 20, 50};
//        gd.minCoin(coins,70);
//    }

    public  int minCoin(int[] coins,int v){
        int[][] dp = new int[coins.length+1][v+1];
        for(int i=0;i<=coins.length;i++) {
            for (int j = 0; j <= v; j++) {
                if(i==0) dp[i][j] = v;
                else if (j == 0) dp[i][j] = 0;
                else {
                    if (j >= coins[i-1]) {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]]) + 1;
                    } else dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[coins.length][v]);
        return dp[coins.length][v];
    }

}
