package hashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lipingxiong on 8/22/15.
 */
public class canPermutePalindrome {
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!set.contains(c)) {
                set.add(c);
            } else {
                set.remove(c);
            }
        }
        return set.size() == 0 || set.size() == 1;
    }
}
