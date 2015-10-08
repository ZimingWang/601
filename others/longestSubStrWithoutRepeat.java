package others;

import java.util.HashMap;

/**
 * Created by lipingxiong on 9/2/15.
 */
public class longestSubStrWithoutRepeat {
    public int lengthOfLongestSubstring(String s) {
        boolean[] exist = new boolean[256];
        int i = 0, maxLen = 0;
        // two pointer i, j; j 一路往前，遇到重复的，则i也往前，直到没有重复的。
        for (int j = 0; j < s.length(); j++) {
            while (exist[s.charAt(j)]) {
                exist[s.charAt(i)] = false;
                i++;
            }
            exist[s.charAt(j)] = true;
            maxLen = Math.max(j - i + 1, maxLen);
        }
        return maxLen;
    }
    public static int[] twoSum(int[] numbers, int target){
        HashMap<Integer,Integer> map = new HashMap();
        for (int i = 0; i < numbers.length; i++) {
            int x= numbers[i];
            if(map.containsKey(target - x)){
                return new int[]{ map.get(x)+1 , i+1};
            }
            map.put(x,i);
        }
        return new int[]{-1,-1};
    }
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while(! Character.isLetterOrDigit(s.charAt(i)))  i++;
            while(! Character.isLetterOrDigit(s.charAt(j)))  j--;
            if (Character.toLowerCase(s.charAt(i))
                    != Character.toLowerCase(s.charAt(j))) return false;
            i++;j--;
        }
        return true;
    }

}
