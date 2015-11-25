import java.math.BigInteger;

/**
 * Created by lipingxiong on 11/19/15.
 */
public class additiveNum {
    public static void main(String[] args) {
        additiveNum a = new additiveNum();
        System.out.println(a.isAdditiveNumber("199100"));
    }
    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        for (int i = 1; i < len; i++) {
            for (int j=i+1; j<len; j++) {
                if (h(num, i, j - i) == true) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean h(String num, int l1, int l2){
        if (l1 + l2 > num.length()) return false; // already over
        String n1 = num.substring(0, l1);
        String n2 = num.substring(l1, l1 + l2);
        if (n1.length() != 1 && n1.charAt(0) == '0'
                || n2.length() != 1 && n2.charAt(0) == '0') {
            return false;
        }
        BigInteger sum = new BigInteger( n1).add(new BigInteger(n2));
        String ssum = sum.toString();
        int l3 = ssum.length();
        if (l1 + l2 + l3 > num.length()) {
            return false;
        }
        if (num.substring(l1 + l2, l1 + l2 + l3).equals(ssum)) {
            if (l1 + l2 + l3 == num.length()) return true;
            return h(num.substring(l1), l2, l3);
        } else {
            return false;
        }
    }
}
