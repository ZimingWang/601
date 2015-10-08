/**
 * Created by lipingxiong on 8/21/15.
 */
public class Strings {
    public static boolean isScample(String s1, String s2){
        if(s1.equals(s2)) return true;
        if(s1.length() != s2.length()) return false;
        int len = s1.length();
        int[] count = new int[26];
        for(int i=0;i<s1.length();i++){
            count[s1.charAt(i)-'a']++;
            count[s2.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++){
            if(count[i]!=0)  return false;
        }
        for(int i=0;i<s1.length();i++){
            if(isScample(s1.substring(0,i), s2.substring(0,i))
                    && isScample(s1.substring(i, len), s2.substring(i,len))){
                return true;
            }
            if(isScample(s1.substring(0,i), s2.substring(len-i))
                    && isScample(s1.substring(len-i), s2.substring(0,i))){
                return true;
            }

        }
        return false;
    }
}
