package string;

/**
 */
public class encodeWays {
    public int numDecodings(String s) {
        int n= s.length();
        int[] t= new int[n+1];
        t[n]=1;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i) == '0') t[i]=0 ;
            t[i] = (Integer.parseInt( s.substring(i,i+2))<=26) ? t[i+1]+t[i+2] : t[i+1];
        }
        return t[0];
    }

}
