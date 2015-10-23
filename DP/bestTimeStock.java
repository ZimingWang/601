package DP;

/**
 * Created by lipingxiong on 10/21/15.
 */
public class bestTimeStock {

    public int maxProfit(int[] prices){
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            min  = Math.min(min,prices[i]);
            max = Math.max(max, prices[i]-min);
        }
        return max;
    }
}
