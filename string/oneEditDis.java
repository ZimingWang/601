package string;

/**
 * Created by lipingxiong on 10/25/15.
 */
public class oneEditDis {
    public boolean isOneEditDistance(String s, String t) {
        for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                //
                String s1=s.substring(i + (s.length() >= t.length() ? 1 : 0));
                String s2=t.substring(i + (s.length() <= t.length() ? 1 : 0));
                return s1.equals(s2);
            }
        }
        return Math.abs(s.length() - t.length()) == 1;
    }
}
