package ArraysStrings;

/**
 * Created by lipingxiong on 8/26/15.
 */
public class multyString {
    public String multiply(String num1, String num2) {
        int m=num1.length();
        int n=num2.length();
        int[] products = new int[m+n+1];
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int d1=num1.charAt(i)-'0';
                int d2=num2.charAt(i)-'0';
                products[i+j+1] += d1*d2;
            }
        }
        int carry = 0;
        for (int i = products.length - 1; i >= 0; i--) {
            int tmp=(products[i] + carry) % 10;
            carry = (products[i]+carry) / 10;
            products[i] = tmp;
        }
        StringBuilder sb = new StringBuilder();
        for(int p:products) sb.append(p);
        if(sb.length()!=0 && sb.charAt(0)=='0') sb.deleteCharAt(0);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
