package ArraysStrings;

/**
 * Created by lipingxiong on 10/2/15.
 */
public class maxSumNoAdjacent {
    public int maxSum(int[] arr){
        int excl = 0;
        int incl = arr[0];
        for(int i=1;i<arr.length;i++){
            int tmp = incl;
            incl = Math.max(tmp,excl+arr[i]);
            excl = tmp;
        }
        System.out.println(Math.max(incl,excl));
        return Math.max(incl,excl);
    }
    public static void main(String[] args){
        maxSumNoAdjacent ins = new maxSumNoAdjacent();
        ins.maxSum(new int[]{5, 5, 10, 100, 10, 5});
        ins.maxSum(new int[]{5,  5, 10, 40, 50, 35} );
    }
}
