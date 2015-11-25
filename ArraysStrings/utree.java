package ArraysStrings;

/**
 * Created by lipingxiong on 11/9/15.
 */
public class utree {
    public static void main(String[] args){
        get_Height(new int[]{0,1,2,3,4,5});
    }
//    static int[] get_Height(int[] N) {
//        int[] res = new int[N.length];
//        for (int i = 0; i < N.length; i++) {
//            int height = 1;
//            for (int j = 1; j <= N[i]; j++) {
//                if ((j % 2) == 1)
//                    height = height * 2;
//                else
//                    height++;
//            }
//            res[i] = height;
//            System.out.println(height);
//        }
//        return res;
//    }
    static int[] get_Height(int[] input) {
        int[] res = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            int n = input[i];
            if(input[i] % 2==0){
                res[i] = (int)Math.pow(2,n/2+1) - 1;
            }
            else{
                res[i] = (int)Math.pow(2,(n+1)/2+1 ) - 2;
            }
            System.out.println(res[i]);
        }
        return res;
    }

}
