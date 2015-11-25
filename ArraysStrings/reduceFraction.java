package ArraysStrings;

/**
 * Created by lipingxiong on 11/9/15.
 */
public class reduceFraction {
    public static void main(String[] args){
        String[] arr = new String[]{"3/6","20/35"};
        String[] res = ReduceFraction(arr);

//        System.out.println(maxCommonDivisor(2,3));
//        System.out.println(maxCommonDivisor(3,6));
    }
    static String[] ReduceFraction(String[] fractions) {
        String[] res = new String[fractions.length];
        for(int i=0;i<fractions.length;i++) {
            String s = fractions[i];
            if(s.isEmpty()) res[i]="";
            String[] arr = s.split("/");
            int m = Integer.parseInt(arr[0]);
            int n = Integer.parseInt(arr[1]);
            int maxCom = gcd(m,n);
            res[i] = m/maxCom + "/" + n/maxCom;
//            System.out.println(res[i]);
        }
        return res;
    }
    public static int maxCommonDivisor(int m,int n){
        int num=1;
        while(num>0){
            num=m%n;
            m=n;
            n=num;
        }
        return m;
    }

    static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b%a, a);
    }

}
