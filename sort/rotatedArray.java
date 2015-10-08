package sort;

/**
 * Created by lipingxiong on 9/24/15.
 */
public class rotatedArray {
    public static int findMin(int[] num) {
        if(num == null || num.length==0)
            return 0;
        int l = 0;
        int r = num.length-1;
        int min = num[0];
        while(l<r-1)
        {
            int m = (l+r)/2;
            if(num[l]<num[m])
            {
                min = Math.min(num[l],min);
                l = m+1;
            }
            else if(num[l]>num[m])
            {
                min = Math.min(num[m],min);
                r = m-1;
            }
            else
            {
                l++;
            }
        }
//        min = Math.min(num[r],min);
//        min = Math.min(num[l],min);
        return min;
    }
    public static void main(String args[]){
        System.out.println(findMin(new int[]{2,1}) );
    }
}
