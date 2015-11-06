package string;

/**
 */
public class atoi {
    public static void main(String[] args){
        System.out.println(myAtoi("+"));
        System.out.println(myAtoi("+1"));
    }
    public static int myAtoi(String str) {
        str=str.trim();
        int n=str.length();
        if(n==0) return 0;
        int sum=0;
        int i=0;
        int sign=1;

        if(str.charAt(0)=='-') {sign=-1;i++;}
        else if(str.charAt(0)=='+'){i++;}

        for(;i<n;i++){
            if(str.charAt(i)<'0' || str.charAt(i) >'9') return 0;
            int d = str.charAt(i) - '0';
//            System.out.println( "d="+ d );
            if( sum > (Integer.MAX_VALUE - d)/10)return Integer.MAX_VALUE;
            sum=sum * 10 + d;
        }
        return sum * sign;
    }
}
