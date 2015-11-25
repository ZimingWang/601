package string;

/**
 * Created by lipingxiong on 11/21/15.
 * Question 1) Given a string, write a routine that converts the string to a long, without using the
 built in functions that would do this. Describe what (if any) limitations the code has. For
 example:
 In my solution, I make some assumptions:
1) when s is empty, return 0.
2) when overflow, if it's negative, return Long.MIN_VALUE; if it's positive, return Long.MAX_VALUE;
3) when there is invalid digit in the string, just return the use the valid characters before this invalid character.
 */
public class StringToLong {
    public long stringToLong(String s) {
        if(s == null) return 0;
        s = s.trim();
        if(s.length() == 0) return 0;
        boolean isNeg = false;
        int i = 0;
        // Handle sign
        if(s.charAt(0) == '-' || s.charAt(0) == '+') {
            i++;
            if(s.charAt(0) == '-') {
                isNeg = true;
            }
        }

        long res = 0;
        while(i < s.length()) {
            // deal with invalid digit
            if(s.charAt(i) < '0' || s.charAt(i) > '9') break;
            int digit = (int)(s.charAt(i) - '0');
            //  deal with overflow
            if(isNeg && res > -((Long.MIN_VALUE + digit) / 10)) {
                return Long.MIN_VALUE;
            } else if(!isNeg && res > (Long.MAX_VALUE - digit) / 10) {
                return Long.MAX_VALUE;
            }
            res = res * 10 + digit;
            i++;
        }
        return isNeg ? -res : res;
    }

    public static void main(String[] args) {
//        System.out.println(Long.MAX_VALUE);
//        System.out.println(Long.MIN_VALUE);
        StringToLong sTol = new StringToLong();
        System.out.println(sTol.stringToLong(""));
        System.out.println(sTol.stringToLong("-"));
        System.out.println(sTol.stringToLong("-1ab"));
        System.out.println(sTol.stringToLong("-0"));
        System.out.println(sTol.stringToLong("-023"));
        System.out.println(sTol.stringToLong("-123"));
        System.out.println(sTol.stringToLong("+123"));
        System.out.println(sTol.stringToLong("123"));

        System.out.println(sTol.stringToLong("9223372036854775806"));
        System.out.println(sTol.stringToLong("9223372036854775807"));
        System.out.println(sTol.stringToLong("9223372036854775808"));
        System.out.println(sTol.stringToLong("9223372036854775809"));
        System.out.println(sTol.stringToLong("92233720368547758090"));

        System.out.println(sTol.stringToLong("-9223372036854775807"));
        System.out.println(sTol.stringToLong("-9223372036854775808"));
        System.out.println(sTol.stringToLong("-9223372036854775809"));
        System.out.println(sTol.stringToLong("-92233720368547758090"));
    }

}
