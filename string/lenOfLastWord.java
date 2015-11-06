package string;

/**
 */
public class lenOfLastWord {
    public static int lengthOfLastWord(String s) {
        s=s.trim();
        if(s.length()==0) return 0;
        int i=s.length()-1;
        while(i>=0 && s.charAt(i)!=' ')i--;
        return s.length()-1-i;
    }
}
